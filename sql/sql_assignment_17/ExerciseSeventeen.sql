SELECT musician_name, band_name, genre_name FROM Musician
JOIN Band ON Musician.band_id = Band.band_id
JOIN Genre ON Band.genre_id = Genre.genre_id;

SELECT musician_name, band_name, genre_name FROM Musician
JOIN Band ON Musician.band_id = Band.band_id
JOIN Genre ON Band.genre_id = Genre.genre_id
WHERE Genre.genre_name = 'Rock';

