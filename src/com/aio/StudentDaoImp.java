package com.aio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class StudentDaoImp implements StudentDao {
	
	private ConnectionDB cdb = new ConnectionDB();

	//@Resource(name = "jdbc/web_student_tracker")
	//private DataSource datasource;
	

	@Override
	public List<Student> getAllStudent() throws Exception {
		List<Student> students = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = cdb.getConnection();
			stmt = conn.createStatement();
			String query = "select * from web_student_tracker.student order by id";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int studentID = rs.getInt("id");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String email = rs.getString("email");

				Student nStudent = new Student(studentID, firstname, lastname, email);

				students.add(nStudent);
			}
			return students;
		} finally {
			cdb.closeConnection(conn, stmt, rs);
		}

	}

	@Override
	public Student getStudent(int id) throws Exception {
		Student nStudent = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = cdb.getConnection();
			stmt = conn.createStatement();
			String query = "select * from web_student_tracker.student where id =" + id;
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int studentID = rs.getInt("id");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String email = rs.getString("email");

				nStudent = new Student(studentID, firstname, lastname, email);
			}
			return nStudent;
		} finally {
			cdb.closeConnection(conn, stmt, rs);
		}
	}


	public void addStudent(String name, String lname, String email) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = cdb.getConnection();
			stmt = conn.createStatement();
			String query = "insert into web_student_tracker.student set first_name = '" + name + "', last_name = '" 
					 	 + lname + "', email = '" + email + "'";
			stmt.execute(query);
		} finally {
			// clean up JDBC objects
			cdb.closeConnection(conn, stmt, null);
		}
	}


	public void deleteStudent(int id) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = cdb.getConnection();
			stmt = conn.createStatement();
			String query = "delete from web_student_tracker.student where id = " + id;
			stmt.execute(query);
		} finally {
			// clean up JDBC objects
			cdb.closeConnection(conn, stmt, null);
		}
	}

	public void updateStudent(int id, String name, String lname, String email) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = cdb.getConnection();
			stmt = conn.createStatement();
			String query = "update web_student_tracker.student set first_name='" + name + "', last_name='" + lname
					 	 + "', email='" + email + "' where id=" + id;
			stmt.execute(query);
		} finally {
			// clean up JDBC objects
			cdb.closeConnection(conn, stmt, null);
		}

	}

}
