(ns leiningen.garden-watch
  (:require [clojure.string :as string]
            [filevents.core :as filevents]
            [garden.core :as garden]))


(defn gen-css [from-path to-path]

  (def cdx (slurp from-path))
  (def cdx-form (read-string cdx))

  (def result-css (garden/css cdx-form))
  (spit to-path result-css))


(defn garden-watch [project & args]

  (let [input-dir (-> project :garden-watch :input-dir)
        output-dir (-> project :garden-watch :output-dir)

        inputargs-in-map (apply array-map args)
        input-args-withrealkeywords (into {}
                                          (for [[k v] inputargs-in-map]
                                            (let [intermediate-key (if (= \: (first k))
                                                                     (string/replace-first k #":" "")
                                                                     k)
                                                  final-key (keyword intermediate-key)]
                                              [final-key v])))
        input-override (:input-dir input-args-withrealkeywords)
        output-override (:output-dir input-args-withrealkeywords)

        input-final (if input-override input-override input-dir)
        output-final (if output-override output-override output-dir)]


    (if-not (and input-final output-final)
      (println "ERROR: both :input-dir and :output-dir not specified. Exiting")
      (do

        (println "garden-watch started...")

        ;; Watch the directory
        (filevents/watch
         (fn [kind file]

           (if-not (= :delete kind)
             (if (or (re-find #"\.edn" (.getName file))
                     (re-find #"\.clj" (.getName file)))
               (do

                 (println "garden-watch[" kind "]: " file)
                 (let [input-file-extension (if (re-find #"\.edn" (.getName file)) #"\.edn" #"\.clj")
                       output-file-name (str output-final
                                             java.io.File/separator
                                             (string/replace-first (. file getName) input-file-extension "")
                                             ".html")]
                   (gen-css file output-file-name))))))
         input-final)


        ;; Kludge to block leiningen from exiting... yes, I know it's bad
        (loop []
          (Thread/sleep 100)
          (recur))))))
