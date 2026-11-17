/*Given the following tables, provide an SQL Statement
that will change the name of the "Writer" table to "Author". Next, 
provide statements that will rename the writer_id and writer_name columns
to author_id and author_name respectively.*/

RENAME TABLE Writer TO Author;

ALTER TABLE Author
RENAME COLUMN writer_id TO author_id;

ALTER TABLE Author
RENAME COLUMN writer_name TO author_name;

