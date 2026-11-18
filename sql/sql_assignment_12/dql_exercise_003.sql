CREATE VIEW library.page_average AS
	SELECT author, AVG(page_count) AS avg_page FROM library.books 
	GROUP BY author;

SELECT author_name FROM library.author
	Where author_id IN (
	SELECT author FROM library.page_average
	WHERE avg_page = (SELECT MIN(avg_page) FROM library.page_average)
	);
	

