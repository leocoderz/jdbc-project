package crudapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcApp {
	public static void main(String[] args) {
		
		// Step 1: Load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// Step 2: Establish Connection
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:8888/CrudApp","root","123456789");
		}catch(SQLException e) {

			e.printStackTrace();

		}

		if(con!=null) {

			System.out.println("Connection Established");

		}

		else {

			System.out.println("Check the Connection");

		}
}}