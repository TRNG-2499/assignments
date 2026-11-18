-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  SELECT m.musician_name, b.band_name, g.genre_name
  FROM musician m
  JOIN band b ON b.band_id = m.band_id
  JOIN genre g ON g.genre_id = b.genre_id;
  