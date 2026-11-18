CREATE VIEW Averages AS
SELECT
    Author.author_name,
    AVG(page_count) AS average_page_count
FROM Author JOIN Books ON Author.author_id = Books.author
GROUP BY Author.author_id, Author.author_name;

SELECT * FROM Averages ORDER BY average_page_count DESC LIMIT 1;