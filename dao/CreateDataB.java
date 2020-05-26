package com.dao;

import java.sql.*;

public class CreateDataB {
	
	public static void cbase(String name) {

		Connection con;
		Statement pst;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
			pst = con.createStatement();
			pst.executeUpdate("CREATE DATABASE "+name);
			
			con.close();
			pst.close();
		}catch(Exception e){
			System.out.println("Error occured here because "+e.getCause());
		}
	}
	

}
