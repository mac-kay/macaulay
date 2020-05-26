package com.dao;

import java.sql.*;

public class GetIds {
	
	public static String questnum(String tablename, String dbname) {
		
		Connection con;
		Statement st;
		ResultSet rs;
		
		String rnum = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+dbname, "root", "");
			st = con.createStatement();
			rs = st.executeQuery("select id from "+tablename);
			
			while(rs.next()) {
				rnum = rs.getString(1);
			}
			rs.close();
			st.close();
			con.close();
		}catch(Exception e) {
			System.out.println("An error occured in GetIds because "+e.getMessage());
		}
		if(rnum=="") {
			return "1";
		}
		int myNumber = Integer.parseInt(rnum)+1;
		return myNumber+"";
	}

}
