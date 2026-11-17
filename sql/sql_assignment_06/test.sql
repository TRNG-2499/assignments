-- assumes serial primary key type
INSERT INTO Author(AuthorName)
VALUES ('J.K. Rowling');

-- otherwise,
INSERT INTO Author(AuthorID, AuthorName)
VALUES (1006, 'J.K. Rowling');
