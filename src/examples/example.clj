(use 'bloom.filter)

; Create a 32 bit (4 byte) Bloom filter
(def bf (filter-init 4))

(println (filter-state bf))