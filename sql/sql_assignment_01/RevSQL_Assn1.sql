CREATE TABLE Writer (
    writer_id INTEGER PRIMARY KEY,
    writer_name VARCHAR(100)
);

CREATE TABLE Books (
    book_id INTEGER PRIMARY KEY,
    title VARCHAR(100),
    author INTEGER REFERENCES Writer(writer_id),
    publication INTEGER,
    page_count INTEGER
);