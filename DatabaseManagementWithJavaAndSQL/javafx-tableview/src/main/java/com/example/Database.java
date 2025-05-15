package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    
    @SuppressWarnings("exports")
    public static Connection getConnection() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/test_db";
        String USER = "test_user";
        String PASSWORD = "11111111";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
