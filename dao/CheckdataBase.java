package com.dao;

import java.sql.*;

public class CheckdataBase {
	
	public static boolean checkDB(String examname) {
		Connection con;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
			rs = con.getMetaData().getCatalogs();
//			int i = 0;
			while(rs.next()) {
				if(rs.getString(1).equals(examname)) {
					return true;
				}
//				i++;
//				System.out.println(i+" "+rs.getString(1));
			}
			rs.close();
			con.close();
		}catch(Exception e) {
			System.out.println("An error occured because "+e.getMessage());
		}
		return false;
	}

}
