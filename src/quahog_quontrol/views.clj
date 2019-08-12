(ns quahog-quontrol.views
  (:require [clojure.string :as str]
            [hiccup.page :as page]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Quahog Quontrol | " title)]])

(defn home-page
  []
  (page/html5
   (gen-page-head "Home")
   [:h1 "This is Quahog Quontrol"]
   [:p "Ready to recieve your transmission..."]))