

SELECT
    player_id,
    player_name,
    team_id,
    "player Salary" AS salary
FROM Player
WHERE player_name ILIKE 'jo%';
