--What is the average number of reports per employee in this database and how many of the employees have reports higher than this average?
SELECT avg(reports_to) FROM Employees


SELECT COUNT(*) FROM Employees 
WHERE reports_to >= ( SELECT MAX(reports_to) 
                     FROM Employees )



SELECT * FROM customers c
JOIN orders d ON d.customer_id=c.customer_id
WHERE customer_name = (SELECT 