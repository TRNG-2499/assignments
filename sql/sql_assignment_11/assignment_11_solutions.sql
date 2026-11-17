CREATE SCHEMA assignment_11;
BEGIN TRANSACTION;
	CREATE TABLE assignment_11.Author (
		author_id INTEGER PRIMARY KEY,
		author_name VARCHAR(20)
	);
	CREATE TABLE assignment_11.Books (
		book_id SERIAL PRIMARY KEY,
		title VARCHAR(50),
		author INTEGER REFERENCES assignment_11.Author(author_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_11.Author VALUES(1001, 'Agatha Christie');
	INSERT INTO assignment_11.Author VALUES(1003, 'Kurt Vonnegut');
	INSERT INTO assignment_11.Author VALUES(1004, 'Mark Twain');
	INSERT INTO assignment_11.Books VALUES(DEFAULT, 'Cat''s Cradle', 1003, 1963, 304);
	INSERT INTO assignment_11.Books VALUES(DEFAULT, 'Murder on the Orient Express', 1001, 1934, 256);
	INSERT INTO assignment_11.Books VALUES(DEFAULT, 'And Then There Were None', 1001, 1939, 272);
	INSERT INTO assignment_11.Books VALUES(DEFAULT, 'Adventures of Huckleberry Finn', 1004, 1884, 366);
COMMIT;

SELECT * FROM assignment_11.Books;

SELECT * FROM assignment_11.Books WHERE publication <= 1950 AND publication >= 1900;

ROLLBACK;

DROP SCHEMA assignment_10 CASCADE;