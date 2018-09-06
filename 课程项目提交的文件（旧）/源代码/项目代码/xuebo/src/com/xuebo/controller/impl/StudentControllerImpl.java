package com.xuebo.controller.impl;

import com.xuebo.bean.Student;
import com.xuebo.controller.IStudentController;
import com.xuebo.dao.IStudentDao;
import com.xuebo.dao.impl.StudentDaoImpl;

public class StudentControllerImpl implements IStudentController{
	
	private IStudentDao studentDao = new StudentDaoImpl();

	@Override
	public int StudentRegister(Student student) {
		
		int insert = studentDao.StudentInsert(student);
		
		return insert;
	}

	@Override
	public Student StudentLogin(Student student) {

		return studentDao.StudentSelectForLogin(student);
	}

	@Override
	public Student StudentPersonal(Student student) {
		
		return studentDao.StudentSelectForPersonal(student);
	}

	@Override
	public int StudentUpdatePersonal(Student student) {
		
		return studentDao.StudentUpdateForPersonal(student);
	}

	@Override
	public int StudentUpdatePassword(Student student) {
		
		return studentDao.StudentUpdateForPassword(student);
	}

	@Override
	public Student StudentPersonalForTribune(Student student) {
		
		return studentDao.StudentSelectForTritune(student);
	}

	@Override
	public int StudentUpdateImage(Student student) {
		
		return studentDao.StudentUpdateForImage(student);
	}

}
