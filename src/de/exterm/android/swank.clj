(ns de.exterm.android.swank
  (:use clj-android
	[swank.swank :as swank])
  (:import (android.widget TextView)))

(defactivity Main
  (:create
   (let [tv (new android.widget.TextView context)]
     (.setText tv "Clojure says: Take this REPL and hack on.")
     (.setContentView context tv))
   (swank/start-repl 4005)))
