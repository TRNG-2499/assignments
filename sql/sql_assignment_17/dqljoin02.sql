--returns every musician name with their band and the genre they play
SELECT m.musician_name, b.band_name, g.genre_name
FROM musician m
JOIN band b
ON m.band_id = b.band_id
JOIN genre g
ON b.genre_id = g.genre_id

--returning only musicians who play in a rock band is very trivial given the above
SELECT m.musician_name --don't need the other fields
FROM musician m
JOIN band b
ON m.band_id = b.band_id
JOIN genre g
ON b.genre_id = g.genre_id
WHERE genre_name = 'Rock'