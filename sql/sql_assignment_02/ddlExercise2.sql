--alter table would permanently rename the column in the table
ALTER TABLE Books RENAME COLUMN book_id TO isbn_13;

--It's good to point out if I use a alias it would be:
-- SELECT book_id AS isbn_13 FROM Books;
--This would only change the column name only in the query result