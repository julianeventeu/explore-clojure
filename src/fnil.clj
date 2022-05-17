"fnil with my-function"
(defn my-function [arg1 arg2]
      (if (nil? arg1)
        (throw (ex-info "Error nil" {:arg1 arg1}))
        (do (println "arg1" arg1)
            (println "arg1" arg2))))

;(my-function nil)

(def safe-my-function (fnil my-function "teste" "outro valor"))
(safe-my-function nil nil)

"fnil with str/replace"
(def safe-replace (fnil str/replace ""))
(safe-replace "Bearer juliane" "Bearer " "")
(safe-replace nil "Bearer " "")

(def safe-replace2 (fnil str/replace "" "juliane" ""))
(safe-replace2 "Bearer juliane" nil "")

(defn safe-replace-2
      ([replace-from replace-to] (safe-replace-2 "" replace-from replace-to))
      ([text replace-from replace-to] (str/replace text replace-from replace-to)))
(safe-replace-2 "Bearer juliane" "Bearer " "")
(safe-replace-2 "Bearer " "")
