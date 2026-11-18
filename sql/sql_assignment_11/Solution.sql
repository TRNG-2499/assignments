-- Uses BETWEEN
SELECT title
FROM Books
WHERE publication BETWEEN 1900 AND 1950;

-- doesn't use BETWEEN
SELECT title
FROM Books
WHERE publication >= 1900 AND publication <= 1950;