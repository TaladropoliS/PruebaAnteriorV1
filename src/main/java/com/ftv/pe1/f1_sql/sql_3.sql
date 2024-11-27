-- 3 Mostrar las facturas pendientes de pago, incluyendo datos del cliente y el
--   total adeudado.

USE distribusoftdb;

SELECT f.numero_factura, f.fecha_emision, c.nombre AS cliente, c.email, f.monto_total
FROM factura f
         JOIN orden_venta o ON f.orden_id = o.id
         JOIN cliente c ON o.cliente_id = c.id
WHERE f.pagado = false;