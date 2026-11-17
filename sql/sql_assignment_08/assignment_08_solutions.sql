CREATE SCHEMA assignment_8;
BEGIN TRANSACTION;
	CREATE TABLE assignment_8.Author (
		author_id INTEGER PRIMARY KEY,
		author_name VARCHAR(100)
	);
	CREATE TABLE assignment_8.Books (
		book_id SERIAL PRIMARY KEY,
		title VARCHAR(200) NOT NULL,
		author INTEGER REFERENCES assignment_8.Author(author_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_8.Author VALUES(1004, 'Mark Twain');
	INSERT INTO assignment_8.Books VALUES(DEFAULT, 'Adventures of Huckleberry Finn', 1004, 1884, 366);
	INSERT INTO assignment_8.Books VALUES(DEFAULT, 'The Adventures of Tom Sawyer', 1004, 1876, 274);
COMMIT;
ROLLBACK;

SELECT * FROM assignment_8.Author;
SELECT * FROM assignment_8.Books;

DELETE FROM assignment_8.Books WHERE author = 1004;

DROP SCHEMA assignment_8 CASCADE;