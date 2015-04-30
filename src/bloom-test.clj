(use 'clojure.test)
(use 'bloom)

(deftest test-filter-bit-count
  (is (= 2 (filter-bit-count (filter-init 2))))
  (is (= 19 (filter-bit-count (filter-init 19)))))

(deftest test-filter-state
  (is (= [false] (filter-state (filter-init 1)))))

; Large array of bits
; Dictionary of words
; Several hashes
; Function for adding a word
; Function for checking for existence
; Produce n random 5 letter words and check for percentage false positives

(run-tests)
