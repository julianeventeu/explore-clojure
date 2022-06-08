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

(clojure.set/rename compositions {:name :title})

(clojure.set/select #(= (:name %) "Requiem") compositions)

(clojure.set/project compositions [:name])

(clojure.set/join compositions composers)

