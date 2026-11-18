Select m.musician_name, b.band_name, g.genre_name 
    FROM 
        Musician as m JOIN Band as b ON m.band_id = b.band_id
        JOIN Genre as g ON g.genre_id = b.genre_id;


Select m.musician_name, b.band_name, g.genre_name 
    FROM 
        Musician as m JOIN Band as b ON m.band_id = b.band_id
        JOIN Genre as g ON g.genre_id = b.genre_id;
    Where g.genre_id = 1;