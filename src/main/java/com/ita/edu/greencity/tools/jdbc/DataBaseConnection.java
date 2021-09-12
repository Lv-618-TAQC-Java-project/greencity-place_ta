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

    public Connection getConnection(){
        return connection;
    }
    public void closeConnection()  {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<String> getListFromTable(String executeQuery) {

        List<String> expectedResult = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet expected = statement.executeQuery(executeQuery);
            while (expected.next()) {
                String number = expected.getString(1);
                expectedResult.add(number);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return expectedResult;
    }
    public String getElementFromTable(String executeQuery) {

        List<String> expectedResult = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet expected = statement.executeQuery(executeQuery);
            while (expected.next()) {
                String number = expected.getString(1);
                expectedResult.add(number);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return expectedResult.get(0);
    }

    public void DeleteOrdersFromTable(String executeQuery) {

        try {
            Statement statement = getConnection().createStatement();
            ResultSet expected = statement.executeQuery(executeQuery);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String [] findOrderId(String firstName, String last_name, String phone_number, String gmail){
        try {
            Statement statement = getConnection().createStatement();
            String executeSearchId = "select id from ubs_user where first_name = '"
                    + firstName + "' and last_name ='"
                    + last_name + "' and phone_number = '"
                    + phone_number + "' limit 1;";

            ResultSet expected = statement.executeQuery(executeSearchId);
            List<String> expectedResultId = new ArrayList<>();
            while (expected.next()) {
                String number = expected.getString(1);
                expectedResultId.add(number);
            }

            String executeSearchOrderID = "select id from orders where ubs_user_id = '"+expectedResultId.get(0)+"';";
            ResultSet expectedOrderID = statement.executeQuery(executeSearchOrderID);
            List<String> expectedResultOrderID = new ArrayList<>();
            while (expectedOrderID.next()) {
                String number = expectedOrderID.getString(1);
                expectedResultOrderID.add(number);
            }

            return new String[]{expectedResultId.get(0),expectedResultOrderID.get(0) };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public void DeleteOrderFromAllTable(String [] id){
        String ubs_user_id = id[0];
        String order_id = id[1];
        String order_bag_mapping = "DELETE FROM order_bag_mapping WHERE order_id ='"+order_id+"';";
        String order_additional = "delete from order_additional  where orders_id ='"+order_id+"';";
        String certificate = "delete from certificate where order_id ='"+order_id+"';";
        String order_employee = "delete from order_employee where order_id ='"+order_id+"';";
        String payment = "delete from payment where order_id ='"+order_id+"';";
        String MainDeleteOrders = "delete from orders where id ='"+order_id+"';";
        String ubs_user = "delete from ubs_user where id = '"+ubs_user_id+"';";


        DeleteOrdersFromTable(order_bag_mapping);
        DeleteOrdersFromTable(order_additional);
        DeleteOrdersFromTable(certificate);
        DeleteOrdersFromTable(order_employee);
        DeleteOrdersFromTable(payment);
        DeleteOrdersFromTable(MainDeleteOrders);
        DeleteOrdersFromTable(ubs_user);
    }



}