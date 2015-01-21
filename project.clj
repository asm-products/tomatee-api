(defproject tomatee-api "0.1.0-SNAPSHOT"
  :description "Tomatee API"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-jetty-adapter "1.2.2"]
                 [ring/ring-defaults "0.1.2"]
                 [environ "0.5.0"]
                 [com.taoensso/carmine "2.9.0"]]
  :plugins [[lein-ring "0.8.13"]
            [environ/environ.lein "0.2.1"]]
  :ring {:handler tomatee-api.core.handler/app}
  :hooks [environ.leiningen.hooks]
  :uberjar-name "tomatee-api-standalone.jar"
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}
             :production {:env {:production true}}})
