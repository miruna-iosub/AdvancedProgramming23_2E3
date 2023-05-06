package org.homework;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;


public class Database {

    private static BasicDataSource dataSource;
    private static Connection connection;

    public Database() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/javadb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("0608");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(25);
    }

    public static Connection getConnection() throws SQLException{
        return connection;
    }

    public static void createConnection() {
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        getConnection().close();
    }
}