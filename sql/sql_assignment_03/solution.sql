--CREATE TABLE Writer (writer_id SERIAL, writer_name VARCHAR(100));
--CREATE TABLE Books (book_id SERIAL, title VARCHAR(100), author INT, publication INT, page_count INT);

ALTER TABLE Writer RENAME TO Author;

ALTER TABLE Author RENAME writer_id TO author_id;
ALTER TABLE Author RENAME writer_name TO author_name;