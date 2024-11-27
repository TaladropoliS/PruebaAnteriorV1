-- 1 Obtener el total de ventas por cliente en el último mes, mostrando solo
--   aquellos que han comprado más de $1000 en total, ordenados por monto de
--   mayor a menor.

USE distribusoftdb;

SELECT c.nombre AS cliente, c.activo, SUM(d.subtotal) AS total_ventas
FROM cliente c
         JOIN orden_venta o ON c.id = o.cliente_id
         JOIN detalle_orden d ON o.id = d.orden_id
WHERE o.fecha >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
GROUP BY c.id
HAVING total_ventas > 1000
ORDER BY total_ventas DESC;