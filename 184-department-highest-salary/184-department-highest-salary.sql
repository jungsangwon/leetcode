/* Write your PL/SQL query statement below */
select d.name as Department, e.name as Employee, e.salary
from Employee e
inner join Department d
on e.departmentId = d.id
inner join
(
    select departmentId, Max(salary) maxSalary
    from Employee e
    group by departmentId
) t
on t.departmentId = d.id
and e.salary = t.maxSalary
;
