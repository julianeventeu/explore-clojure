
;one argument
(map #(format "<p>%s</p>" %) ["the" "quick" "brown" "fox"])

(for [word ["the" "quick" "brown" "fox"]] (format "<p>%s</p>" word))

;more than one argument

(map #(format "<%s>%s</%s>" %1 %2 %1)
     ["h1" "h2" "h3" "h1"] ["the" "quick" "brown" "fox"])

(for [file "ABCDEFGH" rank (range 1 9)]
  (format "%c%d" file rank))
