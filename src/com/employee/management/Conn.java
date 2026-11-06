package com.employee.management;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	
	Connection c;
	Statement s;
	public Conn() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
			String username = System.getenv("DB_USER");
			String password = System.getenv("DB_PASSWORD");
			c=DriverManager.getConnection(url,username,password);
			s= c.createStatement();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}



}
