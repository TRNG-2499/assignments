CREATE SCHEMA assignment_12;
BEGIN TRANSACTION;
	CREATE TABLE assignment_12.Author (
		author_id INTEGER PRIMARY KEY,
		author_name VARCHAR(20)
	);
	CREATE TABLE assignment_12.Books (
		book_id SERIAL PRIMARY KEY,
		title VARCHAR(50),
		author INTEGER REFERENCES assignment_12.Author(author_id),
		publication INTEGER,
		page_count INTEGER
	);
COMMIT;

BEGIN TRANSACTION;
	INSERT INTO assignment_12.Author VALUES(1001, 'Agatha Christie');
	INSERT INTO assignment_12.Author VALUES(1003, 'Kurt Vonnegut');
	INSERT INTO assignment_12.Author VALUES(1004, 'Mark Twain');
	INSERT INTO assignment_12.Books VALUES(DEFAULT, 'Cat''s Cradle', 1003, 1963, 270);
	INSERT INTO assignment_12.Books VALUES(DEFAULT, 'Murder on the Orient Express', 1001, 1934, 256);
	INSERT INTO assignment_12.Books VALUES(DEFAULT, 'And Then There Were None', 1001, 1939, 272);
	INSERT INTO assignment_12.Books VALUES(DEFAULT, 'Adventures of Huckleberry Finn', 1004, 1884, 800);
COMMIT;

SELECT * FROM assignment_12.Books;

SELECT * FROM assignment_12.Books WHERE publication <= 1950 AND publication >= 1900;

SELECT averages.average_counts AS "Minimum Average Page Count", averages.author_names AS "Author Name"
FROM (
	SELECT AVG(b.page_count) AS average_counts, a.author_name AS author_names 
	FROM assignment_12.Books b
	LEFT JOIN assignment_12.Author a ON b.author = a.author_id 
	GROUP BY a.author_id, a.author_name
) as averages
ORDER BY averages.average_counts ASC LIMIT 1;

ROLLBACK;

DROP SCHEMA assignment_12 CASCADE;