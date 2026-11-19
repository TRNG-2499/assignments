-- Query 1
SELECT sp.salesperson_name, SUM(p.unit_price * s.quantity) total_revenue
FROM Salesperson sp
	LEFT JOIN Sale s ON sp.salesperson_id = s.salesperson_id
	LEFT JOIN Product p ON s.product_id = p.product_id
GROUP BY sp.salesperson_name;

-- Query 2
SELECT p.product_name top_product, SUM(s.quantity) quant
FROM Product p
	JOIN Sale s ON p.product_id = s.product_id
GROUP BY p.product_name
ORDER BY SUM(s.quantity) DESC
LIMIT 1;

-- Query 3
SELECT p.product_name, 
	SUM(p.unit_price * s.quantity) total_revenue, 
	SUM(p.unit_cost * s.quantity) total_cost, 
	SUM((p.unit_price * s.quantity) - (p.unit_cost * s.quantity)) total_profit
FROM Product p
	JOIN Sale s ON p.product_id = s.product_id
GROUP BY p.product_name;

-- Query 4
SELECT p.product_name, (unit_price - unit_cost) margin
FROM Product p
GROUP BY p.product_name, unit_price, unit_cost
ORDER BY (unit_price - unit_cost) DESC
LIMIT 1;