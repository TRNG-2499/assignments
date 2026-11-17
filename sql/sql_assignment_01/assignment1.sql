DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS writers;

CREATE TABLE writers (
    writer_id BIGINT PRIMARY KEY,
    writer_name TEXT
);

CREATE TABLE books (
    book_id BIGINT PRIMARY KEY,
    title TEXT,
    author BIGINT REFERENCES writers(writer_id),
    publication BIGINT,
    page_count BIGINT
);