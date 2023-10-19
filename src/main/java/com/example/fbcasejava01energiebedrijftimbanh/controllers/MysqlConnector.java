package com.example.fbcasejava01energiebedrijftimbanh.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {
    private Connection connection;

    public MysqlConnector() {
        String user = "root";
        String pass = "root";
        String cString = "jdbc:mysql://localhost:3306/?user=" + user + "&password="+ pass;

        try {
            this.connection = DriverManager.getConnection(cString);
        } catch (SQLException e) {
            System.out.println("Kan geen verbinding maken");
        }
    }
}
