(ns lab1.core-test
  (:require [clojure.test :refer :all]
            [lab1.core :refer :all]))

(deftest test-concatToEvery-recur
  (testing "Testing concatToEvery-recur function"
    (is (= (concatToEvery-recur "a" '("a" "b" "c")) '("ab" "ac")))
    (is (= (concatToEvery-recur "b" '("a" "b" "c")) '("ba" "bc")))
    (is (= (concatToEvery-recur "c" '("c" "d" "e")) '("cd" "ce")))))

(deftest test-concatToEvery-loop
  (testing "Testing concatToEvery-loop function"
    (is (= (concatToEvery-loop "a" '("a" "b" "c")) '("ab" "ac")))
    (is (= (concatToEvery-loop "b" '("a" "b" "c")) '("ba" "bc")))
    (is (= (concatToEvery-loop "c" '("c" "d" "e")) '("cd" "ce")))))

(deftest test-concatToEvery-map
  (testing "Testing concatToEvery-map function"
    (is (= (concatToEvery-map "a" '("a" "b" "c")) '("ab" "ac")))
    (is (= (concatToEvery-map "b" '("a" "b" "c")) '("ba" "bc")))
    (is (= (concatToEvery-map "c" '("c" "d" "e")) '("cd" "ce")))))

(deftest test-step
  (testing "Testing step function"
    (is (= (step '("a" "b" "c") '("x" "y")) '("ax" "ay" "bx" "by" "cx" "cy")))
    (is (= (step '("x") '("y" "z")) '("xy" "xz")))))

(deftest test-foo-recur
  (testing "Testing foo-loop function"
    (is (= (foo-recursive '("a" "b" "c") 0) '()))
    (is (= (foo-recursive '("a" "b" "c") 1) '("a" "b" "c")))
    (is (= (foo-recursive '("a" "b" "c") 2) '("ab" "ac" "ba" "bc" "ca" "cb")))
    (is (= (foo-recursive '("a" "b") 3) '("aba" "bab")))))

(deftest test-foo-loop
  (testing "Testing foo-loop function"
    (is (= (foo-loop '("a" "b" "c") 0) '()))
    (is (= (foo-loop '("a" "b" "c") 1) '("a" "b" "c")))
    (is (= (foo-loop '("a" "b" "c") 2) '("ab" "ac" "ba" "bc" "ca" "cb")))
    (is (= (foo-loop '("a" "b") 3) '("aba" "bab")))))

(deftest test-foo-map
  (testing "Testing foo-map function"
    (is (= (foo-map '("a" "b" "c") 0) '()))
    (is (= (foo-map '("a" "b" "c") 1) '("a" "b" "c")))
    (is (= (foo-map '("a" "b" "c") 2) '("ab" "ac" "ba" "bc" "ca" "cb")))
    (is (= (foo-map '("a" "b") 3) '("aba" "bab")))))

(deftest test-my-square
  (testing "Testing my-square function"
    (is (= (my-square 2) 4))
    (is (= (my-square 5) 25))
    (is (= (my-square 10) 100))))

(deftest test-my-map
  (testing "Testing my-map function"
    (is (= (my-map my-square '(1 2 3 4)) '(1 4 9 16)))
    (is (= (my-map my-square '(5 6 7)) '(25 36 49)))))

(deftest test-my-filter
  (testing "Testing my-filter function"
    (is (= (my-filter even? '(1 2 3 4 5 6)) '(2 4 6)))
    (is (= (my-filter odd? '(1 2 3 4 5 6)) '(1 3 5)))))
