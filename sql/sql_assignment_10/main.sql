SELECT SUM(page_count) FROM Books
    INNER JOIN Author a ON a.author_id = Books.author WHERE a.author_name = 'Stephen King';