(ns day5.comment
  (:require [compojure.core :refer [context defroutes GET POST]]
            [day5.db :as db]
            [hiccup.core :refer [html]]))

(defroutes handler
  (context "/comments" []
    (GET "/" []
       (html
         [:div
           [:form {:action "/comments" :method "POST"}
             [:input {:type "text" :name "user"}]
             [:input {:type "text" :name "content"}]
             [:input {:type "submit"}]]
           (for [comment (db/find-comments)]
             [:p (str (:user comment) " / " (:content comment))])]))

    (POST "/" [user content]
      (db/insert-comment {:user user :content content})
      {:status 302 :headers {"Location" "/comments"} :body ""})

    (GET "/lists" []
      (html
        (for [commen (db/find-comments)]
         [:p (str (:user commen) " / " (:content commen))])))))
