/*
CREATE TABLE Genre (
	genre_id SERIAL PRIMARY KEY,
	genre_name VARCHAR(10)
);

CREATE TABLE Band (
	band_id SERIAL PRIMARY KEY,
	genre_id SERIAL REFERENCES Genre(genre_id),
	band_name VARCHAR(100)
);

CREATE TABLE Musician (
	musician_id SERIAL PRIMARY KEY,
	band_id SERIAL REFERENCES Band(band_id),
	musician_name VARCHAR(100),
	instrument VARCHAR(50)
);

INSERT INTO Genre (genre_name) VALUES ('Rock');
INSERT INTO Genre (genre_name) VALUES ('Jazz');
INSERT INTO Genre (genre_name) VALUES ('Pop');
INSERT INTO Genre (genre_name) VALUES ('Folk');

INSERT INTO Band (genre_id, band_name) VALUES (1, 'The Midnight Echo');
INSERT INTO Band (genre_id, band_name) VALUES (2, 'Blue Ember Quartet');
INSERT INTO Band (genre_id, band_name) VALUES (3, 'Neon Parade');
INSERT INTO Band (genre_id, band_name) VALUES (1, 'Hollow Crown');
INSERT INTO Band (genre_id, band_name) VALUES (4, 'Cedar & Pine');

INSERT INTO Musician (band_id, musician_name, instrument) VALUES (1, 'Dana Reeves', 'Guitar');
INSERT INTO Musician (band_id, musician_name, instrument) VALUES (1, 'Leo Marsh', 'Drums');
INSERT INTO Musician (band_id, musician_name, instrument) VALUES (2, 'Priya Anand', 'Saxophone');
INSERT INTO Musician (band_id, musician_name, instrument) VALUES (2, 'Sam Okafor', 'Piano');
INSERT INTO Musician (band_id, musician_name, instrument) VALUES (3, 'Cleo Vance', 'Vocals');
INSERT INTO Musician (band_id, musician_name, instrument) VALUES (4, 'Jordan Hale', 'Bass');
INSERT INTO Musician (band_id, musician_name, instrument) VALUES (5, 'Mia Sorrel', 'Acoustic Guitar');
INSERT INTO Musician (band_id, musician_name, instrument) VALUES (5, 'Finn Calloway', 'Violin');
*/

SELECT m.musician_name, b.band_name, g.genre_name FROM musician m, band b, genre g WHERE m.band_id = b.band_id AND b.genre_id = g.genre_id;