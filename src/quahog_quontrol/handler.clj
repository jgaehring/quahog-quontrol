(ns quahog-quontrol.handler
  (:require [quahog-quontrol.views :as views]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response content-type]]
            [ring.middleware.json :as json]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def data [{:title "123"}
           {:title "abc"}])

(defroutes app-routes
  (GET "/" [] (views/home-page))
  (GET "/q" [] (content-type (response data) "application/json"))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)
      (json/wrap-json-body)
      (json/wrap-json-response)))