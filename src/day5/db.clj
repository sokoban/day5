(ns day5.db
  (:require [conman.core :as conman]))

(def db (conman/connect! {:jdbc-url "jdbc:mysql://sokoban.co.kr:13309/outtest?user=sokoban&password=tnwlEkfkdgo^7&serverTimezone=UTC"}))

(conman/bind-connection db "query.sql")
