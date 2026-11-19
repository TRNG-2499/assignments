CREATE TABLE state_team.State (
state_id BIGSERIAL NOT NULL PRIMARY KEY,
state_name VARCHAR (30) NOT NULL
);

--DROP TABLE state_team.State;
SELECT * FROM state_team.State;

ALTER SEQUENCE state_team.State_state_id_seq RESTART WITH 10001;

INSERT INTO state_team.State (state_name) VALUES ('New York');
INSERT INTO state_team.State (state_name) VALUES ('TEXAS');
INSERT INTO state_team.State (state_name) VALUES ('Colorado');
INSERT INTO state_team.State (state_name) VALUES ('Florida');
INSERT INTO state_team.State (state_name) VALUES ('California');

SELECT * FROM state_team.State;




--DROP TABLE state_team.Team;

CREATE TABLE state_team.team (
    team_id BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 20001 INCREMENT BY 1) PRIMARY KEY,
    team_name VARCHAR(200) NOT NULL,
    state_id BIGINT NOT NULL REFERENCES state_team.state(state_id),
    sport_id BIGINT NOT NULL
);

INSERT INTO state_team.team (team_name, state_id, sport_id) VALUES
    ('Los Angeles Clippers', 10005, 40002),
    ('Denver Broncos', 10003, 40001),
    ('New York Knicks', 10001, 40002),
    ('Miami Dolphins', 10004, 40001),
    ('Denver Nuggets', 10003, 40002),
    ('Dallas Mavericks', 10002, 40002),
    ('Dallas Cowboys', 10002, 40001),
    ('San Francisco 49ers', 10005, 40001),
    ('Miami Heat', 10004, 40002),
    ('Buffalo Bills', 10001, 40001);

SELECT * FROM state_team.team;

CREATE TABLE state_team.player(
played_id BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 30001 INCREMENT BY 1) PRIMARY KEY,
team_id BIGINT NOT NULL,
player_name VARCHAR (200) NOT NULL,
player_salary BIGINT NOT NULL
);

INSERT INTO state_team.player (team_id, player_name, player_salary) VALUES
    (20006, 'Terry Lennie', 185000),
    (20002, 'Ellis Sidney', 101000),
    (20001, 'Alex Meredith', 236000),
    (20003, 'Parker Lindsay', 240000),
    (20008, 'Lindsey Darian', 241000),
    (20007, 'Kit Stacy', 220000),
    (20003, 'Sammie Hadley', 112000),
    (20005, 'Tracey Bailey', 128000),
    (20002, 'Addison Garnet', 105000),
    (20005, 'Esme Stace', 146000),
    (20009, 'Kennedy Meredith', 236000),
    (20004, 'Cortney Harper', 168000),
    (20002, 'Loren Addison', 189000),
    (20009, 'Jojo Noel', 233000),
    (20010, 'Syd Hilary', 132000),
    (20006, 'Jools Francis', 204000),
    (20001, 'Beverly Terry', 210000),
    (20007, 'Sidney Raven', 157000),
    (20006, 'Page Ricki', 247000),
    (20003, 'Palmer Beau', 104000),
    (20008, 'Hadley Lindsey', 133000),
    (20008, 'Yancy Cameron', 220000),
    (20010, 'Jo Jools', 140000),
    (20001, 'Raleigh Ricki', 170000),
    (20004, 'Tibby Ronnie', 138000),
    (20009, 'Jules Evelyn', 175000),
    (20007, 'Lesley Izzy', 179000),
    (20005, 'Eddie Peyton', 129000),
    (20010, 'Alpha Jocelyn', 215000),
    (20004, 'Parker Emery', 202000);


SELECT * FROM state_team.player;

-- DROP TABLE state_team.Sport;

CREATE TABLE state_team.Sport(
sport_id BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 40001 INCREMENT BY 1) PRIMARY KEY,
sport_name VARCHAR (200) NOT NULL
);

INSERT INTO state_team.Sport (sport_name) VALUES 
					('Foot Ball'),
					('Basket Ball');

ALTER TABLE state_team.team
ADD CONSTRAINT fk_team_sport
FOREIGN KEY (sport_id) REFERENCES state_team.Sport(sport_id);

SELECT * FROM state_team.sport;


--Exercise Four -- SQL statement that will find players who play football with a salary over 2000000.

SELECT player_name FROM state_team.player WHERE player_salary > 200000;

--Exercise Four -- SQL statement that will find players who play football with a salary over 2000000, along with salary amount.
SELECT player_name, player_salary FROM state_team.player WHERE player_salary > 200000;

-- Exercise Five -- SQL statement that will find which sport has the highest paid player.

SELECT s.sport_name, p.player_name, t.team_name, p.player_salary FROM state_team.player p
JOIN state_team.team t ON p.team_id = t.team_id
JOIN state_team.sport s ON t.sport_id = s.sport_id
ORDER BY p.player_salary DESC
LIMIT 1;

-- Exercise Six -- SQL statement that will find all players whose name starts with the letter 'j' followed immediately by the letter 'o'.

SELECT * FROM state_team.player WHERE player_name ILIKE 'jo%';
