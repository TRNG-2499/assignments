CREATE TABLE Writer
(
    writer_id   int PRIMARY KEY,
    writer_name varchar(50) NOT NULL
);

CREATE TABLE Books
(
    book_id int PRIMARY KEY,
    title   varchar(50),
    author  int;
);