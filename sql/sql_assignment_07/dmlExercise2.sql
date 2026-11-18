--The Books table uses Serial Datatype for the Book_id column
--This means I don't need to include book_id in my statement as Serial automatically generates it
INSERT INTO Books (title, author, publication, page_count) VALUES ('Down and Out in Paris and London', 1002, 1933, 224);