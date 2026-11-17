SELECT a.author_name, AVG(b.page_count) FROM assignment.books b JOIN assignment.author a ON b.author = a.author_id
GROUP BY a.author_id ORDER BY AVG(b.page_count) ASC LIMIT 1;