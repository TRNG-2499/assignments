SELECT m.musician_name, b.band_name, g.genre_name FROM band b
    JOIN musician m ON m.band_id = b.band_id
    JOIN genre g ON g.genre_id = b.genre_id;