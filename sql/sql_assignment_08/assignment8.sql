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


INSERT INTO Author(author_name)
VALUES ('Mark Twain'); -- again, to simulate it existing
INSERT INTO Books (title,author,publication,page_count)
SELECT 'thing',author_id, 1234, 123
FROM Author
WHERE author_name = 'Mark Twain'; -- simulate an entry existing
-- Assignment 8 here
DELETE FROM Books
WHERE author = (
	SELECT author_id
	FROM Author
	WHERE author_name = 'Mark Twain');