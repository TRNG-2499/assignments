DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Author;

CREATE TABLE Author (
    author_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    author_name TEXT
);

CREATE TABLE Books (
    book_id BIGINT PRIMARY KEY,
    title TEXT,
    author BIGINT REFERENCES Author(author_id),
    publication BIGINT,
    page_count BIGINT
);

-- Assignment 6 here
INSERT INTO Author (author_name)
VALUES ('Marie'); -- would have to provide id if I didn't make it auto generate it.
-- like VALUES (1001,'Marie')