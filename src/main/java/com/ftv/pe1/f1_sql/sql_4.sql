-- 4 Obtener los 5 productos más vendidos, mostrando la cantidad total
--   vendida y el monto total generado

USE distribusoftdb;

SELECT p.nombre AS producto, SUM(d.cantidad) AS cantidad_vendida, SUM(d.subtotal) AS monto_total
FROM producto p
         JOIN detalle_orden d ON p.id = d.producto_id
GROUP BY p.id
ORDER BY cantidad_vendida DESC
LIMIT 5;