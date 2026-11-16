ALTER TABLE writer RENAME TO Author;

ALTER TABLE author RENAME COLUMN writer_id TO author_id;
ALTER TABLE author RENAME COLUMN writer_name TO author_name;