CREATE SCHEMA assignment_2;
BEGIN TRANSACTION;
	CREATE TABLE assignment_2.Writer (
		writer_id INTEGER PRIMARY KEY,
		writer_name VARCHAR(100)
	);
	CREATE TABLE assignment_2.Books (
		book_id INTEGER PRIMARY KEY,
		title VARCHAR(200) NOT NULL,
		author INTEGER REFERENCES assignment_2.Writer(writer_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

SELECT * FROM assignment_2.Books;

ALTER TABLE assignment_2.Books
RENAME COLUMN book_id TO isbn_13;

SELECT * FROM assignment_2.Books;
DROP SCHEMA assignment_2 CASCADE;