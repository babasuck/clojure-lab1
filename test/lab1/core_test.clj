(ns lab1.core-test
  (:require [clojure.test :refer :all]
            [lab1.core :refer :all]))

(deftest test-concatToEvery
  (testing "Testing concatToEvery function"
    (is (= (concatToEvery "a" '("a" "b" "c")) '("ab" "ac")))
    (is (= (concatToEvery "b" '("a" "b" "c")) '("ba" "bc")))
    (is (= (concatToEvery "c" '("c" "d" "e")) '("cd" "ce")))))

(deftest test-step
  (testing "Testing step function"
    (is (= (step '("a" "b" "c") '("x" "y")) '("ax" "ay" "bx" "by" "cx" "cy")))
    (is (= (step '("x") '("y" "z")) '("xy" "xz")))))

(deftest test-foo
  (testing "Testing foo function"
    (is (= (foo '("a" "b" "c") 0) '()))
    (is (= (foo '("a" "b" "c") 1) '("a" "b" "c")))
    (is (= (foo '("a" "b" "c") 2) '("ab" "ac" "ba" "bc" "ca" "cb")))
    (is (= (foo '("a" "b") 3) '("aba" "bab")))))

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

(deftest test-foo2
  (testing "Testing foo2 function"
    (is (= (foo '("a" "b" "c") 1) '("a" "b" "c")))
    (is (= (foo '("a" "b" "c") 2) '("ab" "ac" "ba" "bc" "ca" "cb")))
    (is (= (foo '("a" "b") 3) '("aba" "bab")))))
