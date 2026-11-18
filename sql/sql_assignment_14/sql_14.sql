SELECT sport_name FROM sport
WHERE sport_id = (
    SELECT sport_id FROM Team
    WHERE team_id = (
        SELECT team_id FROM Player
        ORDER BY "player Salary" DESC
        LIMIT 1
    )
);

-- i will also give this a go with a join

SELECT sport_name FROM sport
JOIN team ON sport.sport_id = team.sport_id
JOIN player ON team.team_id = player.team_id
ORDER BY "player Salary" DESC
LIMIT 1;

-- that was not bad