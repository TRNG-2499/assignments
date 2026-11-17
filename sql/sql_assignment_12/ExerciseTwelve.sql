SELECT author_name, AVG(page_count) FROM BOOKS

JOIN author ON books.author = author.author_id

GROUP BY author_name

ORDER BY AVG(page_count) ASC LIMIT 1;