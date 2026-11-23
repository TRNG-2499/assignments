CREATE OR REPLACE VIEW average_page_counts AS
SELECT a.author_id, a.author_name, AVG(b.page_count) AS average_page_count FROM Author a, Books b WHERE a.author_id = b.author GROUP BY a.author_id;

CREATE OR REPLACE VIEW min_average_page_count AS
SELECT MIN(average_page_count) FROM average_page_counts;

--SELECT * FROM average_page_counts;
--SELECT * FROM min_average_page_count;

SELECT author_id, author_name FROM average_page_counts WHERE average_page_count = (SELECT * FROM min_average_page_count);