(ns web-test.core (:gen-class)
  (:use [road.core])
  (:require [road.core :as road]
            [ring.middleware.params :as params]
            [ring.util.response :as resp]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]
            [ring.adapter.jetty :as jetty]))

(defn render-test [ret tmt]
  (-> (resp/response "------render----test------") 
    (#(resp/content-type %1 "text/plain"))))

(defn foo
  "I don't do a whole lot."
  [x]
  (str "来自源码目录的参数：" x))

(defn handler [^Integer x y]
    {:$r render-test :text (str "hello world, road goes sucess!" (foo x) (* x y))})

(defn home [req content ^Integer num]
    {:hiccup "home.clj" :content (str "home" content) :num num})

(defroad road (GET "/web-test-0.1.0-SNAPSHOT-standalone/main" handler) (GET "/web-test-0.1.0-SNAPSHOT-standalone/home/:num{\\d+}" home))
 

(defn -main [& args]
  (log/info "---------log4j test-------")
  (jetty/run-jetty road {:port 3000}))
