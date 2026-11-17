SELECT FIRST(Author.Name) AS 'Name'
FROM Author
JOIN Books ON Books.Author = Author.AuthorID
ORDER BY AVG(Books.PageCount) ASC;

