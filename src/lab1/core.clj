(ns lab1.core)

(def a '(1 2 3 4 5))
(def b '("Hello" "world"))

; 1.1 + 1.2

(def l '("a" "b" "c"))
(def lb '("a" "b" "c" "d"))

(defn concatToEvery [c l]
  "concat c to every element in l != c"
  (loop [acc '() new-l l]
    (if (empty? new-l)
      (reverse acc)
      (let [head (first new-l)
            tail (rest new-l)]
        (if (.startsWith head c)
          (recur acc tail)
          (recur (conj acc (str c head)) tail))))))


(defn foo [l n]
  (loop [acc l count n]
    (cond (<= count 0) '()
          (= count 1) acc
          :else
          (let [new-acc (loop [inner-acc '() rem l]
                          (if (empty? rem)
                            inner-acc
                            (let [head (first rem) tail (rest rem)]
                              (recur (concat inner-acc (concatToEvery head acc)) tail))))]
            (recur new-acc (dec count))))))

(concatToEvery "a" '("a" "b" "c"))
(foo l 0) ; '()
(foo l 1) ; ("a" "b" "c")
(foo l 2) ; ("ab" "ac" "ba" "bc" "ca" "cb")
(foo lb 3)

; 1.3

(defn my-square [x]
  (* x x)
  )

(my-square 10)

(defn my-map [f l] 
  (reduce 
   (fn [res el] 
     (concat res (list (f el))))
  '() l))

(defn my-filter [f l]
  (reduce (fn [res el] 
            (if (f el) 
               (concat res (list el))
               res))
          '() l)
  )
 
(filter even? a)
(my-filter even? a)
(map my-square a)1
(my-map my-square a)

; 1.4 

(defn foo4 [l n]
  
  )