SELECT author_name FROM Author
WHERE author_id = (
    SELECT author FROM Books
    GROUP BY author
    ORDER BY AVG(page_count) ASC
    LIMIT 1
); -- got to test this one out to make sure