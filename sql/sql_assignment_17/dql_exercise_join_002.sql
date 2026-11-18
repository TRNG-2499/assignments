SELECT Musician.musician_name, Band.band_name, Genre.genre_name FROM Musician
JOIN Band ON Musician.band_id=Band.band_id
JOIN Genre ON Band.genre_id=Genre.genre_id;