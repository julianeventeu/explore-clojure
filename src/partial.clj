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
     (map even?)
     (filter #(= 2 %))
     (filter #(= 4 %)))

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

(filter (comp #{2 4} inc) [1 2 3 4 5])

(into []
      (filter (comp #{2 4} even?))
      [1 2 3 4 5])

(filter (comp #{2 4} :num)
        [{:num 1} {:num 2} {:num 3} {:num 4} {:num 5}])


















