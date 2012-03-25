
(defn randomize-doors
  ([]
   (let [all-goat-doors {0 "G", 1 "G", 2 "G"}
         random-door    (rand-int 3)
         with-car-door  (assoc all-goat-doors random-door "C")]
    with-car-door)))

(defn player-chooses-door-round-one
  ([] (rand-int 3)))

(defn player-selected-car-door
  ([doors chosen-door-number]
   (= (doors chosen-door-number) "C")))

(defn play-game
 ([]
  (let [doors (randomize-doors)
          selected-door (player-chooses-door-round-one)]
     (if (player-selected-car-door doors selected-door)
       (str "won")
       (str "lost")))))

(defn play-some-games
 ([n]
  (let [r (range 0 n)
        results (map (fn [_] (play-game)) r)]
        (frequencies results))))

(println (play-some-games 100000))
