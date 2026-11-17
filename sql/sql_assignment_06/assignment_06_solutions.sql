CREATE SCHEMA assignment_6;
BEGIN TRANSACTION;
	CREATE TABLE assignment_6.Author (
		author_id INTEGER PRIMARY KEY,
		author_name VARCHAR(100)
	);
	CREATE TABLE assignment_6.Books (
		book_id INTEGER PRIMARY KEY,
		title VARCHAR(200) NOT NULL,
		author INTEGER REFERENCES assignment_6.Author(author_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_6.Author VALUES(1006, 'J.R.R Tolkien');
COMMIT;

SELECT * FROM assignment_6.Author;

DROP SCHEMA assignment_6 CASCADE;