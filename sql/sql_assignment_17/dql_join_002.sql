SELECT m.musician_name, m.instrument, b.band_name, g.genre_name FROM Musician AS m
LEFT JOIN Band AS b ON m.band_id = b.band_id
LEFT JOIN Genre AS g ON b.genre_id = g.genre_id;

SELECT m.musician_name, g.genre_name FROM Musician AS m
LEFT JOIN Band AS b ON m.band_id = b.band_id
LEFT JOIN Genre AS g ON b.genre_id = g.genre_id
WHERE g.genre_name = 'Rock';