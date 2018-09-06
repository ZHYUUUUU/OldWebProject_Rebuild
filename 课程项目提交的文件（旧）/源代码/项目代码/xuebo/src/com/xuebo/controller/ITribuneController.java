package com.xuebo.controller;

import java.util.List;

import com.xuebo.bean.Tribune;

public interface ITribuneController {
	
	public List<Tribune> TribuneListForExpert(Tribune tribune);
	public List<Tribune> TribuneListForExpertPersonal(Tribune tribune);
	public List<Tribune> TribuneListForStudent(Tribune tribune);
	public List<Tribune> TribuneListForStudentPersonal(Tribune tribune);
	public Tribune TribuneView(Tribune tribune);
	public int TribuneCreateForExpert(Tribune tribune);
	public int TribuneCreateForStudent(Tribune tribune);
	public int TribuneDelete(Tribune tribune);

}
