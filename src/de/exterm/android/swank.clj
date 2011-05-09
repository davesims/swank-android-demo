(ns de.exterm.android.swank
  (:use clj-android
	[swank.swank :as swank])
  (:import (android.widget TextView)))

(defn calculate
  [context parent-view a b]
  (let [tv (new android.widget.TextView context)]
    (.setText tv (str a " + " b " = " (+ a b)))
    (.addView parent-view tv)))

(defn create-main
  [context]
  (let [ll (new android.widget.LinearLayout context)
	button (new android.widget.Button context)]
    (.setOrientation ll android.widget.LinearLayout/VERTICAL)
    (.setText button "Calculate with 7 and 6")
    (on-click button (calculate context ll 7 6))
    (.addView ll button)
    (.setContentView context ll)))

(defactivity Main
  (:create
   (create-main context)
   (def de.exterm.android.swank/context context)
   (swank/start-repl 4005)))

(defn reload
  [context activity]
  (let [intent (new android.content.Intent context activity)]
    (.startActivity context intent)))
