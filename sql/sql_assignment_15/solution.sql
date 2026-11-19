SELECT player_id, player_name
FROM Player
WHERE player_name LIKE 'Jo%';

SELECT player_id, player_name
FROM Player
WHERE LOWER(player_name) LIKE '%a%e%';