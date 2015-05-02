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

(defn filter-set-bit [filter bit-position]
  "Sets the bit at bit-position of the specified filter"
  ; TODO Add argument checking
  ; TODO Filter must both be vectors of ints
  ; TODO Bit-position must be no greater than the number of bits in the filter
  (assoc filter 0
    (bit-set (nth filter 0) bit-position)))
