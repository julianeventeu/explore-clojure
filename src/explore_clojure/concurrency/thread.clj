;; create an Atom with initially no money
(def donation-count (atom []))

(defn my-future []
  (let [wait (rand-int 5)]

    ;; wait x seconds
    (println (str "Waiting " wait " seconds ... "))
    (Thread/sleep (* wait 1000))

    ;; go collect $1
    (swap! donation-count conj {:wait wait})
    (println (str "We collected $" @donation-count " for now!"))

    )
  )

"Wait finish one to start other"
#_(future
 (dotimes [_ 9]
   (my-future))
 )

"Start all together"
(dotimes [_ 9]
  (future (my-future)))

;; wait three seconds
(Thread/sleep (* 3000 9))

(println (str "Array at the end: " @donation-count))
(println (str "Total itens at the end: " (count @donation-count)))
