(ns lab1.core)

(defn concatToEvery [c l]
  "Adds c to every element in l if the element does not start with c."
  (map (fn [item] (str c item))
       (filter (fn [item] (not (.startsWith item c))) l)))

(defn step [l acc]
  "Performs one step of concatenation for each character in l with every element in acc."
  (reduce concat (map (fn [c] (concatToEvery c acc)) l)))

(defn foo [l n]
  "Generates a list of all strings of length n without consecutive repeating characters."
  (loop [acc l, count n]
    (cond
      (<= count 0) '()
      (= count 1) acc
      :else (recur (step l acc) (dec count)))))

(defn my-square [x]
  "Calculates the square of x."
  (* x x))

(defn my-map [f l]
  "Applies function f to each element in list l and returns a new list."
  (reduce
   (fn [res el]
     (concat res (list (f el))))
   '() l))

(defn my-filter [f l]
  "Filters elements in list l based on the function f."
  (reduce (fn [res el]
            (if (f el)
              (concat res (list el))
              res))
          '() l))

(defn -main [& args]
  (let [a '(1 2 3 4 5)
        l '("a" "b" "c")]
    
    ;; Part 1.1 + 1.2
    (println "\nFunction concatToEvery:")
    (println (concatToEvery "a" '("a" "b" "c")))

    (println "\nFunction foo:")
    (println "foo l 0:" (foo l 0)) ; '()
    (println "foo l 1:" (foo l 1)) ; ("a" "b" "c")
    (println "foo l 2:" (foo l 2)) ; ("ab" "ac" "ba" "bc" "ca" "cb")
    (println "foo l 3:" (foo l 3))

    ;; Part 1.3
    (println "\nFunctions my-map and my-filter:")
    (println "my-map my-square a:" (my-map my-square a))
    (println "my-filter even? a:" (my-filter even? a))

    ;; Part 1.4
    (println "\nFunction foo2:")
    (println "foo2 l 1:" (foo l 1))
    (println "foo2 l 3:" (foo l 3))))
