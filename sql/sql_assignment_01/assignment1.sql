CREATE TABLE writer (
    writer_id INT NOT NULL,
    writer_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (writer_id)
);

CREATE TABLE books (
    title VARCHAR(100) NOT NULL,
    book_id INT NOT NULL,
    author INT NOT NULL,
    publication INT NOT NULL,
    page_count INT NOT NULL,
    PRIMARY KEY (book_id),
    FOREIGN KEY (author) REFERENCES writer (writer_id)
);