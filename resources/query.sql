-- :name insert-comment :! :n
insert into comments (user, content)
values (:user, :content)

-- :name find-comments :? :*
select * from comments
