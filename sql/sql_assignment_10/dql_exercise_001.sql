SELECT SUM(page_count) FROM library.books 
	WHERE author IN (
		SELECT author_id FROM library.author WHERE author_name = 'Stephen King'
	);

