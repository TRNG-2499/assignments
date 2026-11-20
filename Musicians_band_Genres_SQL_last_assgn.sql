--Exercise -- Musicians, Bands, and Genres

SELECT m.musician_name,
		m.instrument,
		b.band_name,
		g.genre_name FROM Musician m

	INNER JOIN Band b
	ON m.band_id = b.band_id

	INNER JOIN Genre g
	ON b.genre_id = g.genre_id

	ORDER BY m.musician_id;

--Exercise -- returns only musicians who play in a Rock band
SELECT m.musician_name,
		m.instrument,
		b.band_name,
		g.genre_name FROM Musician m

	INNER JOIN Band b
	ON m.band_id = b.band_id

	INNER JOIN Genre g
	ON b.genre_id = g.genre_id

	--WHERE g.genre_id =1
	WHERE g.genre_name = 'Rock'
	
	ORDER BY m.musician_id;


CREATE TABLE Genre (
    genre_id INT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL
);
INSERT INTO Genre (genre_id, genre_name) VALUES
    (1, 'Rock'),
    (2, 'Jazz'),
    (3, 'Pop'),
    (4, 'Folk');

SELECT * FROM Genre;	

CREATE TABLE Band (
    band_id INT PRIMARY KEY,
    genre_id INT REFERENCES Genre(genre_id),
    band_name VARCHAR(100) NOT NULL
);

INSERT INTO Band (band_id, genre_id, band_name) VALUES
    (1, 1, 'The Midnight Echo'),
    (2, 2, 'Blue Ember Quartet'),
    (3, 3, 'Neon Parade'),
    (4, 1, 'Hollow Crown'),
    (5, 4, 'Cedar & Pine');

SELECT * FROM Band;		

CREATE TABLE Musician (
    musician_id INT PRIMARY KEY,
    band_id INT REFERENCES Band(band_id),
    musician_name VARCHAR(100) NOT NULL,
    instrument VARCHAR(100) NOT NULL
);
INSERT INTO Musician (musician_id, band_id, musician_name, instrument) VALUES
    (1, 1, 'Dana Reeves', 'Guitar'),
    (2, 1, 'Leo Marsh', 'Drums'),
    (3, 2, 'Priya Anand', 'Saxophone'),
    (4, 2, 'Sam Okafor', 'Piano'),
    (5, 3, 'Cleo Vance', 'Vocals'),
    (6, 4, 'Jordan Hale', 'Bass'),
    (7, 5, 'Mia Sorrel', 'Acoustic Guitar'),
    (8, 5, 'Finn Calloway', 'Violin');

SELECT * FROM Musician;
	
