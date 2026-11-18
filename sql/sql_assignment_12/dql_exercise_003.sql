/*  Find average page count of each author
*   Get minimum of these
*/

CREATE VIEW authors_averages AS
SELECT author, AVG(page_count) AS avg_pages
FROM Books GROUP BY author;
SELECT author FROM authors_averages
WHERE avg_pages = (SELECT MIN(avg_pages) FROM authors_averages);