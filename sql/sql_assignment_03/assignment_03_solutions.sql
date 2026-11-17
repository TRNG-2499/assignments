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

SELECT * FROM assignment_2.Writer;

ALTER TABLE assignment_2.Writer RENAME TO Author;
ALTER TABLE assignment_2.Author RENAME COLUMN writer_id TO author_id;
ALTER TABLE assignment_2.Author RENAME COLUMN writer_name TO author_name;
SELECT * FROM assignment_2.Author;

DROP SCHEMA assignment_2 CASCADE; -- cascade removes all dependencies to the schema as well