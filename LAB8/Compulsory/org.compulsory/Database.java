package org.compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        return Database.connection;
    }

    public static void createConnection() {
        try {
            Database.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Database.connection.setAutoCommit(false);
            System.out.println("Connected to PostgreSQL server.");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        if (Database.connection != null) {
            Database.connection.close();
        }
    }
}