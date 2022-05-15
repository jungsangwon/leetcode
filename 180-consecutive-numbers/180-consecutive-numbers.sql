/* Write your PL/SQL query statement below */
select distinct a.num ConsecutiveNums
from (select num, LAG(num) OVER(ORDER BY id) AS num_prev,
LEAD(num) OVER(ORDER BY id) AS num_next
from LOGS) a
where a.num = a.num_prev
and a.num = a.num_next