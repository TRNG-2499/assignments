/*
DROP TABLE State CASCADE;
DROP TABLE Team CASCADE;
DROP TABLE Sport CASCADE;
DROP TABLE Player CASCADE;

CREATE TABLE State (
	state_id SERIAL PRIMARY KEY,
	state_name VARCHAR(20)
);

CREATE TABLE Sport (
	sport_id SERIAL PRIMARY KEY,
	sport_name VARCHAR(20)
);

CREATE TABLE Team (
	team_id SERIAL PRIMARY KEY,
	team_name VARCHAR(40),
	state_id SERIAL REFERENCES State(state_id),
	sport_id SERIAL REFERENCES Sport(sport_id)
);

CREATE TABLE Player (
	player_id SERIAL PRIMARY KEY,
	team_id SERIAL REFERENCES Team(team_id),
	player_name VARCHAR(100),
	player_salary INTEGER
);

INSERT INTO State (state_name) VALUES ('New York');
INSERT INTO State (state_name) VALUES ('Texas');
INSERT INTO State (state_name) VALUES ('Colorado');
INSERT INTO State (state_name) VALUES ('Florida');
INSERT INTO State (state_name) VALUES ('California');

INSERT INTO Sport (sport_name) VALUES ('Foot Ball');
INSERT INTO Sport (sport_name) VALUES ('Basket Ball');

INSERT INTO Team (team_name, state_id, sport_id) VALUES ('Los Angeles Clippers', 5, 2);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('Denver Broncos', 3, 1);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('New York Knicks', 1, 2);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('Miami Dolphins', 4, 1);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('Denver Nuggets', 3, 2);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('Dallas Mavericks', 2, 2);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('Dallas Cowboys', 2, 1);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('San Francisco 49ers', 5, 1);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('Miami Heat', 4, 2);
INSERT INTO Team (team_name, state_id, sport_id) VALUES ('Buffalo Bills', 1, 1);

INSERT INTO Player (team_id, player_name, player_salary) VALUES (6, 'Terry Lennie', 185000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (2, 'Ellis Sidney', 101000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (1, 'Alex Meredith', 236000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (3, 'Parker Lindsay', 240000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (8, 'Lindsey Darian', 241000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (7, 'Kit Stacy', 220000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (3, 'Sammie Hadley', 112000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (5, 'Tracey Bailey', 128000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (2, 'Addison Garnet', 105000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (5, 'Esme Stace', 146000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (9, 'Kennedy Meredith', 236000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (4, 'Cortney Harper', 168000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (2, 'Loren Addison', 189000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (9, 'Jojo Noel', 233000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (10, 'Syd Hilary', 132000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (6, 'Jools Francis', 204000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (1, 'Beverly Terry', 210000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (7, 'Sidney Raven', 157000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (6, 'Page Ricki', 247000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (3, 'Palmer Beau', 104000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (8, 'Hadley Lindsey', 133000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (8, 'Yancy Cameron', 220000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (10, 'Jo Jools', 140000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (1, 'Raleigh Ricki', 170000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (4, 'Tibby Ronnie', 138000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (9, 'Jules Evelyn', 175000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (7, 'Lesley Izzy', 179000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (5, 'Eddie Peyton', 129000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (10, 'Alpha Jocelyn', 215000);
INSERT INTO Player (team_id, player_name, player_salary) VALUES (4, 'Parker Emery', 202000);

SELECT * FROM State;
SELECT * FROM Team;
SELECT * FROM Player;
SELECT * FROM Sport;
*/

CREATE OR REPLACE VIEW football_teams AS
SELECT t.team_id FROM Team t, Sport s WHERE t.sport_id = s.sport_id AND s.sport_name = 'Foot Ball';

SELECT * FROM Player WHERE player_salary >= 200000 AND team_id IN (SELECT * FROM football_teams);