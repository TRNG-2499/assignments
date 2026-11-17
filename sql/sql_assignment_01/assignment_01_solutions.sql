CREATE SCHEMA assignment_1;
BEGIN TRANSACTION;
	CREATE TABLE assignment_1.Writer (
		writer_id INTEGER PRIMARY KEY,
		writer_name VARCHAR(100)
	);
	CREATE TABLE assignment_1.Books (
		book_id INTEGER PRIMARY KEY,
		title VARCHAR(200) NOT NULL,
		author INTEGER REFERENCES assignment_1.Writer(writer_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_1.writer VALUES(1001, 'Agatha Christie');
	INSERT INTO assignment_1.writer VALUES(1002, 'George Orwell');
	INSERT INTO assignment_1.writer VALUES(1003, 'Kurt Vonnegut');
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_1.books VALUES(3050, 'Murder on the Orient Express', 1001, 1934, 256);
	INSERT INTO assignment_1.books VALUES(3055, 'Nineteen Eighty-Four', 1002, 1949, 328);
	INSERT INTO assignment_1.books VALUES(3062, 'Cat''s Cradle', 1003, 1963, 304);
COMMIT;
ROLLBACK; -- in case of error
SELECT * FROM assignment_1.writer;
SELECT * FROM assignment_1.books;

DROP SCHEMA assignment_1 CASCADE;
