-- Create Author table
CREATE TABLE writer_books.Author (
    author_id VARCHAR(120) NOT NULL PRIMARY KEY,
    author_name VARCHAR(120) NOT NULL
);

-- Insert existing authors and one new author
INSERT INTO writer_books.Author (author_id, author_name)
VALUES ('1006', 'J.K. Rowling');


SELECT * FROM writer_books.Author;