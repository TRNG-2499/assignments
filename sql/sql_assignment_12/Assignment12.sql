-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  WITH AuthorAvg AS (
    SELECT author, AVG(page_count) AS avg_pages
    FROM books
    GROUP BY author
)
SELECT a.author_name, aa.avg_pages
FROM AuthorAvg aa
JOIN Author a ON a.author_id = aa.author
WHERE aa.avg_pages = (SELECT MIN(avg_pages) FROM AuthorAvg);