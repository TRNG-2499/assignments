ALTER TABLE Writer RENAME Author;
ALTER TABLE Author RENAME writer_id TO author_id, RENAME writer_name TO author_name;