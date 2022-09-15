/* Write your PL/SQL query statement below */
select t.id, case when t.p_id is null then 'Root' when a.cnt is null then 'Leaf' else 'Inner' end type
from Tree t
,(
select p_id, count(*) as cnt
from Tree
group by p_id
) a
where t.id = a.p_id(+)
;