; TODO Add function for adding a word
; TODO Use several hashes (perhaps single hash split)
; TODO Convert filter representation to bits
; TODO Add function for checking for word existence
; TODO Add function to check accuracy
(use 'clojure.test)
(use 'bloom.filter)

; Interface Tests
(deftest test-filter-init-zero-bits-fails
  (try
    (filter-init 0)
    (is (true? false))
    (catch IllegalArgumentException e)))

(deftest test-filter-init-non-multiple-of-32-fails
  (try
    (filter-init 13)
    (is (true? false))
    (catch IllegalArgumentException e)))

(deftest test-filter-state-contains-all-bits
  (is (= "00000000000000000000000000000000" (filter-state (filter-init 32)))))

(deftest test-filter-bit-count
  (is (= 32 (filter-bit-count (filter-init 32))))
  (is (= 64 (filter-bit-count (filter-init 64)))))

; Implementation Tests
(use 'bloom.impl.filter-impl)

(deftest test-filter-int-state
  (is (= "00000000000000000000000000000010" (filter-int-state 2)))
  (is (= "10000000000000000000000000000000" (filter-int-state 2147483648))))

(deftest test-filter-add-hash
  (is (= "00000000000000000000000000000001" (filter-state (filter-add-hash (filter-init 32) [1]))))
  (is (= "00000000000000000000000000010000" (filter-state (filter-add-hash (filter-init 32) [5])))))

(run-tests)
