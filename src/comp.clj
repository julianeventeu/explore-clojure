"comp works with
filter remove map keep
"
(defn valid-token? [{{:keys [Authorization]} :headers} token]
      (println "Auth" Authorization)
      (let [token-received (str/replace Authorization "Bearer " "")]
           (= token-received token))
      )

(defn authorized?
      [request token]
      (let [safe-replace (fnil str/replace "")
            valid-token? (comp  #{token}
                                #(safe-replace % "Bearer " "")
                                :Authorization
                                :headers)]
           (valid-token? request)))

(comment
 (def request-wrong {:httpMethod "POST" :headers {:Authorization "Bearer teste"}})
 (def request-ok {:httpMethod "POST" :headers {:Authorization "Bearer 123456789"}})
 (def my-token "123456789")

 (authorized? request-ok my-token)
 (authorized? request-wrong my-token)
 (authorized? {} my-token)

 (is (not (authorized? request-wrong my-token)))
 (is (authorized? request-ok my-token))
 (is (not (authorized? {} my-token)))

 (valid-token? request-wrong my-token)
 )

" Comp or ->
Comp takes a number of functions and returns a function.
Threading macros take a number of forms (expressions) and return an expression.

Comp does its work at run-time, so you have to call functions that return functions.
Threading macros do their work at compile-time
"
(defn authorized-2?
      [request token]
      (-> request
          :headers
          :Authorization
          (str/replace "Bearer " "")
          #{token}))
