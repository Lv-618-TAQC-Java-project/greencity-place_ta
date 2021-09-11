package com.ita.edu.greencity.tools.jdbc;

import com.ita.edu.greencity.tools.PropertiesProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConnection {

    Connection connection = null;


    public void connectionToDataBase() {
        PropertiesProvider prop = new PropertiesProvider();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }
        System.out.println("PostgreSQL JDBC Driver successfully connected");
        try {
            connection = DriverManager
                    .getConnection(prop.getDataBaseURL(), prop.getDataBaseUserName(), prop.getDataBasePassword());

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

    }

    public void SelectStatement(String executeQuery) {
        connectionToDataBase();
        List<String> expectedResult1 = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet expected = statement.executeQuery(executeQuery);
            while (expected.next()) {
                String number = expected.getString(1);
                expectedResult1.add(number);
            }
            System.out.println("result from database in ascending order");
            System.out.println(expectedResult1.get(0));
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void DeleteOrdersFromTable(String executeQuery) {
        connectionToDataBase();
        List<String> expectedResult1 = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet expected = statement.executeQuery(executeQuery);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}