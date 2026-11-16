CREATE TABLE Writer (
    writer_id INTEGER PRIMARY KEY,
    writer_name VARCHAR(255)
);

CREATE TABLE Books (
    book_id INTEGER PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    publication INTEGER,
    page_count INTEGER
);