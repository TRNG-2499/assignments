Select Sum(b.page_count) from 
    Author AS a JOIN Books as b 
        ON a.author_id = b.author
    WHERE author_id = 1005
    GROUP BY author_id;