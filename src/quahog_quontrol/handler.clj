(ns quahog-quontrol.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response content-type]]
            [ring.middleware.json :as json]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn wrap-dir-index [handler]
  (fn [req]
    (handler
      (update
        req
        :uri
        #(if (= "/" %) "/index.html" %)))))

(def data [{:title "123"}
           {:title "abc"}])

(defroutes app-routes
  (GET "/q" [] (content-type (response data) "application/json"))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)
      (json/wrap-json-body)
      (json/wrap-json-response)
      (wrap-dir-index)))