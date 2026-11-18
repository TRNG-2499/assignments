SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician AS m JOIN Band AS b ON m.band_id = b.band_id
JOIN Genre AS g ON g.genre_id = b.genre_id;

SELECT m.musician_name
FROM Musician AS m JOIN Band AS b ON m.band_id = b.band_id
JOIN Genre AS g ON g.genre_id = b.genre_id
WHERE b.genre_name = 'Rock';