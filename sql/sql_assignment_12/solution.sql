SELECT a.author_name, AVG(b.page_count) AS avg_pages
FROM Books b
JOIN Author a ON b.author = a.author_id
GROUP BY a.author_id, a.author_name
ORDER BY avg_pages ASC
LIMIT 1;