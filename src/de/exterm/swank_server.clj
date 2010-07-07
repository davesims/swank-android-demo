(ns de.exterm.swank_server
  (:use clj-android
	[swank.swank :as swank])
  (:import (android.widget TextView)))

(defactivity Main
  (:create
   (let [tv (new android.widget.TextView context)]
     (.setText tv "Clojure says: Take this REPL and hack on.")
     (.setContentView context tv))
   (def de.exterm.swank_server/context context)
   (swank/start-repl 4005)))
