SELECT a.author_name, SUM(b.page_count) AS total_page_count_of_all_books
FROM Books AS b 
INNER JOIN Author AS a 
    ON a.author_id = b.author
WhERE a.author_name = 'Stephen King'
GROUP BY a.author_name;