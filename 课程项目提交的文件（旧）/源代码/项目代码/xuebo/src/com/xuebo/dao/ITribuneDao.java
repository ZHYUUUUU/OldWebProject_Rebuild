package com.xuebo.dao;

import java.util.List;

import com.xuebo.bean.Tribune;

public interface ITribuneDao {
	
	public List<Tribune> TribuneSelectForExpertList(Tribune tribune);
	public List<Tribune> TribuneSelectForExpertPersonalList(Tribune tribune);
	public List<Tribune> TribuneSelectForStudentList(Tribune tribune);
	public List<Tribune> TribuneSelectForStudentPersonalList(Tribune tribune);
	public Tribune TribuneSelectForView(Tribune tribune);
	public int TribuneInsertForExpert(Tribune tribune);
	public int TribuneInsertForStudent(Tribune tribune);
	public int TribuneDelete(Tribune tribune);

}
