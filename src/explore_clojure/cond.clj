(defn get-request [marker]
      (let [request {:MaxItems 1000}]
           (if (not-empty marker)
             (assoc request :Marker marker)
             request)))

(defn my-cond [marker marker2]
      (cond-> {:MaxItems 1000}
              marker
              (assoc :Marker marker)
              marker2
              (assoc :Marker2 marker)))


(get-request "teste")
(get-request nil)

(my-cond "teste" "test2")
(my-cond nil "nil")
(my-cond nil nil)

"cond->"
(cond-> 1          ; we start with 1
        true inc       ; the condition is true so (inc 1) => 2
        false (* 42)   ; the condition is false so the operation is skipped
        (= 2 2) (* 3)) ; (= 2 2) is true so (* 2 3) => 6

(defn divisible-by? [divisor number]
      (zero? (mod number divisor)))

(defn say [n]
      (cond-> nil
              (divisible-by? 3 n) (str "Fizz")
              (divisible-by? 5 n) (str "Buzz")
              :always             (or (str n))))

(say 1)
(say 3)
(say 5)
(say 15)
