/* Write your T-SQL query statement below */
SELECT a.FirstName
       , a.LastName
       , b.City
       , b.State
FROM
Person a WITH(NOLOCK)
LEFT JOIN
Address b WITH(NOLOCK)
ON a.PersonId = b.PersonId
