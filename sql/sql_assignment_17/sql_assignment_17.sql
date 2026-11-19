-- Musician + Band + Genre
create table band (
	band_id integer generated always as identity primary key,
	genre_id integer,
	band_name varchar,
	foreign key(genre_id) references genre(genre_id)
);

-- Stretch goal
create table musician (
	musician_id integer generated always as identity primary key,
	band_id integer,
	musician_name varchar,
	instrument varchar,
	foreign key(band_id) references band(band_id)
);
