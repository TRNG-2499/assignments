CREATE TABLE Writer (
    writer_id INT PRIMARY KEY,
    writer_name VARCHAR(50)
);

CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(50),
    author INT REFERENCES Writer(writer_id),
    publication INT,
    page_count INT
);
