CREATE TABLE Writer (
    writer_id INT PRIMARY KEY,
    writer_name VARCHAR(200)
);

CREATE TABLE Books(
    book_id INT PRIMARY KEY,
    title VARCHAR(200),
    author VARCHAR(200),
    "publication" INT,
    page_count INT
);