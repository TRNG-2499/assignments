SELECT author, AVG(page_count) FROM Books GROUP BY author;

SELECT MIN(avg_pages) 
FROM (SELECT AVG(page_count) AS avg_pages FROM Books GROUP BY author)
AS author_averages;