(ns bloom)

(defn init-filter [bit-count]
  "initializes a bloom filter with the specified number of bits"
  (loop [n bit-count filter []]
    (if (zero? n)
      filter
      (recur (dec n) (conj filter false)))))

(defn filter-bit-count [filter]
  "returns the number of bits in the specified filter"
  (count filter))