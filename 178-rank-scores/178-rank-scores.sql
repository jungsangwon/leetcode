/* Write your PL/SQL query statement below */
SELECT t.score, 
dense_rank() over(ORDER BY t.score DESC) as rank
FROM Scores t
;