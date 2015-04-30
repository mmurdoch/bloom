(ns bloom.impl.filter-impl)

(defn filter-bit [filter n]
  "returns the state of the nth bit in the specified filter"
  (nth filter n))
