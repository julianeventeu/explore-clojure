(ns mentoring.default)

;https://clojure.org/news/2021/03/18/apis-serving-people-and-programs

(defn my-crazy-fn
      [arg1
       arg2
       {:keys [producer datomic http-client]}
       & {:keys [strict? pretty-print?]
          :or   {strict? true}}]
      {:arg1          arg1
       :arg2          arg2
       :producer      producer
       :datomic       datomic
       :http-client   http-client
       :strict?       strict?
       :pretty-print? pretty-print?
       })

(my-crazy-fn 1 2 {})
(my-crazy-fn 1 2 {} :pretty-print? true)
(my-crazy-fn 1 2 {} :pretty-print? true :strict? false)

(defn my-default
      [& {:keys [strict? pretty-print?]
          :or   {strict?       true
                 pretty-print? true}}]
      {:strict?       strict?
       :pretty-print? pretty-print?})

(my-default)
(my-default :pretty-print? false
            :strict? false)
(my-default :strict? false
            :pretty-print? false)

(defn my-fn
      [{:keys [age job name]
        :or   {job :unemployed}}]
      {:age  age
       :job  job
       :name name})

(my-fn {:age 10})

(defn my-fn-3
      [& {:keys [age job name]
          :or   {job :unemployed}}]
      {:age  age
       :job  job
       :name name})

(my-fn-3 :name "Juliane")

(defn my-fn-4
      [arg1 arg2 & arg3]
      {:arg1 arg1
       :arg2 arg2
       :arg3 arg3})

;(my-fn-4 "ju")
(my-fn-4 "ju" "eric")
(my-fn-4 "ju" "eric" "iasmin")

(comment
 (defn my-fn
       [arg1 arg2]
       (let [arg1* (or arg1 "default")]))

 (defn my-fn
       [{:keys [age job name]}]
       (let [job* (or job :unemployed)]))

 (defn my-fn
       [{:keys [age job name]
         :or   {job :unemployed}}]
       )

 (defn my-fn
       ([arg1 arg2] (my-fn arg1 arg2 {}))
       ([arg1 arg2 {:keys [strict? pretty-print?]
                    :or   {strict? true}}]
        {:arg1          arg1
         :arg2          arg2
         :strict?       strict?
         :pretty-print? pretty-print?}))

 ;; splat keys
 (defn my-fn-2
       [arg1 arg2 & {:keys [strict? pretty-print?]
                     :or   {strict? true}}]
       {:arg1          arg1
        :arg2          arg2
        :strict?       strict?
        :pretty-print? pretty-print?})

 (my-fn-2 1 2 :pretty-print? false :strict? false)
 (my-crazy-fn 1 2)
 )
