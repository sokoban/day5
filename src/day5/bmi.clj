(ns day5.bmi
  (:require [compojure.core :refer [defroutes GET POST]]
            [hiccup.core :refer [html]]
            [compojure.coercions :refer [as-int]]))

(defn bmi [height weight]
  (let [bmi (float (/ weight (/ (* height height) 10000)))]
    (cond
      (< bmi 18.5) "저체중"
      (< bmi 30) "보통"
      (< bmi 35) "과체중"
      :else "비만")))

(defroutes handler
  (GET "/bmii" []
    (html [:form {:action "/bmi" :method "POST"}
           [:div [:input {:type "text" :name "height"}]]
           [:div [:input {:type "text" :name "weight"}]]
           [:div [:input {:type "submit"}]]]))

  (POST "/bmi" [height :<< as-int weight]
     (bmi height weight)))
