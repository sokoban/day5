(defproject day5 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.immutant/web "2.1.10"]
                 [metosin/compojure-api "2.0.0-alpha18"]
                 [redis.clients/jedis "2.9.0"]
                 [compojure "1.6.0"]
                 [hiccup "1.0.5"]
                 [conman "0.7.5"]
                 [mysql/mysql-connector-java "6.0.5"]]
  :main day5.core)
