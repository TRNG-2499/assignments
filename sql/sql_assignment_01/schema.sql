CREATE TABLE Writer (
    writer_id INT NOT NULL,
    writer_name VARCHAR(100) NOT NULL,
    CONSTRAINT pk_writer PRIMARY KEY (writer_id)
);

CREATE TABLE Books (
    book_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    author INT NOT NULL,
    publication DATE,
    page_count INT,
    CONSTRAINT pk_books PRIMARY KEY (book_id),
    CONSTRAINT fk_book_writer FOREIGN KEY (author) REFERENCES Writer(writer_id)
    REFERENCES Writer (writer_id)
);