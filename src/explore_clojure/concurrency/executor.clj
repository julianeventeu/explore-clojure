(import '(java.util.concurrent Executors TimeUnit))

(defn- new-thread-pool [num-threads]
  (Executors/newFixedThreadPool num-threads))

(defn- finish [thread-pool wait-for]
  (.shutdown thread-pool)
  (when-not (.awaitTermination thread-pool wait-for TimeUnit/MINUTES)
    (.shutdownNow thread-pool)))

(defn run-in-parallel
  [num-threads times fn]
  (let [thread-pool (new-thread-pool num-threads)]
    (dotimes [n times] (.submit thread-pool (partial fn n)))
    (finish thread-pool 1)))

(defn my-teste []
  (let [members (atom [])
        groups [{:group "teste1"}
                {:group "teste2"}
                {:group "teste3"}
                {:group "teste4"}
                {:group "teste5"}]
        get (fn [n]
               (swap! members conj {:teste n :group (get groups n)})
               (println "thread" (.getName (Thread/currentThread)) "item" n))]
    (run-in-parallel 2 5 get)
    @members))

(my-teste)

