; TODO Convert filter representation to bits
; TODO Use several hashes (perhaps single hash split)
; TODO Add function for adding a word
; TODO Add function for checking for word existence
; TODO Add function to check accuracy
(use 'clojure.test)
(use 'bloom.filter)

(deftest test-filter-bit
  (is (false? (filter-bit (filter-init 1) 0)))
  (is (true? (filter-bit (filter-set-bit-on (filter-init 1) 0) 0))))

(deftest test-filter-bit-count
  (is (= 2 (filter-bit-count (filter-init 2))))
  (is (= 19 (filter-bit-count (filter-init 19)))))

(deftest test-filter-state
  (is (= "0" (filter-state (filter-init 1))))
  (is (= "00" (filter-state (filter-init 2)))))

(deftest test-filter-add
  (is (= "00000000000000000000000000000000" (filter-state (filter-init 32)))))

(run-tests)
