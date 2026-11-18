-- First query: the name starts with Jo.
SELECT player_name
FROM Player
WHERE LOWER(player_name) LIKE 'jo%';

-- Second query: an e appears somewhere after an a.
SELECT player_name
FROM Player
WHERE LOWER(player_name) LIKE '%a%e%';