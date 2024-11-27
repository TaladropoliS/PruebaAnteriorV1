package com.ftv.pe1.f2_escritorio;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("----------------------- DistribuSoft -----------------------|");
        System.out.println("|                                                           |");
        System.out.println("| 1. Checkear Stock por ID                                  |");
        System.out.println("| 2. Ventas por Cliente                                     |");
        System.out.println("| 3. Salir                                                  |");
        System.out.println("| Ingrese opción:                                           |");
        int op = leer.nextInt();
        leer.nextLine();

        while (true) {
            switch (op) {
                case 1:
                    System.out.println("---------------- Checkear Stock -----------------------------");
                    System.out.println("Ingresar Id del Producto\n o CERO (0) para volver al menú principal");
                    int opId = leer.nextInt();
                    leer.nextLine();
                    if (opId != 0) {
                        buscarProductoPorId(opId);
                        break;
                    }
                    op = 100;
                    break;
                case 2:
                    System.out.println("----------------- Ventas por Cliente ----------------------------");
                    System.out.println("Ingresar Id del Cliente\n o CERO (0) para volver al menú principal\"");
                    int idCliente = leer.nextInt();
                    leer.nextLine();
                    if (idCliente != 0) {
                        System.out.println("Ingresar Mes (1, 2, 3, ..., 12)");
                        int mes = leer.nextInt();
                        leer.nextLine();
                        System.out.println("Ingresar Año (YYYY)");
                        int year = leer.nextInt();
                        leer.nextLine();

                        buscarVentasPorIdClienteMesYear(idCliente, mes, year);

                        break;
                    }
                    op = 100;
                    break;
                case 3:
                    System.out.println("\n\n\n\n\n\n\n\n\n");
                    System.out.println("|----------------------- DistribuSoft -----------------------|");
                    System.out.println("|                                                            |");
                    System.out.println("|                                                            |");
                    System.out.println("|                                                            |");
                    System.out.println("|                                                            |");
                    System.out.println("|                  --- PROGRAMA TERMINADO ---                |");
                    System.out.println("|                     --- VUELVA PRONTO ---                  |");
                    System.out.println("|                                                            |");
                    System.out.println("|                                                            |");
                    System.out.println("|                                                            |");
                    System.out.println("|                                                            |");
                    System.out.println("|------------------------------------------------------------|");
                    return;

                default:
                    System.out.println("Opcion no valida, por favor ingresela nuevamente\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("----------------------- DistribuSoft -----------------------|");
                    System.out.println("|                                                           |");
                    System.out.println("| 1. Checkear Stock por ID                                  |");
                    System.out.println("| 2. Ventas por Cliente                                     |");
                    System.out.println("| 3. Salir                                                  |");
                    System.out.println("| Ingrese opción:                                           |");
                    op = leer.nextInt();
                    leer.nextLine();
            }
        }
    }

    private static Connection conectar() throws SQLException, ClassNotFoundException {
        return ConexionDB.getInstance();
    }

    public static void buscarProductoPorId(int id) {

        String sql = "SELECT p.*, c.nombre AS categoria_nombre " +
                "FROM producto p " +
                "JOIN categoria_producto c ON p.categoria_id = c.id " +
                "WHERE p.id = " + id + ";";

        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precioUnitario = rs.getDouble("precio_unitario");
                int stock = rs.getInt("stock");
                String categoriaNombre = rs.getString("categoria_nombre");

                System.out.println("|---------------------------------------------");
                System.out.println("| ID: " + id);
                System.out.println("| Nombre: " + nombre);
                System.out.println("| Descripción: " + descripcion);
                System.out.println("| Precio Unitario: $" + precioUnitario);
                System.out.println("| Stock: " + stock);
                System.out.println("| Categoría: " + categoriaNombre);
                System.out.println("|---------------------------------------------");


                int umbral = "Electrónicos".equalsIgnoreCase(categoriaNombre) ? 20 : 10;
                if (stock < umbral) {
                    System.out.println("\n| !!! Stock '" + nombre + "', cat.: '" + categoriaNombre + "', es bajo!.");
                    System.out.println("| ¡Reposición recomendada!");
                    System.out.println("| ---------------------------------------------");
                }
            } else {
                System.out.println("| No se encontró el producto con el ID proporcionado.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("| Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static void buscarVentasPorIdClienteMesYear(int idCliente, int mes, int year) {
        String sql = "SELECT c.nombre AS cliente_nombre, SUM(v.total) AS total_ventas " +
                "FROM orden_venta v " +
                "JOIN cliente c ON v.cliente_id = c.id " +
                "WHERE c.id = " + idCliente + " AND MONTH(v.fecha) = " + mes + " AND YEAR(v.fecha) = " + year + " " +
                "GROUP BY c.id, c.nombre";

        try (Statement st = conectar().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                String clienteNombre = rs.getString("cliente_nombre");
                double total = rs.getDouble("total_ventas");

                System.out.println("|---------------------------------------------");
                System.out.println("|");
                System.out.println("| Cliente: " + clienteNombre);
                System.out.println("| Total Ventas "+ mes +"/"+ year +": $" + total);
                System.out.println("|");
                System.out.println("| ---------------------------------------------");
            } else {
                System.out.println("| No se encontraron ventas para el cliente con el ID proporcionado en el mes y año indicados.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("| Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
