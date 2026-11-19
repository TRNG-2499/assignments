SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician m
JOIN Band b ON m.band_id = b.band_id
JOIN Genre g ON b.gendre_id = g.gendre_id

SELECT m.musician_name, b.band_name
FROM Musician m
JOIN Band b ON m.band_id = b.band_id
JOIN Genre g ON b.gendre_id = g.gendre_id
WHERE g.genre_name = 'Rock';