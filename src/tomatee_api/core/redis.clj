(ns tomatee-api.core.redis
  (:require
   [clojure.test :refer :all]
   [environ.core :refer [env]]
   [taoensso.carmine :as car :refer (wcar)]))

(def server-connection {:pool {}
                        :spec {:uri (env :redistogo-url)}})

(defmacro wcar* [& body] `(car/wcar server-connection ~@body))

(defn get-index []
  (let [current-key (wcar* (car/get "tomatee:current"))]
    (wcar* (car/get (str "tomatee:" current-key)))))
