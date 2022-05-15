CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT distinct Salary
        FROM(
            SELECT Salary,
              DENSE_RANK()OVER(ORDER BY Salary DESC) as Rn
            FROM Employee
        )S
        WHERE Rn = N
  );
END