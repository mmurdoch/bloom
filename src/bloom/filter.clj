(ns bloom.filter)
(use 'bloom.impl.filter-impl)

(defn filter-init [bit-count]
  "initializes a bloom filter with the specified number of bits"
  (loop [n bit-count filter []]
    (if (zero? n)
      filter
      (recur (dec n) (conj filter false)))))

(defn filter-bit-count [filter]
  "returns the number of bits in the specified filter"
  (count filter))

(defn filter-set-bit-on [filter n]
  "turns on the nth bit in the specified filter"
  (assoc filter n true))

(defn filter-add-hash [filter hash]
  (filter-set-bit-on filter 0))

(defn filter-state [filter]
  "returns the state of the specified filter"
  (loop [n (- (filter-bit-count filter) 1) state ""]
    (if (< n 0)
      state
      (recur (dec n)
        (str state
          (if (filter-bit filter n)
            "1"
            "0"))))))
