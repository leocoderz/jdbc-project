package crudapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbc {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Connection con =null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:8888/jdbc","root","123456789");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(con!=null) {
			System.out.println("Success");
		}
		else {
			System.out.println("Not yet Connected!!");
		}
		Scanner sc = new Scanner(System.in);
		String name=sc.nextLine();
		String password=sc.nextLine();
		String sql="insert into login value(?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,password);
			ps.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("****Values are added Sucessfullly****");
		
		String viewSql="Select * from login";
		
		
		
		
		
		
		
		try {
			PreparedStatement view=con.prepareStatement(viewSql);
			ResultSet rs = view.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
