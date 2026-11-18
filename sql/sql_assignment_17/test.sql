SELECT Musician.musician_name as 'Name', Band.band_name as 'Band', Genre.genre_name as 'Genre'
FROM Musician
JOIN Band ON Musician.band_id = Band.band_id
JOIN Genre ON Band.genre_id = Genre.genre_id;

-- stretch goal
SELECT Musician.musician_name as 'Name', Band.band_name as 'Band'
FROM Musician
JOIN Band ON Musician.band_id = Band.band_id
JOIN Genre ON Band.genre_id = Genre.genre_id;
WHERE Genre.genre_name = 'Rock';
