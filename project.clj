(defproject garden-watch "0.1.3"
  :description "Garden source to CSS watcher and converter"
  :url "https://github.com/twashing/garden-watch"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.taoensso/timbre "3.1.6"]
                 [filevents "0.1.0"]
                 [zengarden "0.1.5"]]

  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [missing-utils "0.1.1"]
                                  [alembic "0.2.1"]]}}

  :lein-release {:deploy-via :clojars})
