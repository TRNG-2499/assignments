CREATE TABLE Writer (
    writer_id INT PRIMARY KEY,
    writer_name VARCHAR(100)
);

-- The author value points to a writer's ID.
CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(255),
    author INT REFERENCES Writer(writer_id),
    publication INT,
    page_count INT
);