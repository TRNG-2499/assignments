INSERT INTO Books (title, author, publication, page_count) 
VALUES (
    '1984',
    SELECT author_id FROM Author WHERE author_name = 'George Orwell',
    '1949',
    328
);