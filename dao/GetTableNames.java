package com.dao;

import java.sql.*;
import java.util.ArrayList;

public class GetTableNames {
	
	//Function for getting table names and setting them to an arraylist
	public static ArrayList<String> theName(String dbname) {
		ArrayList<String> names = new ArrayList<String>();
		
		Connection con;
		ResultSet rs;
		Statement st;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+dbname, "root", "");
			st = con.createStatement();
			rs = st.executeQuery("SHOW TABLES");
			
			while(rs.next()) {
				names.add(rs.getString(1));
			}
			st.close();
			rs.close();
			con.close();
		}catch(Exception e) {
			System.out.println("An error occured because of "+e.getMessage());
		}
		
		return names;
	}

}
