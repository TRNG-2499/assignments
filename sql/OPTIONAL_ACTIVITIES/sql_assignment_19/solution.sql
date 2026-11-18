-- A view lets queries 1, 4, and 5 share the same margin calculation.
CREATE OR REPLACE VIEW product_margins AS
SELECT product_id, product_name, unit_cost, unit_price,
       unit_price - unit_cost AS unit_margin
FROM Product;

-- 1. Cost, price, and profit on one unit of each product.
SELECT product_name, unit_cost, unit_price, unit_margin
FROM product_margins;

-- 2. Current inventory value per category, measured at cost.
SELECT c.category_name,
       COALESCE(SUM(p.stock_quantity * p.unit_cost), 0) AS inventory_value
FROM Category c
LEFT JOIN Product p ON p.category_id = c.category_id
GROUP BY c.category_id, c.category_name;

-- 3. Potential revenue if all remaining stock sells.
SELECT product_name, stock_quantity * unit_price AS potential_revenue
FROM Product;

-- 4. Average per-unit profit margin across all products.
SELECT AVG(unit_margin) AS average_margin
FROM product_margins;

-- 5. Products earning more than that average per unit.
SELECT product_name, unit_margin
FROM product_margins
WHERE unit_margin > (SELECT AVG(unit_margin) FROM product_margins);

-- Queries 6 and 7 use the same sales totals.
CREATE OR REPLACE VIEW product_sales_totals AS
SELECT p.product_id, p.product_name,
       COALESCE(SUM(s.quantity_sold), 0) AS units_sold,
       COALESCE(SUM(s.quantity_sold), 0) * p.unit_price AS total_revenue,
       COALESCE(SUM(s.quantity_sold), 0) * p.unit_cost AS total_cost,
       COALESCE(SUM(s.quantity_sold), 0)
           * (p.unit_price - p.unit_cost) AS total_profit
FROM Product p
LEFT JOIN Sale s ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name, p.unit_price, p.unit_cost;

-- 6. Units sold, revenue, cost, and profit per product.
SELECT product_name, units_sold, total_revenue, total_cost, total_profit
FROM product_sales_totals;

-- 7. Three products that generated the most profit from sales.
SELECT product_name, total_profit
FROM product_sales_totals
ORDER BY total_profit DESC, product_id
LIMIT 3;

-- 8. Product with the longest name.
SELECT product_name
FROM Product
ORDER BY LENGTH(product_name) DESC, product_id
LIMIT 1;

-- 9. Product with the shortest name.
SELECT product_name
FROM Product
ORDER BY LENGTH(product_name), product_id
LIMIT 1;

-- 10. Product names containing a space.
SELECT product_name
FROM Product
WHERE product_name LIKE '% %';

-- 11. Categories starting with E.
SELECT category_name
FROM Category
WHERE category_name LIKE 'E%';

-- 12. Uppercase product names alongside lowercase category names.
SELECT UPPER(p.product_name) AS product_name,
       LOWER(c.category_name) AS category_name
FROM Product p
JOIN Category c ON c.category_id = p.category_id;