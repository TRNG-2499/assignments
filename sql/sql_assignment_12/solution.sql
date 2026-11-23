SELECT author_name, avg(page_count) FROM Books JOIN Author ON Books.author= Author.author_id  GROUP BY author_name ORDER BY avg(page_count) ASC LIMIT 1;
