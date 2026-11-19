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

INSERT INTO Author (author_name)
VALUES ('Kurt Vonnegut'); -- gonna simulate that the table value exists here
INSERT INTO Books (title,author,publication,page_count)
SELECT 'Slaughterhouse-Five',author_id, 1969, 215
FROM Author
WHERE author_name = 'Kurt Vonnegut'; -- simulate book in table

-- Assignment 9 here
UPDATE Books
SET page_count = 220
WHERE title = 'Slaughterhouse-Five'