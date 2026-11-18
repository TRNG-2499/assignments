SELECT player_name FROM Player WHERE team_id IN 
(SELECT t.team_id FROM Team as t JOIN Sport as s ON t.sport_id = s.sport_id WHERE s.sport_name = 'Foot Ball')
AND player_salary > 200000;