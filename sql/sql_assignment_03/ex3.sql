ALTER TABLE Writer
RENaME TO Author;

ALTER TABLE Author
RENAME writer_id TO author_id;

ALTER TABLE Author
RENAME writer_name TO author_name;