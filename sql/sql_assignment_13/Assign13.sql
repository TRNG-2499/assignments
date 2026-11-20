--Given the following tables, provide an SQL statement 
--that will find players who play football with a salary
 --over 200000.

 SELECT * 
 FROM Player
 WHERE (team_id = 20002 OR team_id = 20004 
 OR team_id = 20007 OR team_id = 20008
 OR team_id = 20010)
 AND "player Salary" > 200000;