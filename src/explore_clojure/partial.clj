(def my-vector [1 2 3 4 5])

(map #(even? %) my-vector)



(map (partial even?) my-vector)

(map even? my-vector)

(->> my-vector
     (map even?))

(comp (map even?))

(def my-mapa {:a "1" :b "2"})
(def my-mapa {})

(if (seq my-mapa)
  (println "not empty" my-mapa)
  (println "is empty" my-mapa))

(->> [1 2 3 4 5]
     (filter even?)
     (filter #(or (= 2 %)
                  (= 4 %))))

(->> [1 2 3 4 5]
     (filter even?)
     (filter (some-fn #(= 2 %)
                      #(= 4 %))))

(->> [1 2 3 4 5]
     (filter even?)
     (filter #{2 4}))

(into []
      (comp (filter even?)
            (filter #{2 4}))
      [1 2 3 4 5])

; ---------------------------------
(filter (comp #{2 4} dec) [1 2 3 4 5])

(->> [1 2 3 4 5]
     (map dec)
     (filter #{2 4}))


(into []
      (filter (comp #{true} even?))
      [1 2 3 4 5])

(filter (comp #{2 4} :num)
        [{:num 1 :teste "A"}
         {:num 2 :teste "B"}
         {:num 3 :teste "C"}
         {:num 4 :teste "D"}
         {:num 5 :teste "E"}])


(filter #(or (= 4 (:num %)) (= 2 (:num %)))
        [{:num 1 :teste "A"}
         {:num 2 :teste "B"}
         {:num 3 :teste "C"}
         {:num 4 :teste "D"}
         {:num 5 :teste "E"}])


(filter (comp #{"D" "C"} :teste)
        [{:num 1 :teste "A"}
         {:num 2 :teste "B"}
         {:num 3 :teste "C"}
         {:num 4 :teste "D"}
         {:num 5 :teste "E"}])


















