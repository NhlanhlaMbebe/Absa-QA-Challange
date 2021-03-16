How many orders were made each calendar year (since the beginning of 1996) in this database?
SELECT * FROM orders where TO_CHAR(order_date, 'YYYY') > '1996'