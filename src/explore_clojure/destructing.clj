;; Sample map structure we want to destructure.
(def my-comp {:first-name "Hubert"
              :last-name  "Klein Ikkink"
              :alias      "mrhaki"
              :emails {:work "someone@nubank"
                       :personal "myemail@email"}})
(def input "Oi")

(defn my-print [input {:keys [alias :as my-alias] :as teste}]
      (println input)
      (println alias)
      (println my-alias)
      (println teste)
      (println (:first-name teste))
      (println "emails" (:emails teste))
      (println "work" (:work (:emails teste)))
      )

#_(defn my-print [input {name :first-name last :last-name}]
        (println input)
        (println name)
        (println last))

(my-print input my-comp)

(let [{lastname :lastname} contact]
     (println lastname))

(let [{{phone :phone} :contacts} contact]
     (println phone))

(let [{:keys [firstname lastname]} contact]
     (println firstname lastname))

(let [{{{:keys [work personal]} :emails} :contacts} contact]
     (println work personal))

(let [{:keys [firstname]
       {{:keys [work personal]} :emails} :contacts} contact]
     (println "Firstname:" firstname)
     (println "Emails:" work personal))

(defn myprint
      [{{{:keys [work personal]} :emails} :contacts :as teste}]
      (println "Test using destructing in parameters of function")
      (println "Work email:" work)
      (println "Personal email:" personal)
      (println "work emails" (:work (:emails (:contacts teste))))
      ;(println "Symbol with as:" teste)
      ;(println "Symbol not named:" contact)
      )

(myprint contact)


