package com.xuebo.dao;

import com.xuebo.bean.Student;

public interface IStudentDao {
	
	public int StudentInsert(Student student);
	public Student StudentSelectForLogin(Student student);
	public Student StudentSelectForPersonal(Student student);
	public int StudentUpdateForPersonal(Student student);
	public int StudentUpdateForPassword(Student student);
	public Student StudentSelectForTritune(Student student);
	public int StudentUpdateForImage(Student student);

}
