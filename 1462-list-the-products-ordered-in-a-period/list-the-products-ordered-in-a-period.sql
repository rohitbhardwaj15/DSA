SELECT 
    p.product_name,
    SUM(o.unit) AS unit
FROM Products p
JOIN (
    SELECT product_id, unit
    FROM Orders
    WHERE order_date >= '2020-02-01'
      AND order_date < '2020-03-01'
) o
ON p.product_id = o.product_id
GROUP BY p.product_id, p.product_name
HAVING SUM(o.unit) >= 100;
