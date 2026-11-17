DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Writer;

CREATE TABLE Writer (
    writer_id BIGINT PRIMARY KEY,
    writer_name TEXT
);

CREATE TABLE Books (
    book_id BIGINT PRIMARY KEY,
    title TEXT,
    author BIGINT REFERENCES Writer(writer_id),
    publication BIGINT,
    page_count BIGINT
);

-- Assignment 2 here
ALTER TABLE Books
RENAME COLUMN book_id TO isbn_13