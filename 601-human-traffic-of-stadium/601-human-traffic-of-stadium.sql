/* Write your PL/SQL query statement below */
SELECT ID, VISIT_DATE, PEOPLE
FROM (
        SELECT
                ID, TO_CHAR(VISIT_DATE, 'YYYY-MM-DD') AS VISIT_DATE , PEOPLE,
                CASE 
                    WHEN PEOPLE>=100 AND LEAD(PEOPLE) OVER (ORDER BY ID) >= 100 AND LEAD(PEOPLE,2) OVER (ORDER BY ID) >= 100 THEN 1
                    WHEN PEOPLE>=100 AND LEAD(PEOPLE) OVER (ORDER BY ID) >= 100 AND LAG(PEOPLE) OVER (ORDER BY ID) >= 100 THEN 1
                    WHEN PEOPLE>=100 AND LAG(PEOPLE) OVER (ORDER BY ID) >= 100 AND LAG(PEOPLE,2) OVER (ORDER BY ID) >= 100 THEN 1
                    ELSE 0 END AS CHECK_CONDITION
        FROM
                STADIUM
)
WHERE CHECK_CONDITION = 1