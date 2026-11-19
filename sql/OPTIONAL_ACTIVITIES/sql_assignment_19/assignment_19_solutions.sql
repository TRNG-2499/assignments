-- QUERY 1
SELECT p.product_name, 
  p.unit_cost, 
  p.unit_price, 
  (p.unit_price - p.unit_cost) profit_margin
FROM Product p

-- QUERY 2
SELECT c.category_name, SUM(p.unit_cost * s.quantity_sold) total_value
FROM Product p
JOIN Sale s ON p.product_id = s.product_id
JOIN Category c ON p.category_id = c.category_id
GROUP BY c.category_name;

-- QUERY 3
SELECT p.product_name, SUM(p.unit_price * p.stock_quantity) potential_revenue
FROM Product p
GROUP BY p.product_name;

-- QUERY 4
CREATE OR REPLACE VIEW avg_profit_margin AS
SELECT AVG(p.unit_price - p.unit_cost) avg_profit_margin
FROM Product p

-- QUERY 5
SELECT p.product_name, (p.unit_price - p.unit_cost) p_margin
FROM Product p
WHERE (p.unit_price - p.unit_cost) > 
  (SELECT avg_profit_margin FROM avg_profit_margin)

-- QUERY 6
