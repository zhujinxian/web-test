(defproject web-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [road "0.1.0-SNAPSHOT"]]
  :plugins [[zhu/leiningen-war "0.0.1"]]
  :war {:webxml "web.xml"}
  :uberwar {:webxml "web.xml"}
  :main web-test.core
  :aot [web-test.core])
