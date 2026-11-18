SELECT SUM(b.page_count) AS total_pages
FROM Books b
JOIN Author a ON b.author = a.author_id
WHERE a.author_name = 'Stephen King';