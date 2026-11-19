# select avg(page count) for each 
SELECT a.author_name, AVG(page_count) AS avg_page_count FROM Books b
    JOIN Author a ON a.author_id = b.author
GROUP BY author
ORDER BY avg_page_count ASC LIMIT 1;


