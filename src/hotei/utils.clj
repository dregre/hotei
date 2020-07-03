(ns hotei.utils
  (:require [clojure.string :refer [join]]))

(defn transpose [coll]
  (apply mapv vector coll))

(defn boxes [board]
  (->> board
       (partition 3)
       (partition 3)
       transpose
       (mapcat #(partition 3 %))
       (map #(apply concat %))))

(defn rows [board]
  (partition 9 board))

(defn cols [board]
  (transpose (rows board)))

(defn pprint [board]
  (->> board
       rows
       (map #(join " " %))
       (join "\n")
       println))