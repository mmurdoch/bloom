(ns bloom.impl.filter-impl)

(defn filter-int-state [filter-int]
  "Returns a string representation of the state of a single int within a filter"
  (loop [n 32 state ""]
    (if (zero? n)
      state
      (recur
        (dec n)
        (str state
          (if (true? (bit-test filter-int (- n 1)))
            "1" "0"))))))

(defn filter-add-hash [filter hash]
  "Adds a hash (vector of ints) to the specified filter"
  ; TODO Add argument checking
  ; TODO Filter must both be vectors of ints
  ; TODO Hash value must be no greater than the number of bits in the filter
  (loop [n (count filter) filter filter]
    (if (zero? n)
      filter
      (recur
        (dec n)
        (assoc filter (- n 1)
          (bit-or (nth filter (- n 1)) (nth hash (- n 1))))))))
