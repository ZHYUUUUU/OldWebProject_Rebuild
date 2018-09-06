package com.xuebo.controller.impl;

import java.util.List;

import com.xuebo.bean.Tribune;
import com.xuebo.controller.ITribuneController;
import com.xuebo.dao.ITribuneDao;
import com.xuebo.dao.impl.TribuneDaoImpl;

public class TribuneControllerImpl implements ITribuneController {
	
	private ITribuneDao tribuneDao = new TribuneDaoImpl();

	@Override
	public List<Tribune> TribuneListForExpert(Tribune tribune) {
		
		return tribuneDao.TribuneSelectForExpertList(tribune);
	}

	@Override
	public List<Tribune> TribuneListForExpertPersonal(Tribune tribune) {
		
		return tribuneDao.TribuneSelectForExpertPersonalList(tribune);
	}

	@Override
	public List<Tribune> TribuneListForStudent(Tribune tribune) {
		
		return tribuneDao.TribuneSelectForStudentList(tribune);
	}

	@Override
	public List<Tribune> TribuneListForStudentPersonal(Tribune tribune) {
		
		return tribuneDao.TribuneSelectForStudentPersonalList(tribune);
	}

	@Override
	public Tribune TribuneView(Tribune tribune) {
		
		return tribuneDao.TribuneSelectForView(tribune);
	}

	@Override
	public int TribuneCreateForExpert(Tribune tribune) {
		
		return tribuneDao.TribuneInsertForExpert(tribune);
	}

	@Override
	public int TribuneCreateForStudent(Tribune tribune) {
		
		return tribuneDao.TribuneInsertForStudent(tribune);
	}

	@Override
	public int TribuneDelete(Tribune tribune) {
		
		return tribuneDao.TribuneDelete(tribune);
	}

}
