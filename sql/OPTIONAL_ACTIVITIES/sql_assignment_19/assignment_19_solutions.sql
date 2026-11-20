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
CREATE OR REPLACE VIEW product_sale_stats AS
SELECT p.product_name,
  SUM(s.quantity_sold) quantity_sold,
  SUM(s.quantity_sold * p.unit_price) total_revenue,
  SUM(s.quantity_sold * p.unit_cost) total_cost,
  SUM(
    (s.quantity_sold * p.unit_price) - (s.quantity_sold * p.unit_cost)
  ) total_profit
FROM Product p
JOIN Sale s ON p.product_id = s.product_id
GROUP BY p.product_name;

-- QUERY 7
SELECT p.product_name, p.total_profit
FROM product_sale_stats p
ORDER BY p.total_profit DESC
LIMIT 1;

-- QUERY 8
SELECT p.product_name longest_product_name
FROM Product p
ORDER BY LENGTH(p.product_name) DESC
LIMIT 1;

-- QUERY 9
SELECT p.product_name shortest_product_name
FROM Product p
ORDER BY LENGTH(p.product_name) ASC
LIMIT 1;

-- QUERY 10
SELECT p.product_name multi_word_products
FROM Product p
WHERE p.product_name LIKE ('% %');

-- QUERY 11
SELECT c.category_name
FROM Category c
WHERE c.category_name LIKE ('E%');

-- QUERY 12
SELECT UPPER(p.product_name), LOWER(c.category_name)
FROM Product p
  JOIN Category c ON p.category_id = c.category_id;
