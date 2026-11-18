select m.musician_name, b.band_name, g.genre_name from Musician m
inner join Band b on m.band_id = b.band_id
inner join Genre g on b.genre_id = g.genre_id; 
