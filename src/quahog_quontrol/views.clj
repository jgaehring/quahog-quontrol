(ns quahog-quontrol.views
  (:require [clojure.string :as str]
            [hiccup.page :as page]
            [ring.util.anti-forgery :as util]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Quahog Quontrol | " title)]])

(defn home-page
  [{:keys [seconds]}]
  (page/html5
   (gen-page-head "Home")
   [:h1 "This is Quahog Quontrol"]
   [:p "Ready to recieve your transmission..."]
   [:form {:action "/" :method "POST"}
    (util/anti-forgery-field)
    [:h2 "Measurement Frequency"]
    [:label {:for "seconds"} "How many seconds between measurements?"]
    [:input {:id "seconds" 
             :type "number" 
             :name "seconds" 
             :value (or seconds 5)}]
    [:button {:type "submit"} "Submit"]]))