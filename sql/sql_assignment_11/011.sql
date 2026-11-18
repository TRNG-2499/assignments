






SELECT b.book_id, b.title, a.author_name, b.publication, b.page_count
FROM Books b
JOIN Author a ON b.author = a.author_id
WHERE b.publication BETWEEN 1900 AND 1950;