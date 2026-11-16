CREATE TABLE IF NOT EXISTS Writer (
    writer_id INT PRIMARY KEY, 
    writer_name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS Books(
    book_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author INT NOT NULL, 
    FOREIGN KEY (author) REFERENCES Writer(writer_id), 
    publication INT, 
    page_count INT CHECK (page_count > 0)
);

