Select a.author_name, AVG(b.page_count) AS avg_page 
    FROM Author AS a JOIN Books as b 
        ON a.author_id = b.author
    GROUP BY author_id 
    ORDER BY avg_page ASC
    LIMIT 1;