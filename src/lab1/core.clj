(ns lab1.core)


(defn concatToEvery-recur [c l]
  (if (empty? l)
    '()
    (let [head (first l)
          tail (rest l)]
      (if (.startsWith head c)
        (concatToEvery-recur c tail)
        (cons (str c head) (concatToEvery-recur c tail))))))


(defn foo-recursive [l n]
  (if (<= n 0)
    '()
    (if (= n 1)
      l
      (let [prev-acc (foo-recursive l (dec n))
            new-acc (letfn [(combine [rem acc]
                              (if (empty? rem)
                                acc
                                (let [head (first rem) tail (rest rem)
                                      combined (concatToEvery-recur head l)]
                                  (combine tail (concat acc combined)))))]
                      (combine prev-acc '()))]
        new-acc))))

 (defn concatToEvery-loop [c l]
   "Concatenates c to every element in l if the element does not start with c, using recur."
   (loop [acc '() new-l l]
     (if (empty? new-l)
       (reverse acc)
       (let [head (first new-l)
             tail (rest new-l)]
         (if (.startsWith head c)
           (recur acc tail)
           (recur (conj acc (str c head)) tail))))))

 (defn foo-loop [l n]
   (loop [acc l count n]
     (cond (<= count 0) '()
           (= count 1) acc
           :else
           (let [new-acc (loop [inner-acc '() rem l]
                           (if (empty? rem)
                             inner-acc
                             (let [head (first rem) tail (rest rem)]
                               (recur (concat inner-acc (concatToEvery-loop head acc)) tail))))]
             (recur new-acc (dec count))))))

 (defn concatToEvery-map [c l]
   (map (fn [item] (str c item))
        (filter (fn [item] (not (.startsWith item c))) l)))

 (defn step [l acc]
   (reduce concat (map (fn [c] (concatToEvery-map c acc)) l)))

 (defn foo-map [l n]
   (loop [acc l, count n]
     (cond
       (<= count 0) '()
       (= count 1) acc
       :else (recur (step l acc) (dec count)))))

 (defn my-square [x]
   (* x x))

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
           '() l))

 (defn -main [& args]
   (let [a '(1 2 3 4 5)
         b '("Hello" "world")
         l '("a" "b" "c")
         lb '("a" "b" "c" "d")]
     (println "Testing concatToEvery-loop:")
     (println (concatToEvery-loop "a" '("a" "b" "c")))

     (println "\nTesting foo-loop:")
     (println "foo-loop l 0:" (foo-loop l 0))
     (println "foo-loop l 1:" (foo-loop l 1))
     (println "foo-loop l 2:" (foo-loop l 2))
     (println "foo-loop l 3:" (foo-loop l 3))

     (println "\nTesting my-square:")
     (println (my-square 10))

     (println "\nTesting my-map:")
     (println (my-map my-square a))

     (println "\nTesting my-filter:")
     (println (my-filter even? a))

     (println "\nTesting foo-map:")
     (println "foo-map l 1:" (foo-map l 1))
     (println "foo-map l 3:" (foo-map l 3))))

