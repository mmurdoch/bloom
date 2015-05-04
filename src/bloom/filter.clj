(ns bloom.filter)
(use 'bloom.impl.filter-impl)

(defn filter-init [byte-count]
  "initializes a bloom filter with the specified number of bits"
  (if (<= byte-count 0)
    (throw (IllegalArgumentException. "bit-count must be greater than zero")))
  (loop [n byte-count filter []]
    (if (zero? n)
      filter
      (recur (dec n) (conj filter (byte 0))))))

(defn filter-bit-count [filter]
  "returns the number of bits in the specified filter"
  (* (count filter) (bits-per-byte)))

(defn filter-state [filter]
  "returns the state of the specified filter"
  (loop [n (- (count filter) 1) state ""]
    (if (< n 0)
      state
      (recur (dec n)
        (str state
          (filter-byte-state (nth filter n)))))))
