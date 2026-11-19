DELETE b FROM Books b INNER JOIN Author a ON b.author = a.author_id
WHERE a.author_name = 'Mark Twain';