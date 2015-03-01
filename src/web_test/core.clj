(ns web-test.core (:gen-class)
  (:use [road.router])
  (:require [road.core :as road]
            [ring.middleware.params :as params]
            [ring.util.response :as resp]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]))

(defn render-test [ret tmt]
  (-> (resp/response "------render----test------") 
    (#(resp/content-type %1 "text/plain"))))

(defn foo
  "I don't do a whole lot."
  [x]
  (str "来自源码目录的参数：" x))

(defn handler [^Integer x]
    {:$r render-test :text (str "hello world, road goes sucess!" (foo x))})

(defn home [req content ^Integer num]
    {:hiccup "home.clj" :content (str "home" content) :num num})


(defn mhandler [] 
  (road/defroad           (GET "/web-test-0.1.0-SNAPSHOT-standalone/main" handler)
                          (GET "/web-test-0.1.0-SNAPSHOT-standalone/home/:num{\\d+}" home)))

(def road-handler (mhandler))

(defn -main [& args]
  (println (mhandler))
  (jetty/run-jetty road-handler {:port 3000}))
