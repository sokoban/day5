(ns day5.db
  (:require [conman.core :as conman]))

(def db (conman/connect! {:jdbc-url "jdbc:mysql://sokoban.co.kr:/outtest?user=&password=&serverTimezone=UTC"}))

(conman/bind-connection db "query.sql")
