CREATE TABLE writer (
    writer_id INT PRIMARY KEY,
    writer_name VARCHAR(30)
);

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(50),
    author NUMERIC,
    publication NUMERIC,
    page_count NUMERIC
);