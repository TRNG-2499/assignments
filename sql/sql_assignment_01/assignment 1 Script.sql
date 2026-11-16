CREATE TABLE Writer(
writer_id INT Primary Key,
writer_name varChar(50)
);

CREATE TABLE Books(
book_id INT Primary Key,
title varChar(100),
author INT REFERENCES Writer(writer_id),
publication INT,
page_count INT
);