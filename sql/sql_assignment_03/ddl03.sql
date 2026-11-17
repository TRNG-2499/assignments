ALTER TABLE writer RENAME author;
ALTER TABLE author RENAME COLUMN writer_id TO author_id;
ALTER TABLE author RENAME COLUMN writer_name TO author_name;