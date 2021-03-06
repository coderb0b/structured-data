(ns structured-data)

(defn do-a-thing [x]
  (let [dat (+ x x)]
    (Math/pow dat dat)))

(defn spiff [v]
  (+ (get v 0) (get v 2)))

(defn cutify [v]
  (conj v "<3"))

(defn spiff-destructuring [v]
  (let [[x y z] v]
    (+ x z)))

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- x2 x1)))

(defn height [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- y2 y1)))

(defn square? [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (if (= (- x2 x1) (- y2 y1)) true false)))

(defn area [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (* (- y2 y1) (- x2 x1))))

(defn contains-point? [rectangle point]
  (let [[[x1 y1] [x2 y2]] rectangle
        [z1 z2] point]
    (if (and (<= x1 z1 x2) (<= y1 z2 y2)) true false)))

(defn contains-rectangle? [outer inner]
  (let [[[x1 y1] [x2 y2]] outer
        [[d1 t1] [d2 t2]] inner]
    (if (and (contains-point? (rectangle [x1 y1] [x2 y2])
                 (point d1 t1)) (contains-point? (rectangle [x1 y1] [x2 y2])
                 (point d2 t2))) true false)))

(defn title-length [book]
  (count (get book :title)))

(defn author-count [book]
  (count (get book :authors)))

(defn multiple-authors? [book]
  (if (> (count (get book :authors)) 1) true false))

(defn add-author [book new-author]
  (let [b book
        a new-author]
    (assoc b :authors (conj (get b :authors) a))))

(defn alive? [author]
  (if (contains? author :death-year) false true))

(defn element-lengths [collection]
  (map count collection))

(defn second-elements [collection]
  (let [get2 (fn [x] (get x 1))]
    (map get2 collection)))

(defn titles [books]
  (map :title books))

(defn monotonic? [a-seq]
  (if (or (apply <= a-seq) (apply >= a-seq)) true false))

(defn stars [n]
  (apply str (repeat n "*")))

(defn toggle [a-set elem]
  (cond
    (contains? a-set elem) (disj a-set elem)
    :else (conj a-set elem)))

(defn contains-duplicates? [a-seq]
  (let [setti (set a-seq)]
    (> (count a-seq) (count setti))))

(defn old-book->new-book [book]
  (assoc book :authors (set (get book :authors))))

(defn has-author? [book author]
  (contains? (get book :authors) author))

(defn authors [books]
  (let [author-names
         (fn [book] (map :name (:authors book)))]
    (set (apply concat (map author-names books)))))

(defn all-author-names [books]
  :-)

(defn author->string [author]
  (let [nimi (get author :name)
        b (get author :birth-year)
        d (get author :death-year)]
    (cond
      (not= b nil) (str nimi " (" b " - " d ")")
      :else (str nimi))))

(defn authors->string [authors]
  (apply str (interpose ", " (map author->string authors))))

(defn book->string [book]
  (apply str (get book :title) ", written by " (interpose ", " (map author->string (get book :authors)))))

(defn books->string [books]
  (apply str (map :title books) ", written by "(interpose ", " (map author->string (authors books)))))

(defn books-by-author [author books]
  :-)

(defn author-by-name [name authors]
  :-)

(defn living-authors [authors]
  :-)

(defn has-a-living-author? [book]
  :-)

(defn books-by-living-authors [books]
  :-)

; %________%
