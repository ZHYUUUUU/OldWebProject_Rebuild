package com.xuebo.controller;

import com.xuebo.bean.Student;

public interface IStudentController {
	
	public int StudentRegister(Student student);
	public Student StudentLogin(Student student);
	public Student StudentPersonal(Student student);
	public int StudentUpdatePersonal(Student student);
	public int StudentUpdatePassword(Student student);
	public Student StudentPersonalForTribune(Student student);
	public int StudentUpdateImage(Student student);
	
}
