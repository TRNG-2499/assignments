CREATE VIEW author_avg_pages AS
SELECT author, AVG(page_count) AS avg_pages
FROM Books
GROUP BY author;

SELECT a.author_name, v.avg_pages
FROM author_avg_pages v
JOIN Author a ON a.author_id = v.author
WHERE v.avg_pages = (SELECT MIN(avg_pages) FROM author_avg_pages);

-- Single statement (no view needed)
SELECT a.author_name, AVG(b.page_count) AS avg_pages
FROM Author a
JOIN Books b ON b.author = a.author_id
GROUP BY a.author_id, a.author_name
ORDER BY avg_pages ASC
LIMIT 1;