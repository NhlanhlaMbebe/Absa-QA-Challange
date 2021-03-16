5. How many orders did customer “Simons bistro” have shipped via shipper “United Package”?

SELECT COUNT(*) AS "NUMBER OF ORDERS" FROM Customers
JOIN orders ON orders.customer_id=Customers.customer_id
JOIN shippers ON shippers.shipper_id=orders.ship_via
WHERE Customers.company_name= 'Simons bistro'
AND shippers.company_name = 'United Package'