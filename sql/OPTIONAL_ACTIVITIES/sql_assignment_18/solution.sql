-- 1. Total revenue per salesperson, highest first.
-- A salesperson with no sales still appears with zero revenue.


SELECT sp.salesperson_name,
       COALESCE(SUM(s.quantity * p.unit_price), 0) AS total_revenue
FROM Salesperson sp
LEFT JOIN Sale s ON s.salesperson_id = sp.salesperson_id
LEFT JOIN Product p ON p.product_id = s.product_id
GROUP BY sp.salesperson_id, sp.salesperson_name
ORDER BY total_revenue DESC, sp.salesperson_id;

-- 2. Product with the most units sold.


SELECT p.product_name, SUM(s.quantity) AS units_sold
FROM Product p
JOIN Sale s ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name
ORDER BY units_sold DESC, p.product_id
LIMIT 1;

-- 3. Total revenue, cost, and profit for each product.


SELECT p.product_name,
       COALESCE(SUM(s.quantity), 0) * p.unit_price AS total_revenue,
       COALESCE(SUM(s.quantity), 0) * p.unit_cost AS total_cost,
       COALESCE(SUM(s.quantity), 0) * (p.unit_price - p.unit_cost) AS total_profit
FROM Product p
LEFT JOIN Sale s ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name, p.unit_price, p.unit_cost
ORDER BY p.product_name;

-- 4. Product that earns the most profit on one unit.


SELECT product_name, unit_price - unit_cost AS unit_margin
FROM Product
ORDER BY unit_margin DESC, product_id
LIMIT 1;

-- Stretch 1. Rank salespeople within their own region by revenue.
-- RANK gives first place to everyone tied for the lead.


WITH salesperson_totals AS (
    SELECT sp.region_id, sp.salesperson_id, sp.salesperson_name,
           COALESCE(SUM(s.quantity * p.unit_price), 0) AS total_revenue
    FROM Salesperson sp
    LEFT JOIN Sale s ON s.salesperson_id = sp.salesperson_id
    LEFT JOIN Product p ON p.product_id = s.product_id
    GROUP BY sp.region_id, sp.salesperson_id, sp.salesperson_name
),
ranked_salespeople AS (
    SELECT salesperson_totals.*,
           RANK() OVER (
               PARTITION BY region_id ORDER BY total_revenue DESC
           ) AS place
    FROM salesperson_totals
)
SELECT r.region_name, rs.salesperson_name, rs.total_revenue
FROM ranked_salespeople rs
JOIN Region r ON r.region_id = rs.region_id
WHERE rs.place = 1
ORDER BY r.region_name, rs.salesperson_name;

-- Stretch 2. Find the product with the most units sold in each region.


WITH product_totals AS (
    SELECT sp.region_id, s.product_id, SUM(s.quantity) AS units_sold
    FROM Sale s
    JOIN Salesperson sp ON sp.salesperson_id = s.salesperson_id
    GROUP BY sp.region_id, s.product_id
),
ranked_products AS (
    SELECT product_totals.*,
           RANK() OVER (
               PARTITION BY region_id ORDER BY units_sold DESC
           ) AS place
    FROM product_totals
)
SELECT r.region_name, p.product_name, rp.units_sold
FROM ranked_products rp
JOIN Region r ON r.region_id = rp.region_id
JOIN Product p ON p.product_id = rp.product_id
WHERE rp.place = 1
ORDER BY r.region_name, p.product_name;