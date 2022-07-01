;Fibonacci

;----------------------------------
; bad idea
;----------------------------------
(defn stack-consuming-fibo [n] (cond
                                 (= n 0) 0
                                 (= n 1) 1
                                 :else (+ (stack-consuming-fibo (- n 1))
                                          (stack-consuming-fibo (- n 2)))))

(stack-consuming-fibo 9)
;-> 34

;(stack-consuming-fibo 1000000)
;-> error StackOverflow

;----------------------------------
; ; better but not great (tail recursive)
;----------------------------------
;letfn is like let but is dedicated to creating local functions
(defn recur-fibo [n] (letfn [(fib
                               [current next n] (if (zero? n)
                                                  current
                                                  (recur next (+ current next) (dec n))))]
                       (fib 0N 1N n)))


(recur-fibo 9)
;->  34N

"A lazy-seq invokes its body only when needed, that is, when seq is called directly or indirectly.
lazy-seq then caches the result for subsequent calls"
(defn lazy-seq-fibo ([]
                     (concat [0 1] (lazy-seq-fibo 0N 1N)))
  ([a b]
   (let [n (+ a b)] (lazy-seq
                     (cons n (lazy-seq-fibo b n))))))

(take 2 (lazy-seq-fibo))
(take 9 (lazy-seq-fibo))
(rem (nth (lazy-seq-fibo) 1000000) 1000)

(rem (nth (lazy-seq-fibo) 1000000) 10)

"you can reuse existing sequence library functions that return lazy sequences"
(defn fibo []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0N 1N])))

(def lots-o-fibs (take 1000000000 (fibo)))

(nth lots-o-fibs 100)
(nth lots-o-fibs 9)
;-> 354224848179261915075N
