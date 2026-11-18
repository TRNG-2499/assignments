SELECT sport_name FROM Sport WHERE sport_id = (
    SELECT sport_id FROM Team WHERE team_id = (
        SELECT team_id FROM (
            SELECT MAX(player_salary) FROM Player
        )
    )
);

--SELECT sport_name FROM Team
--JOIN Player ON Team.team_id = Player.team_id
--JOIN Sport ON Team.sport_id = Sport.sport_id
--ORDER BY player_salary DESC LIMIT 1;