package com.dao;

import java.sql.*;

public class CountTables {
			
	public static int countingSubs(String dbname, String table) {
			Connection con;
			Statement st;
			ResultSet rs;
			int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+dbname, "root", "");
			st = con.createStatement();
			rs = st.executeQuery("select * from "+table);
			while(rs.next()) {
				i++;
			}
			rs.close();
			st.close();
			con.close();
			return i;
		}catch(Exception e) {
			System.out.println("An error occured in CountTables-2 because "+e.getMessage());
		}
		
		return i;
	}

}
