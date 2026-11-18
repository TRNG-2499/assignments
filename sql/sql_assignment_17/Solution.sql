SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician AS m
JOIN Band AS b on m.band_id = b.band_id
JOIN Genre AS g on b.genre_id = g.genre_id;
