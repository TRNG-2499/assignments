DELETE Books
FROM Books
JOIN Author ON Books.Author = Author.AuthorID
WHERE Author.Name = 'Mark Twain';
