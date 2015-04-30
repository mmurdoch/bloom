(use 'clojure.test)
(use 'bloom)

(deftest test-filter-bit-count
  (is (= 2 (filter-bit-count (init-filter 2))))
  (is (= 19 (filter-bit-count (init-filter 19)))))

; Large array of bits
; Dictionary of words
; Several hashes
; Function for adding a word
; Function for checking for existence
; Produce n random 5 letter words and check for percentage false positives

(run-tests)
