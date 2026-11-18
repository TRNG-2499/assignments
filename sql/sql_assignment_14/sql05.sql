SELECT *
FROM sport
WHERE sport_id IN (
    SELECT sport_id
    FROM team 
    WHERE team_id IN (
        SELECT team_id
        FROM player
        GROUP BY team_id
        ORDER BY MAX(salary) DESC
        LIMIT 1
    )
)