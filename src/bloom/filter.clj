(ns bloom.filter)
(use 'bloom.impl.filter-impl)

(defn filter-init [bit-count]
  "initializes a bloom filter with the specified number of bits"
  (if (<= bit-count 0)
    (throw (IllegalArgumentException. "bit-count must be greater than zero")))
  (if (not= (rem bit-count 32) 0)
    (throw (IllegalArgumentException. "bit-count must be multiple of 32")))
  (loop [n bit-count filter []]
    (if (zero? n)
      filter
      (recur (- n 32) (conj filter (int 0))))))

(defn filter-bit-count [filter]
  "returns the number of bits in the specified filter"
  (* (count filter) 32))

(defn filter-state [filter]
  "returns the state of the specified filter"
  (loop [n (- (count filter) 1) state ""]
    (if (< n 0)
      state
      (recur (dec n)
        (str state
          (filter-int-state (nth filter n)))))))
