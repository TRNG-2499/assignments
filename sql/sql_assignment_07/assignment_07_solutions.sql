CREATE SCHEMA assignment_7;
BEGIN TRANSACTION;
	CREATE TABLE assignment_7.Author (
		author_id INTEGER PRIMARY KEY,
		author_name VARCHAR(100)
	);
	CREATE TABLE assignment_7.Books (
		book_id SERIAL PRIMARY KEY,
		title VARCHAR(200) NOT NULL,
		author INTEGER REFERENCES assignment_7.Author(author_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_7.Author VALUES(1002, 'George Orwell');
	INSERT INTO assignment_7.Books VALUES(DEFAULT, 'Burmese Days', 1002, 1934, 288);
COMMIT;

SELECT * FROM assignment_7.Author;
SELECT * FROM assignment_7.Books;

DROP SCHEMA assignment_7 CASCADE;