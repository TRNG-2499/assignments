CREATE TABLE Writer {
    writer_id INT PRIMARY KEY AUTO_INCREMENT,
    writer_name VARCHAR(100) NOT NULL UNIQUE
}

CREATE TABLE BOOKS {
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author INT,
    publication SMALLINT NOT NULL CHECK (publication BETWEEN 1900 AND 2100),
    page_count INT NOT NULL,
    FOREIGN KEY (author) REFERENCES Writer(writer_id)
}