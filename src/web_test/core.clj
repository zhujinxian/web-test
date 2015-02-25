(ns web-test.core
  (:require [road.router :as router]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn -main [& args]
  (load-file "web.clj"))
