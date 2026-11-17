-- Create Author table
CREATE TABLE writer_books.Author (
    author_id int NOT NULL PRIMARY KEY,
    author_name VARCHAR(120) NOT NULL
);

--Delete exisiting George Orwell Author

DELETE FROM writer_books.Author WHERE author_id = 1002;

--Exercise TWO
-- Insert George Orwell and other new author
INSERT INTO writer_books.Author (author_id, author_name) VALUES (1002, 'George Orwell');
INSERT INTO writer_books.Author (author_id, author_name) VALUES (1006, 'J.K. Rowling');

SELECT * FROM writer_books.Author;


-- Order by author id in ascending
SELECT * FROM writer_books.Author ORDER BY author_id ASC;

DROP TABLE writer_books.Books;

CREATE TABLE writer_books.Books(
book_id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
author_id int NOT NULL,
publication int, 
page_count int, 
FOREIGN KEY (author_id) REFERENCES writer_books.Author(author_id)
);

DROP TABLE writer_books.Books;
ALTER SEQUENCE writer_books.Books_book_id_seq RESTART WITH 3050; 

--Exercise TWO -- --Adding new book written by George Orwell 

INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('Animal Farm', 1002, 1945, 256);

--DELETE FROM writer_books.Books WHERE book_id = 1;

--Adding books written by George Orwell and other books written by other authors

INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('Murder on the Orient Express', 1001, 1934, 258);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('It', 1005, 1986, 1138);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('And Then There Were NONE', 1001, 1986, 1138);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('PET Sematary', 1005, 1983, 373);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('Nineteen Eighty-Four', 1002, 1949, 328);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('Slaughterhouse-five', 1003, 1969, 215);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('Adventures of Huckleberry Finn', 1004, 1884, 366);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('DEATH on the Nile', 1001, 1937, 288);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('The Adventure of Tom Sawyer', 1004, 1876, 274);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('The Shining', 1005, 1977, 447);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('Salem"s Lot', 1005, 1975, 439);
INSERT INTO writer_books.Books (title, author_id, publication, page_count) 
VALUES ('Cat"s Cradle', 1003, 1963, 304);


SELECT * FROM writer_books.Books;


--Exercise TWO -- Remove all books written by Mark Twain
DELETE FROM writer_books.Books WHERE author_id = 1004;

SELECT * FROM writer_books.Books;

--Exercise TWO -- Update page count of Slaughterhouse-Five to 220

UPDATE writer_books.Books
SET page_count = 220
WHERE book_id = 3056;

SELECT * FROM writer_books.Books ORDER By book_id ASC;

-- Exercise TWO -- Will return the total page count of all books written by stephen king. 

SELECT SUM(page_count) FROM writer_books.Books WHERE author_id = 1005;

--Exercise TWO -- "will return all books which were published between 1900 and 1950."

SELECT title FROM writer_books.Books WHERE publication BETWEEN 1900 AND 1965;

--Exercise Three -- that will find the author whose books have the lowest average page count.

--Calculate average page count by author
SELECT author_id, AVG(page_count) AS average_pages
FROM writer_books.Books GROUP BY author_id ORDER BY average_pages ASC;  

--Round to two decimal
SELECT author_id, ROUND(AVG(page_count), 2) As average_pages
FROM writer_books.Books GROUP BY author_id ORDER BY average_pages ASC;

