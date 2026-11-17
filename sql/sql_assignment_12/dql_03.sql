SELECT author, AVG(page_count) AS avg_page_count
FROM Books
GROUP BY author,
ORDER BY avg_page_count ASC
LIMIT 1;