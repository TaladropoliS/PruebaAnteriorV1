package com.ftv.pe1.f2_escritorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection c;
    private static String url = "jdbc:mysql://localhost:3306/distribusoftdb?serverTimezone=America/Santiago";

    private static String user = "root";
    private static String password = "root";

    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if (c == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, user, password);
        }
        return c;
    }
}