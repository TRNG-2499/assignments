SELECT Author.author_name, AVG(Books.page_count) AS avg_pages
FROM Author as a
JOIN Books as b ON a.author_id = b.author
GROUP BY a.author_id, a.author_name
ORDER BY avg_pages ASC
LIMIT 1;