--Assignment One
CREATE SCHEMA writer_books;
CREATE TABLE writer_books.writer(
	writer_id INT NOT NULL PRIMARY KEY,
	writer_name VARCHAR(120) NOT NULL
);

INSERT INTO writer_books.writer (writer_id, writer_name) VALUES (1001, 'Agatha Christie');
INSERT INTO writer_books.writer (writer_id, writer_name) VALUES (1002, 'George Orwell');
INSERT INTO writer_books.writer (writer_id, writer_name) VALUES (1003, 'Kurt Vonnegut');
INSERT INTO writer_books.writer (writer_id, writer_name) VALUES (1004, 'Mark Twain');
INSERT INTO writer_books.writer (writer_id, writer_name) VALUES (1005, 'Stephen King');

SELECT * FROM writer_books.writer;

CREATE TABLE IF NOT EXISTS writer_books.Books(
book_id int NOT NULL PRIMARY KEY,
title VARCHAR(200) NOT NULL,
author int References writer_books.writer(writer_id),
publication int NOT NULL,
page_count int NOT NULL
);

INSERT INTO writer_books.Books(book_id, title, author, publication, page_count) 
VALUES (3050, 'Murder on the Orient Express', 1001, 1934, 256);
INSERT INTO writer_books.Books(book_id, title, author, publication, page_count) 
VALUES (3051, 'It', 1005, 1986, 1138);
INSERT INTO writer_books.Books(book_id, title, author, publication, page_count) 
VALUES (3052, 'And Then There Were None', 1001, 1939, 272);


SELECT * FROM writer_books.Books;

--Assignment two

ALTER TABLE writer_books.Books RENAME COLUMN book_id TO isbn_13;

SELECT * FROM writer_books.Books;

--Assignment three
ALTER TABLE writer_books.writer RENAME TO Author; -- does not allow a schema (writer_books.) on the new table name after RENAME TO, so jut Author.
ALTER TABLE writer_books.Author RENAME COLUMN writer_id TO author_id;
ALTER TABLE writer_books.Author RENAME COLUMN writer_name TO author_name;

SELECT * FROM writer_books.Author;