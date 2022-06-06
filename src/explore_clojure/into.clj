"juxt"
(def my-vector [{:name "Keith" :likes :nothing}
                {:name "Juliane" :likes :drinks}
                {:name "Keith" :likes :pizza}])

;create a set of vector
(map (juxt :name) my-vector)

;create a set of string
(map #(:name % ) my-vector)

"into
Would like to explore more in detail!!
"
(def likes->name
  (into {}
        (comp (remove (comp #{:nothing} :likes))
              (map (juxt :likes :name)))
        [{:name "Keith" :likes :nothing}
         {:name "Juliane" :likes :drinks}
         {:name "Iasmin" :likes :drinks}
         {:name "Keith" :likes :pizza}]))

(into [-1 0] [1 2 3 4])

(likes->name :drinks)
