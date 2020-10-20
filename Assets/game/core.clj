(ns game.core
  (:require [arcadia.core :refer :all]
            [arcadia.linear :as l])
  (:import [UnityEngine Vector3]))

(defn move-randomly
  [g _]
  (letfn [(defn xRand [] (- (rand 13) 2))
          (defn yRand [] (+ 2 (rand 6)))
          (defn zRand [] (+ 40 (rand 15))]
  (def v (Vector3. (xRand) (yRand) (zRand)))
  (set! (.. g transform position) v)))

(defn init
  [_ _]
  (hook+
   (object-named "BlueJelly")
   :on-mouse-over
   :run_away
   #'move-randomly))
