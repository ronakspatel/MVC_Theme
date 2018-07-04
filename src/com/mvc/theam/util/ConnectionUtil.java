package com.mvc.theam.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MVC_Theme","root","");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
