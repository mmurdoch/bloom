; TODO Set hash functions during filter initialization
; TODO Add function for adding (a word?)
; TODO Use several hashes (perhaps a single hash, split?)
; TODO Add function for checking for probable existence
; TODO Add function to check accuracy
(use 'clojure.test)
(use 'bloom.filter)

(def bf (filter-init 4))

; Interface Tests
(deftest test-filter-init-zero-bits-fails
  (try
    (filter-init 0)
    (is (true? false))
    (catch IllegalArgumentException e)))

(deftest test-filter-state-contains-all-bits
  (is (= "00000000000000000000000000000000" (filter-state bf))))

(deftest test-filter-bit-count
  (is (= 32 (filter-bit-count bf)))
  (is (= 64 (filter-bit-count (filter-init 8)))))

; Implementation Tests
(use 'bloom.impl.filter-impl)

(deftest test-filter-byte-state
  (is (= "00000010" (filter-byte-state 2)))
  (is (= "10000000" (filter-byte-state 128))))

(deftest test-filter-set-bit-less-than-zero-fails
  (try
    (filter-set-bit bf -1)
    (is (true? false))
    (catch IllegalArgumentException e)))

(deftest test-filter-set-bit-greater-than-count-fails
  (try
    (filter-set-bit bf 32)
    (is (true? false))
    (catch IllegalArgumentException e)))

(deftest test-filter-set-bit
  (is (= "00000000000000000000000000000001" (filter-state (filter-set-bit bf 0))))
  (is (= "00000000000000000000000000010000" (filter-state (filter-set-bit bf 4)))))

(run-tests)
