INSERT INTO Books (title, author, publication, page_count)
SELECT 'Homage to Catalonia', author_id, 1938, 232
FROM Author
WHERE author_name = 'George Orwell';