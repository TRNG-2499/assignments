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

-- Assignment 3 here
ALTER TABLE Writer RENAME TO Author;
ALTER TABLE Author
RENAME COLUMN writer_id TO author_id;
ALTER TABLE Author
RENAME COLUMN writer_name TO author_name;