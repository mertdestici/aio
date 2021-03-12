package com.aio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class ConnectionDB {

	private Connection connect = null;

	public Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker?user=webstudent&password=webstudent");			
			return connect;
		} catch (Exception e) {
			throw e;
		}
	}


	public void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
