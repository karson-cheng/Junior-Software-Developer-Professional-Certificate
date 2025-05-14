package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
    private final String url = "jdbc:mysql://localhost:3306/test_db";
    private final String user = "root";
    private final String password = "";

    @SuppressWarnings("exports")
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public String getAllUsers() throws SQLException{
        String userData = "";
        String query = "SELECT * FROM user";
        Connection clickbuyConnection = getConnection();
        Statement queryStatement = clickbuyConnection.createStatement();
        ResultSet userResultSet = queryStatement.executeQuery(query);

        while(userResultSet.next()){
            // userData += userResultSet.getString("userid") + ": " +
            //             userResultSet.getString("FirstName") + " " + 
            //             userResultSet.getString("LastName") + " PW: " +
            //             userResultSet.getString("Password") + "\n";
            userData += String.format("ID: %s\t\tName: %s %s\t\tPW: %s\n", 
                                        userResultSet.getString("userid"), 
                                        userResultSet.getString("FirstName"), 
                                        userResultSet.getString("LastName"),
                                        userResultSet.getString("Password"));
        }
        return userData;        
    }
}
