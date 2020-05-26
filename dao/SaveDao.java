package com.dao;

import java.sql.*;

public class SaveDao {
	
	public static void saveQuest(String dbname, String subj, String question, String opt1, String opt2, String opt3, String opt4, String answer) {
		
		Connection con;
		PreparedStatement pst;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+dbname, "root", "");
			pst = con.prepareStatement("insert into "+subj+"(question, opt1, opt2, opt3, opt4, answer) values(?,?,?,?,?,?)");
			pst.setString(1, question);
			pst.setString(2, opt1);
			pst.setString(3, opt2);
			pst.setString(4, opt3);
			pst.setString(5, opt4);
			pst.setString(6, answer);
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
		}catch(Exception e) {
			System.out.println("An error occured here because "+e.getMessage());
		}
		
	}

}
