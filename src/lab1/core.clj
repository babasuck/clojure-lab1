(ns lab1.core)

(def a '(1 2 3 4 5))
(def b '("Hello" "world"))

; 1.1


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


