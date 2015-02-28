(ns web-test.core (:gen-class)
  (:use [road.router])
  (:require [road.core :as road] 
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]))

(defn foo
  "I don't do a whole lot."
  [x]
  (str "来自源码目录的参数：" x))

(defn handler [^Integer x]
    {:text (str "hello world, road goes sucess!" (foo x))})

(defn home [req content ^Integer num]
    {:hiccup "home.clj" :content (str "home" content) :num num})

(defmacro mhandler [] 
  (road/make-road-handler  aaa
                          (GET "/web-test-0.1.0-SNAPSHOT-standalone/main" handler)
                          (GET "/web-test-0.1.0-SNAPSHOT-standalone/home/:num{\\d+}" home)))

(defn -main [& args]
  (println (mhandler))
  (jetty/run-jetty (mhandler) {:port 3000}))
