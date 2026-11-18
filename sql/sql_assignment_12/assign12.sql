/*
*Given the following tables, 
provide an SQL statement (or a series of 
statements) that will find the author 
whose books have the lowest average page
count.

Note: This exercise is more difficult than you might think initially. I recommend that you first solve the problem through a series of SQL statements, then attempt to combine them into a single statement.

You are permitted to create views as well.
*/

SELECT author, AVG(page_count) AS average_pages
FROM Books
GROUP BY author
HAVING AVG(page_count) = (
    SELECT MIN(avg_pages)
    FROM (
        SELECT AVG(page_count) AS avg_pages
        FROM Books
        GROUP BY author
    ) AS averages
);
