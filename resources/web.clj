(ns web.main
  (:use [road.router]))

(route-test "test web-test")

(defn handler [^Integer x]
  {:text (str "hello world, road goes sucess!" x)})

(defn home [req content ^Integer num]
  {:hiccup "home.clj" :content (str "home" content) :num num})

(defroutes app 
  (GET "/web-test-0.1.0-SNAPSHOT-standalone" handler)
  (GET "/home/:num{\\d+}" home))
