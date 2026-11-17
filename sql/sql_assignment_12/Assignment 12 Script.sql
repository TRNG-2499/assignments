SELECT author_name
FROM Author JOIN Books ON Author.author_id = Books.author
GROUP BY author_name
ORDER BY AVG(page_count) ASC
LIMIT 1;