SELECT Sport.sport_name FROM Sport -- Get the sport
JOIN Team on Sport.sport_id=Team.Sport_id -- Slap on the team table
JOIN Player on Team.team_id=Player.team_id -- Slap on the player table
WHERE Player.player_Salary = ( -- Subquery for max salary
    SELECT MAX(Player.player_Salary) FROM Player -- Basic max salary query
);