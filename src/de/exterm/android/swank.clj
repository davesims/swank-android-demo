(ns de.exterm.android.swank
  (:use clj-android
	[swank.swank :as swank])
  (:import [android.widget TextView]))

(defmacro with-ui-thread
  "Run the given body form in the UI thread."
  [context & body]
  `(.runOnUiThread ~context (fn [] (do ~@body))))

(defn add-log-msg
  [context parent-view text]
  (let [tv (new android.widget.TextView context)]
    (.setText tv text)
    (.addView parent-view tv)))

(defn create-main
  [context]
  (let [ll (new android.widget.LinearLayout context)]
    (.setOrientation ll android.widget.LinearLayout/VERTICAL)
    (.addView ll (create-button context
				"Press me"
				(fn [] (add-log-msg context ll "works."))))
    (.setContentView context ll)))

(defactivity Main
  (:create
   (create-main context)
   (def de.exterm.android.swank/*context* context)
   (swank/start-repl 4005)))

(defn create-button
  [context label handler]
  (let [button (new android.widget.Button context)]
    (.setText button label)
    (on-click button (handler))
    button))