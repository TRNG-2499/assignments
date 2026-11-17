-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  DELETE FROM Books
  WHERE author = (
	SELECT author_id
	FROM author
	WHERE author_name = 'Mark Twain'
  );