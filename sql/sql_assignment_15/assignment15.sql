SELECT player_name
FROM Player 
WHERE player_name ILIKE 'jo%'

-- altered
SELECT player_name
FROM Player
WHERE player_name ILIKE '%a%e%'