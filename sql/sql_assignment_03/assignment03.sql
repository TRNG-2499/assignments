-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  ALTER TABLE Writer
  RENAME TO Author;

  ALTER TABLE Author 
  RENAME COLUMN writer_id to author_id;

  ALTER TABLE Author 
  RENAME COLUMN writer_name to author_name;