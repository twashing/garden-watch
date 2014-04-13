(defproject garden-watch "0.1.6"
  :description "Garden source to CSS watcher and converter"
  :url "https://github.com/twashing/garden-watch"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :eval-in-leiningen true
  
  :dependencies [[com.taoensso/timbre "3.1.6"]
                 [filevents "0.1.0"]
                 [zengarden "0.1.7"]]

  :profiles {:dev {:source-paths ["dev" "src"]
                   :dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [missing-utils "0.1.1"]
                                  [alembic "0.2.1"]]}}

  :lein-release {:deploy-via :clojars})

