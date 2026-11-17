-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  ALTER TABLE Books 
  RENAME COLUMN book_id to isbn_13