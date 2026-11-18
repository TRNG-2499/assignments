-- Calculate an average for each author who has books.
WITH averages AS (
    SELECT a.author_id, a.author_name, AVG(b.page_count) AS average_pages
    FROM Author a
    JOIN Books b ON a.author_id = b.author
    GROUP BY a.author_id, a.author_name
)
-- If authors tie for the lowest average, show each one.
SELECT author_name, average_pages
FROM averages
WHERE average_pages = (SELECT MIN(average_pages) FROM averages);