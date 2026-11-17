CREATE VIEW AuthorAvgPages AS 
SELECT author, AVG(page_count) AS avg_pages
FROM Books
GROUP BY author;

SELECT author, avg_pages AS min_avg_pages
FROM AuthorAvgPages
WHERE avg_pages = (SELECT MIN(avg_pages) FROM AuthorAvgPages);

SELECT a.author_name, v.avg_pages
FROM AuthorAvgPages AS v
JOIN Author AS a ON v.author = a.author_id
WHERE v.avg_pages = (SELECT MIN(avg_pages) FROM AuthorAvgPages);