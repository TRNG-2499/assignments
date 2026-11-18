-- Show each musician, their band, and the band's genre.
SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician m
JOIN Band b ON m.band_id = b.band_id
JOIN Genre g ON b.genre_id = g.genre_id;

-- Stretch goal: show only musicians who play in a Rock band.
SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician m
JOIN Band b ON m.band_id = b.band_id
JOIN Genre g ON b.genre_id = g.genre_id
WHERE g.genre_name = 'Rock';