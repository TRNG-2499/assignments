CREATE TABLE Writer(
    writer_id INT PRIMARY KEY,
    writer_name VARCHAR(30)
);

CREATE TABLE Books(
    book_id INT PRIMARY KEY,
    title VARCHAR(30),
    author VARCHAR(30),
    publication VARCHAR(30),
    page_count INT
);