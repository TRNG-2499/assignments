SELECT a.author_name, x.avg 
FROM (SELECT author, AVG(page_count) AS avg FROM Books GROUP BY author) x
JOIN Author a ON a.author_id = x.author
ORDER BY x.avg LIMIT 1;