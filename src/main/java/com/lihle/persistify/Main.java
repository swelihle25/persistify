package com.lihle.persistify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/persistdb";
        String username = "postgres";
        String password = "password";

        try{
            System.out.println("Connecting to database...");

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to database!");

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}