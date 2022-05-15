/* Write your PL/SQL query statement below */
select c.name as Customers
from Customers c
where c.id not in (
    select o.customerId
    from orders o
)
order by c.id