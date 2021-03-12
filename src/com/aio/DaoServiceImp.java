package com.aio;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class DaoServiceImp implements DaoService {
	
	private StudentDao studentdao;

	public DaoServiceImp() {
		studentdao = new StudentDaoImp();
	}

	@Override
	public List<Student> getAllStudent() throws Exception {
		return studentdao.getAllStudent();
	}

	@Override
	public Student getStudent(int id) throws Exception {
		return studentdao.getStudent(id);
	}

	@Override
	public void addStudent(String name, String lname, String email) throws Exception {
		studentdao.addStudent(name,lname,email);
		return;
	}

	@Override
	public void deleteStudent(int id) throws Exception {
		studentdao.deleteStudent(id);
		return;
	}

	@Override
	public void updateStudent(int id, String name, String lname, String email) throws Exception {
		studentdao.updateStudent(id,name,lname,email);
		return;
	}

}
