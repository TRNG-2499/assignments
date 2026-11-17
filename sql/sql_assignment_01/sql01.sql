CREATE TABLE writer(
    writer_id INT PRIMARY KEY,
    writer_name VARCHAR(100) NOT NULL
);

CREATE TABLE books(
    book_id INT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author INT NOT NULL REFERENCES writer(writer_id),
    publication INT,
    page_count INT
);