--Finding players whose name starts with 'jo'
SELECT player_name FROM Player WHERE player_name LIKE 'Jo%';

--Finding players whose name has a 'e' sometime after 'a'
SELECT player_name FROM Player WHERE player_name LIKE '%a%e%';