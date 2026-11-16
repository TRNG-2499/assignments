ALTER TABLE Writer RENAME TO Author;

ALTER TABLE Writer 
RENAME COLUMN writer_id TO author_id, 
RENAME COLUMN writer_name TO author_name;