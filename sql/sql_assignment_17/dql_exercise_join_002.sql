SELECT m.musician_name, b.band_name, g.genre_name FROM musician m
	INNER JOIN band b ON b.band_id = m.band_id
	INNER JOIN genre g ON g.genre_id = b.genre_id;

SELECT m.musician_name, b.band_name, g.genre_name FROM musician m
	INNER JOIN band b ON b.band_id = m.band_id
	INNER JOIN genre g ON g.genre_id = b.genre_id
	WHERE g.genre_name = 'Rock';