(ns bloom.impl.filter-impl)

(defn bits-per-byte []
  8)

(defn filter-byte-state [filter-byte]
  "Returns a string representation of the state of a single byte within a filter"
  (loop [n (bits-per-byte) state ""]
    (if (zero? n)
      state
      (recur
        (dec n)
        (str state
          (if (true? (bit-test filter-byte (- n 1)))
            "1" "0"))))))

(defn filter-set-bit [filter bit-position]
  "Sets the bit at bit-position of the specified filter"
  (if (< bit-position 0)
    (throw (IllegalArgumentException. "bit-position must be greater than zero")))
  (if (>= bit-position (* (count filter) (bits-per-byte)))
    (throw (IllegalArgumentException. "bit-position must be less than the number of bits in the filter")))
  (assoc filter 0
    (bit-set (nth filter 0) bit-position)))
