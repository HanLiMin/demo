package com.moontwon.demo.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DriverDemo {
	public static void main(String[] args) throws SQLException {
		Driver driver = new com.mysql.cj.jdbc.Driver();
		Properties properties = new Properties();
		properties.setProperty("user","mysql");
		properties.setProperty("passwrod","mysql");
//		Connection connection=driver.connect("jdbc:mysql://192.168.1.124:3306/quotes?serverTimezone=UTC", properties);
		Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.1.124:3306/quotes?serverTimezone=UTC", "mysql","mysql");
		System.err.println(connection);
		connection.close();
	}

}
