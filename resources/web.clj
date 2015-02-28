(ns web.main
  (:use [road.router]))

(defn handler [^Integer x]
  {:text (str "hello world, road goes sucess!" x)})

(defn home [req content ^Integer num]
  {:hiccup "home.clj" :content (str "home" content) :num num})

(defroutes app 
  (GET "/web-test-0.1.0-SNAPSHOT-standalone/main" handler)
  (GET "/web-test-0.1.0-SNAPSHOT-standalone/home/:num{\\d+}" home))
