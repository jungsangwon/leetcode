/* Write your PL/SQL query statement below */
select email
from person
group by email
having count(*) >1