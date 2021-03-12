package com.aio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface StudentDao {
	public List<Student> getAllStudent() throws Exception;
	public Student getStudent(int id) throws Exception;
	public void addStudent(String name, String lname, String email) throws Exception;
	public void deleteStudent(int id) throws Exception;
	public void updateStudent(int id, String name, String lname, String email) throws Exception;
}
