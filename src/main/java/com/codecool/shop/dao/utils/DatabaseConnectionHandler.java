package com.codecool.shop.dao.utils;

import java.sql.*;

public class DatabaseConnectionHandler {

    private static final String DB_PATH = System.getenv("PSQL_PATH");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    private Connection connection;

    private static DatabaseConnectionHandler instance;

    private DatabaseConnectionHandler() {
        try {
            connection = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Could not establish database connection.");
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() {
        if (instance == null) {
            instance = new DatabaseConnectionHandler();
        }
        return instance.connection;
    }
}
