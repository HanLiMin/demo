package com.moontwon.demo.jdbc;

import java.sql.*;

public class DriverDemo {
    public static void main(String[] args) throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.16:3306/demo?serverTimezone=UTC", "root", "123456");
        System.err.println(connection);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        System.err.println(resultSet);
        while (resultSet.next()) {
            System.err.println(resultSet.getRowId(1)+" = = "+ resultSet.getInt(1) + " === " + resultSet.getString(2));
        }

        connection.close();
    }

}
