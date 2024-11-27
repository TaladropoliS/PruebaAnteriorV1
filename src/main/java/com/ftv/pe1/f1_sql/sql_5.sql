-- 5 Mostrar el resumen de pagos por método de pago del último mes,
--   incluyendo el número de transacciones y el monto total por cada método.
--   agregar columna con el promedio del monto por metodo de pago

USE distribusoftdb;

SELECT p.metodo_pago AS metodo_pago
        , COUNT(p.id) AS transacciones
        , SUM(f.monto_total) AS monto_total
        , SUM(f.monto_total) / COUNT(p.id) AS promedio_monto
FROM factura f
         JOIN pago p ON f.id = p.factura_id
WHERE f.fecha_emision >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
GROUP BY p.metodo_pago;


