package com.xuebo.bean;

public class Student {
	
	private String studentid;
	
	private String studentpassword;
	
	private String newpassword;
	
	private String studentname;
	
	private String studentsex;
	
	private String studentemail;
	
	private String studentphone;
	
	private String studentimage;
	
	private String studentintroduce;
	
	private int statecode;//记录查询的状态

	public Student() {
		
	}

	public Student(String studentid, String studentpassword, String studentsex, String studentemail,
			String studentphone) {
		this.studentid = studentid;
		this.studentpassword = studentpassword;
		this.studentsex = studentsex;
		this.studentemail = studentemail;
		this.studentphone = studentphone;
	}

	public Student(String studentid, String studentpassword) {
		this.studentid = studentid;
		this.studentpassword = studentpassword;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentpassword() {
		return studentpassword;
	}

	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}
	
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentsex() {
		return studentsex;
	}

	public void setStudentsex(String studentsex) {
		this.studentsex = studentsex;
	}

	public String getStudentemail() {
		return studentemail;
	}

	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}

	public String getStudentphone() {
		return studentphone;
	}

	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}

	public String getStudentimage() {
		return studentimage;
	}

	public void setStudentimage(String studentimage) {
		this.studentimage = studentimage;
	}

	public String getStudentintroduce() {
		return studentintroduce;
	}

	public void setStudentintroduce(String studentintroduce) {
		this.studentintroduce = studentintroduce;
	}

	public int getStatecode() {
		return statecode;
	}

	public void setStatecode(int statecode) {
		this.statecode = statecode;
	}
	
	

}
