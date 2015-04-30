; TODO Convert filter representation to bits
; TODO Use several hashes (perhaps single hash split)
; TODO Add function for adding a word
; TODO Add function for checking for word existence
; TODO Add function to check accuracy
(use 'clojure.test)
(use 'bloom)

(deftest test-filter-bit-count
  (is (= 2 (filter-bit-count (filter-init 2))))
  (is (= 19 (filter-bit-count (filter-init 19)))))

(deftest test-filter-state
  (is (= [false] (filter-state (filter-init 1)))))

(run-tests)
