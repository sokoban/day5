(ns day5.core
  (:require [immutant.web :refer [run]]
            [compojure.core :refer [defroutes]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.api.sweet :refer [api GET POST]]
            [ring.util.http-response :refer [ok]]
            [day5.bmi :as bmi]
            [day5.comment :as comment]))

(def PayLoad
  {:chatId Long
   :authorId Long
   :message String
   :nickname String
   :ldapId String
   :type Long})


(def handler
  (api
    {:swagger {:ui "/swagger-ui"
               :spec "/swagger.json"}}

    (POST "/callback" []
        :body [payload PayLoad]
        (ok {:chatId (:chatId payload)
             :messages (if (= "!aaa" (:message payload))
                         ["클로저만세"])}))

    (GET "/tools" []
        (ok {:message "ok"}))

    (GET "/tools2" []
        (ok {:message "ok"}))))

;(defn -main [& args]
;  (run #(handler %) {:host "0.0.0.0"}))

(defroutes handler
  bmi/handler
  comment/handler)

(defn -main [& args]
  (run (wrap-params handler)))
