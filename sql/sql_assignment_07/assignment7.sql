DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Author;

CREATE TABLE Author (
    author_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    author_name TEXT
);

CREATE TABLE Books (
    book_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title TEXT,
    author BIGINT REFERENCES Author(author_id),
    publication BIGINT,
    page_count BIGINT
);

-- Assignment 7 here
INSERT INTO Author (author_name)
VALUES ('George Orwell'); -- gonna simulate that the table value exists here
INSERT INTO Books (title,author,publication,page_count)
SELECT '1984',author_id, 1949, 328
FROM Author
WHERE author_name = 'George Orwell';
