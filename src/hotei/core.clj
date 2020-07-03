(ns hotei.core
  (:require
   [hotei.utils :as u]
   [clojure.core.logic :as l]
   [clojure.core.logic.fd :as fd]))

(def sample-board '[5 3 _ _ 7 _ _ _ _
                    6 _ _ 1 9 5 _ _ _
                    _ 9 8 _ _ _ _ 6 _
                    8 _ _ _ 6 _ _ _ 3
                    4 _ _ 8 _ 3 _ _ 1
                    7 _ _ _ 2 _ _ _ 6
                    _ 6 _ _ _ _ 2 8 _
                    _ _ _ 4 1 9 _ _ 5
                    _ _ _ _ 8 _ _ 7 9])

(def sample-board2 '[_ _ _ _ _ _ _ _ 2
                     _ _ _ _ _ _ 9 4 _
                     _ _ 3 _ _ _ _ _ 5
                     _ 9 2 3 _ 5 _ 7 4
                     8 4 _ _ _ _ _ _ _
                     _ 6 7 _ 9 8 _ _ _
                     _ _ _ 7 _ 6 _ _ _
                     _ _ _ 9 _ _ _ 2 _
                     4 _ 8 5 _ _ 3 6 _])

(defn varify [board]
  (map #(if (number? %) % (l/lvar)) board))

(defn get-vars [varified-board]
  (filter l/lvar? varified-board))

(defn solve-sudoku* [board q]
  (let [varified-board (varify board)
        vars           (get-vars varified-board)
        domain         (fd/interval 1 9)]
    (l/all (l/and* (map #(fd/dom % domain) vars))
           (l/everyg fd/distinct (u/cols varified-board))
           (l/everyg fd/distinct (u/rows varified-board))
           (l/everyg fd/distinct (u/boxes varified-board))
           (l/== q varified-board))))

(defn solve-sudoku [board]
  (first (l/run 1 [q] (solve-sudoku* board q))))