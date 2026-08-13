package com.railway.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/railway";

    private static final String USER = "postgres";

    private static final String PASSWORD = "hari@123";

    public static Connection getConnection() {

        try {

            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}