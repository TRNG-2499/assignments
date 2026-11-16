CREATE SCHEMA assignment;

CREATE TABLE assignment.writer (
    writer_id INTEGER PRIMARY KEY,
    writer_name VARCHAR(50)
);

CREATE TABLE assignment.books (
    book_id INTEGER PRIMARY KEY,
    book_name VARCHAR(100),
    author INTEGER REFERENCES assignment.writers(writer_id),
    publication DATE,
    page_count INTEGER
);