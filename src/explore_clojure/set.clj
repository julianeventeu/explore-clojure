(ns explore-clojure.set
  (:require [clojure.set :refer :all]))

(def my-token "123456789")

(def teste #{my-token "1234"})
(teste "123456789")
(teste "1234")

(teste "user")

(def compositions
  #{{:name "The Art of the Fugue" :composer "J. S. Bach"}
    {:name "Musical Offering" :composer "J. S. Bach"}
    {:name "Requiem" :composer "Giuseppe Verdi"}
    {:name "Requiem" :composer "W. A. Mozart"}})

(def composers
  #{{:composer "J. S. Bach" :country "Germany"}
    {:composer "W. A. Mozart" :country "Austria"}
    {:composer "Giuseppe Verdi" :country "Italy"}})

(rename compositions {:name :title})

(select #(= (:name %) "Requiem") compositions)

(project compositions [:name])

(join compositions composers)


; --------------------
(def languages #{"java" "c" "d" "clojure"})
(def beverages #{"java" "chai" "pop"})

(union languages beverages)
(difference languages beverages)
(intersection languages beverages)
(select #(= 1 (count %)) languages)

