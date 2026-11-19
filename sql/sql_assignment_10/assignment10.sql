-- get sum of all of stephen king's books in table
SELECT SUM(page_count)
FROM Books
WHERE author = (
		SELECT author_id
		FROM Author
		WHERE author_name = 'Stephen King'
	);