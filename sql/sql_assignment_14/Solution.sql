SELECT MAX("player Salary")
FROM Player;


SELECT p.player_name, p."player Salary", s.sport_name
FROM Player AS p
JOIN Team AS t ON p.team_id = t.team_id
JOIN Sport AS s ON t.sport_id = s.sport_id
WHERE p."player Salary" = (SELECT MAX("player Salary") FROM Player)