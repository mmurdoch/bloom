(ns bloom)

(defn filter-init [bit-count]
  "initializes a bloom filter with the specified number of bits"
  (loop [n bit-count filter []]
    (if (zero? n)
      filter
      (recur (dec n) (conj filter false)))))

(defn filter-state [filter]
  "returns the state of the specified filter"
  filter)

(defn filter-bit-count [filter]
  "returns the number of bits in the specified filter"
  (count filter))