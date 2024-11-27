-- 2 Listar los productos con stock crítico (menor a 30 unidades) junto con su
--   proveedor y categoría.

USE distribusoftdb;

SELECT p.nombre AS producto, p.stock, pr.nombre AS proveedor, pr.telefono AS telefono, cp.nombre AS categoria
FROM producto p
         JOIN proveedor pr ON p.proveedor_id = pr.id
         JOIN categoria_producto cp ON p.categoria_id = cp.id
WHERE p.stock < 30;