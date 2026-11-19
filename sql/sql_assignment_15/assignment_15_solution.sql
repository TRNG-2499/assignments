-- First Version
SELECT *
FROM Player
WHERE LOWER(Player.player_name)
LIKE 'jo%';

-- Second Version
SELECT *
FROM Player
WHERE LOWER(Player.player_name)
LIKE '%e%a%';