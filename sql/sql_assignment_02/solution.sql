--CREATE TABLE assignment2.Writer (writer_id SERIAL, writer_name VARCHAR(100));

--CREATE TABLE assignment2.Books (book_id SERIAL, title VARCHAR(100), author INT, publication INT, page_count INT);

ALTER TABLE Books RENAME book_id TO isbn_13;