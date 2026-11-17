

CREATE TABLE Writer (
    writer_id INT PRIMARY KEY,
    writer_name VARCHAR(255) NOT NULL
);

CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author INT,
    publication INT,
    page_count INT,
    FOREIGN KEY (author) REFERENCES Writer(writer_id)
);