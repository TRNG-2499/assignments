SELECT SUM(Books.PageCount) AS 'TOTAL PAGES'
FROM Books
JOIN Author ON Books.Author = Author.AuthorID
WHERE Author.Name = 'Stephen King';
