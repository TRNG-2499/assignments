SELECT author, avg(page_count) as avg_pages
FROM books
GROUP BY author
ORDER BY avg_pages ASC
LIMIT 1