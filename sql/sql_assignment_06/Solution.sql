-- Assuming author_id is autoincremented
INSERT INTO Author (author_name)
VALUES ('J.K. Rowling');

-- If author_id is not autoincremented
INSERT INTO Author (author_id, author_name)
VALUES (1006, 'J.K. Rowling');