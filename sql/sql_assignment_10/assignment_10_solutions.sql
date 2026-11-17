CREATE SCHEMA assignment_10;
BEGIN TRANSACTION;
	CREATE TABLE assignment_10.Author (
		author_id INTEGER PRIMARY KEY,
		author_name VARCHAR(100)
	);
	CREATE TABLE assignment_10.Books (
		book_id SERIAL PRIMARY KEY,
		title VARCHAR(200) NOT NULL,
		author INTEGER REFERENCES assignment_10.Author(author_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_10.Author VALUES(1005, 'Stephen King');
	INSERT INTO assignment_10.Books VALUES(DEFAULT, 'It', 1005, 1986, 1138);
	INSERT INTO assignment_10.Books VALUES(DEFAULT, 'Pet Semetary', 1005, 1983, 373);
COMMIT;

SELECT SUM(page_count) FROM assignment_10.Books WHERE author = 1005;

DROP SCHEMA assignment_10 CASCADE;