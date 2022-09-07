/* Write your PL/SQL query statement below */
select customer_number
  from (select customer_number
          from orders
         group by customer_number
         order by count(customer_number) desc)
 where rownum = 1