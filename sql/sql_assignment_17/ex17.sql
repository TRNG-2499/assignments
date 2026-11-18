SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician As m 
LEFT JOIN Band AS b 
    ON m.band_id = b.band_id
LEFT JOIN Genre As g 
    ON b.genre_id = g.genre_id;


SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician As m 
LEFT JOIN Band AS b 
    ON m.band_id = b.band_id
LEFT JOIN Genre As g 
    ON b.genre_id = g.genre_id
WHERE g.genre_name = 'Rock';
