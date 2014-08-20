(ns re-com.box
  (:require [reagent.core :as reagent]))

(def debug false)

;; ------------------------------------------------------------------------------------
;;  Boxes
;; ------------------------------------------------------------------------------------

;; Use Cases
;;
;; Case 1:
;;   - fixed LHS ... certain px ?
;;    - one or more growable compents, perctage based
;;
;; Case 2:
;;    - fixed left and right
;;    - growable middle
;;
;; Case 3:
;;    - one of the box components is a vbox insdie an hbox.
;;
;; Will ask for "perc" but underneath that's just ratios
;;
;; Align stuff, we will ignore.
;; max-size contraints
;;
;; [scrolling XXXX]  contins a box
;; [border XXXX]     contains a box for the children
;;
;;
;; Let's use HBox and VBox as the names
;;
;;
;; Notes
;;  - Center object in 
;;  - Override h1 to h6? with {:style {:display: inline}} in a .css file
;;  - Names for children: wrap, content, inside, inner, elements
;;
;;
;;

(defn split-size
  [size]
  (let [re (js/RegExp. #"(\d+)(.*)")]
    (if-let [res  (js->clj (.exec re size))]
      [(second res) (last res)]
      [nil nil])))

;; ------------------------------------------------------------------------------------
;;  h-box (debug colour: gold)
;;
;;  NOTES
;;   - For margin and padding:
;;      - "all"
;;      - "top&bottom right&left"
;;      - "top right bottom left"
;; ------------------------------------------------------------------------------------

(defn h-box
  [& {:keys [f-child width height justify margin padding children]
      :or   {f-child true justify :between}}]
  (let [flex-container {:display "flex" :flex-flow "row nowrap"}
        flex-child     (when f-child {:flex "1 1 0px"})
        ;w-style        (if width          ;; No need for width inheritence
        ;                 {:width width}
        ;                 {:width "inherit"})
        w-style        (when width {:width width})
        h-style        (when height {:height height})
        a-style        {:justify-content (case justify
                                           :left    "flex-start"
                                           :right   "flex-end"
                                           :center  "center"
                                           :between "space-between"
                                           :around  "space-around")}
        m-style        (when margin {:margin margin})
        p-style        (when padding {:padding padding})
        d-style        (when debug {:background-color "gold"})
        s              (merge flex-container flex-child w-style h-style a-style m-style p-style d-style)]
    (into [:div {:style s}] children)))


;; ------------------------------------------------------------------------------------
;;  v-box (debug colour: antiquewhite)
;;
;;  NOTES
;;   - For margin and padding:
;;      - "all"
;;      - "top&bottom right&left"
;;      - "top right bottom left"
;; ------------------------------------------------------------------------------------

(defn v-box
  [& {:keys [f-child width height justify margin padding children]
      :or   {f-child true justify :between}}]
  (let [flex-container {:display "flex" :flex-flow "column nowrap"}
        flex-child     (when f-child {:flex "1 1 0px"})
        w-style        (when width {:width width})
        h-style        (if height
                         {:height height}
                         {:height "inherit"})
        a-style        {:justify-content (case justify
                                           :top     "flex-start"
                                           :bottom  "flex-end"
                                           :center  "center"
                                           :between "space-between"
                                           :around  "space-around")}
        m-style        (when margin {:margin margin})
        p-style        (when padding {:padding padding})
        d-style        (when debug {:background-color "antiquewhite"})
        s              (merge flex-container flex-child w-style h-style a-style m-style p-style d-style)]
    (into [:div {:style s}] children)))


;; ------------------------------------------------------------------------------------
;;  box (debug colour: lightblue)
;;
;;  NOTES
;;   - For margin and padding:
;;      - "all"
;;      - "top&bottom right&left"
;;      - "top right bottom left"
;; ------------------------------------------------------------------------------------

(defn box
  [& {:keys [f-child f-container size width height align margin padding b-color child]
      :or   {f-child true f-container true size "1"}}]        ;; was f-container false
  (let [[num units]    (split-size size)
        percent        (or (= units "%") (= units ""))
        grow           (if percent num 0)
        basis          (if percent "0px" size)
        flex-attr      (str grow " " 1 " " basis)
        flex-child     (when f-child {:flex flex-attr})
        flex-container (when f-container {:display "flex" :flex-flow "inherit"})
        o-style        {:overflow "auto"}
        w-style        (when width {:width width})
        h-style        (when height {:height height})
        a-style        (when align
                         {:align-self (case align
                                        :start "flex-start"
                                        :end   "flex-end")})
        ;a-style        (when (and f-container align)
        ;                 {:justify-content (case align
        ;                                     :top     "flex-start"
        ;                                     :bottom  "flex-end"
        ;                                     :center  "center"
        ;                                     :between "space-between"
        ;                                     :around  "space-around")})
        m-style        (when margin {:margin margin})
        p-style        (when padding {:padding padding})
        c-style        (if b-color
                         {:background-color b-color}
                         (if debug {:background-color "lightblue"} {}))
        s              (merge flex-child flex-container o-style w-style h-style a-style m-style p-style c-style)]
    [:div {:style s}
     child]))


;; ------------------------------------------------------------------------------------
;;  gap (debug colour: chocolate)
;; ------------------------------------------------------------------------------------

(defn gap
  [& {:keys [size]                                          ;; TODO: Get rid of :keys as this is a single parameter?
      :or {size "20px"}}]
  [:div {:style {:flex (str "0 0 " size)
                 :background-color (if debug "chocolate" "transparent")}}])


;; ------------------------------------------------------------------------------------
;;  line
;; ------------------------------------------------------------------------------------

(defn line
  [& {:keys [size color]
      :or {size "1px" color "red"}}]
  (let [flex-child {:flex (str "0 1 " size)}
        c-style    {:background-color color}
        s          (merge flex-child c-style)]
    [:div {:style s}]))