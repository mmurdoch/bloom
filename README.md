[Bloom filter](http://en.wikipedia.org/wiki/Bloom_filter) [Clojure](http://clojure.org) library.

# Usage Example

    (use 'bloom.filter)

    ; Create a 256 bit (32 byte) Bloom filter
    (def bf (filter-init 32))