INSERT INTO Books (title, author, publication, page_count)
SELECT 'Animal Farm', author_id, 1945, 112
FROM Author
WHERE author_name = 'George Orwell';