package com.dao;

import java.sql.*;

public class CreateTable {
	
	public static void ctb(String dbname, String tablename) {
		Connection con;
		Statement st;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+dbname, "root", "");
			st = con.createStatement();
			st.executeUpdate("CREATE TABLE "+tablename+"(id int not NULL AUTO_INCREMENT, question varchar(255) not NULL, opt1 varchar(255) not NULL, opt2 varchar(255) not NULL, opt3 varchar(255) not NULL, opt4 varchar(255) not NULL, answer varchar(255) not NULL, PRIMARY KEY(id))");
			
			st.close();
			con.close();
		}catch(Exception e) {
			System.out.println("An error occured because of "+e.getCause());
		}
	}

}
