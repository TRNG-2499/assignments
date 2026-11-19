-- return author whose books have the lowest average page count
SELECT author_name
FROM Author
WHERE author_id IN (
	SELECT author
	FROM (
	    SELECT author, AVG(page_count) AS average_pages
	    FROM Books
	    GROUP BY author
	)
	WHERE average_pages IN (
	    SELECT MIN(average_pages)
	    FROM (
	        SELECT author, AVG(page_count) AS average_pages
	        FROM Books
	        GROUP BY author
	    )
	)
);