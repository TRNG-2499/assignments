-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  SELECT player_name
  FROM player
  WHERE player_name LIKE 'Jo%';

  SELECT player_name
  FROM player
  WHERE player_name LIKE '%a%e%';