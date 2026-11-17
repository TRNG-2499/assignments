SELECT a.author_name, AVG(b.page_count) AS lowest_avg_page_count
FROM Books AS b
INNER JOIN Author AS a
    ON a.author_id = b.author
GROUP BY a.author_id, a.author_name
HAVING AVG(b.page_count) = (
    SELECT MIN(avg_page_count)
    FROM (
        SELECT
            AVG(page_count) AS avg_page_count
        FROM Books
        GROUP BY author
    ) AS author_averages
);