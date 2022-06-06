" every-pred
^ predicate functions: functions that returns true or false

The common thing in functional programming is combining “smaller” functions into the bigger
one (higher-order functions). The examples of such functions are every-pred and some-fn.
Both those functions were added to Clojure in release 1.3.
https://www.spacjer.com/blog/2015/11/16/lesser-known-clojure-every-pred-and-some-fn-functions/
"

;return TRUE if ALL predicates returns true
((every-pred number? odd?) 3 9 11)
((every-pred number? odd?) 3 9 10)

(def my-every-pred (every-pred string? clojure.string/blank?))
(my-every-pred " " "     " "\t")
(apply my-every-pred '(" " "     " "            "))

;Return TRUE if ONE of predicates returns true
;https://github.com/nubank/investment-accounts/pull/440/files#r838821862
((some-fn #(< % 5) #(> % 10)) 6 15 7 8)
((some-fn #(< % 5) #(> % 10)) 6 7 8)

;; or
(remove (fn [answer]
            (or (:boolean-answer/id answer)
                (:keyword-answer/id answer)))
        [{:boolean-answer/question-key "test"}
         {:boolean-answer/id 234 :boolean-answer/question-key "test"}
         {:keyword-answer/id 234 :keyword-answer/question-key "test"}
         {:keyword-answer/question-key "test"}])

;; some-fn
(remove (some-fn :boolean-answer/id :keyword-answer/id)
        [{:boolean-answer/question-key "test"}
         {:boolean-answer/id 234 :boolean-answer/question-key "test"}
         {:keyword-answer/id 234 :keyword-answer/question-key "test"}
         {:keyword-answer/question-key "test"}])


;; and
(remove #(and (:boolean-answer/id %)
              (:boolean-answer/question-key %))
        [{:boolean-answer/question-key "test"}
         {:boolean-answer/id 234 :boolean-answer/question-key "test"}
         {:keyword-answer/id 234 :keyword-answer/question-key "test"}
         {:keyword-answer/question-key "test"}])

;; every-pred
(remove (every-pred :boolean-answer/id :boolean-answer/question-key)
        [{:boolean-answer/question-key "test"}
         {:boolean-answer/id 234 :boolean-answer/question-key "test"}
         {:keyword-answer/id 234 :keyword-answer/question-key "test"}
         {:keyword-answer/question-key "test"}])
