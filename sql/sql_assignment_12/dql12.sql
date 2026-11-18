CREATE VIEW author_avg_pages AS 
SELECT a.author_id, a.author_name, AVG(b.page_count) AS avg_pages
FROM Author a
JOIN Books b ON b.author = a.author_id
GROUP BY a.author_id, a.author_name;

SELECT MIN(avg_pages) FROM author_avg_pages;

SELECT author_name, avg_pages
FROM author_avg_pages
WHERE avg_pages = (SELECT MIN(avg_pages) FROM author_avg_pages);
