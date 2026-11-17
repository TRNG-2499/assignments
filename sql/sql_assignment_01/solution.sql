CREATE TABLE Writer (writer_id SERIAL, writer_name VARCHAR(100));
CREATE TABLE Books (book_id SERIAL, title VARCHAR(100), author INT, publication INT, page_count INT);