/* Write your PL/SQL query statement below */
select a.name as Employee
from Employee a, Employee b
where a.managerId = b.id
and a.salary > b.salary
;