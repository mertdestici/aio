package com.aio;

public class Student {
	private int studentID;
	private String studentName;
	private String studentSur;
	private String email;

	public Student(int studentID, String studentName, String studentSur, String email) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentSur = studentSur;
		this.email = email;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSur() {
		return studentSur;
	}

	public void setStudentSur(String studentSur) {
		this.studentSur = studentSur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
