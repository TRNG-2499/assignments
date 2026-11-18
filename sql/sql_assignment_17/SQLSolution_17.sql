SELECT 
    m.musician_name AS "Musician",
    b.band_name AS "Band Name",
    g.genre_name AS "Genre"
FROM assignment.musician m 
JOIN assignment.band b ON m.band_id = b.band_id
JOIN assignment.genre g ON b.genre_id = g.genre_id;

SELECT m.musician_name FROM assignment.musician m JOIN assignment.band b
ON m.band_id = b.band_id JOIN assignment.genre g ON b.genre_id = g.genre_id
WHERE g.genre_name = 'Rock';