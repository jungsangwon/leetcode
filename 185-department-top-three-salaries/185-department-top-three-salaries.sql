/* Write your PL/SQL query statement below */
select d.name as Department, e.name as Employee, e.salary
from Employee e
inner join Department d
on e.departmentId = d.id
inner join
(
    select departmentId, id, dense_rank() over(partition by departmentId order by salary desc) rank
    from Employee
) t
on t.departmentId = d.id
and e.id = t.id
and rank <=3

