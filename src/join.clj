"clojure.set/join = inner join"
(def users  [{:name "Keith" :likes :nothing}
             {:name "Juliane" :likes :drinks}])

(def idade  [{:nome "Keith" :age 20}
             {:nome "Juliane" :age 30}
             {:nome "Pepe" :age 62}])

(clojure.set/join users idade {:name :nome})
