/* Write your PL/SQL query statement below */
select id, case when mod(id,2)=1 then nvl(lead(student) over(order by id),student) else lag(student) over(order by id) end student
from seat
order by id;