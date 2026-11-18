SELECT a.author_name, AVG(b.page_count) AS avg_pages
FROM Author AS a
JOIN Books AS b ON a.author_id = b.author
GROUP BY a.author_id, a.author_name
ORDER BY avg_pages ASC
LIMIT 1;