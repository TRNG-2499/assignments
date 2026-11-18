SELECT b.band_name, g.genre_name, m.musician_name
FROM Genre as g
JOIN Band as b
ON g.genre_id = b.genre_id
JOIN Musician as m
ON m.band_id = b.band_id
