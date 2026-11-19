-- BASE SQL QUERY
SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician m
LEFT JOIN Band b
    ON m.band_id = b.band_id
LEFT JOIN Genre g
    ON b.genre_id = g.genre_id;

-- STRETCH SQL QUERY
SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician m
LEFT JOIN Band b
    ON m.band_id = b.band_id
LEFT JOIN Genre g
    ON b.genre_id = g.genre_id;
WHERE g.genre_name = 'Rock';