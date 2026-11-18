
CREATE VIEW v_author_avg_pages AS
SELECT 
    a.author_id,
    a.author_name,
    AVG(b.page_count) AS avg_page_count
FROM Author a
JOIN Books b ON a.author_id = b.author
GROUP BY a.author_id, a.author_name;


SELECT author_name, avg_page_count
FROM v_author_avg_pages
ORDER BY avg_page_count ASC
LIMIT 1;