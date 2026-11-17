CREATE SCHEMA assignment_9;
BEGIN TRANSACTION;
	CREATE TABLE assignment_9.Author (
		author_id INTEGER PRIMARY KEY,
		author_name VARCHAR(100)
	);
	CREATE TABLE assignment_9.Books (
		book_id SERIAL PRIMARY KEY,
		title VARCHAR(200) NOT NULL,
		author INTEGER REFERENCES assignment_9.Author(author_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_9.Author VALUES(1003, 'Kurt Vonnegut');
	INSERT INTO assignment_9.Books VALUES(DEFAULT, 'Slaughterhouse-Five', 1003, 1969, 215);
COMMIT;

SELECT * FROM assignment_9.Books;

DELETE FROM assignment_9.Books WHERE title = 'Slaughterhouse-Five';


DROP SCHEMA assignment_9 CASCADE;