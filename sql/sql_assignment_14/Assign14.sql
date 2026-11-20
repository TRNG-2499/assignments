/*
*Given the following tables, provide an SQL
 statement that will find which sport has the 
 highest paid player.
*/

SELECT s.sport_name, MAX("player Salary") AS highest_salary
FROM Player p
JOIN Team t
ON t.team_id = p.team_id
JOIN Sport s
ON s.sport_id = t.sport_id
GROUP BY s.sport_id, s.sport_name
ORDER BY highest_salary
DESC
LIMIT 1;
