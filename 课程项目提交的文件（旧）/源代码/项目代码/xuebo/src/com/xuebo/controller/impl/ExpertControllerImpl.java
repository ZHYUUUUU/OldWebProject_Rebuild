package com.xuebo.controller.impl;

import com.xuebo.bean.Expert;
import com.xuebo.controller.IExpertController;
import com.xuebo.dao.IExpertDao;
import com.xuebo.dao.impl.ExpertDaoImpl;

public class ExpertControllerImpl implements IExpertController {
	
	private IExpertDao expertDao = new ExpertDaoImpl();

	@Override
	public int ExpertRegister(Expert expert) {
		
		int insert = expertDao.ExpertInsert(expert);
		
		return insert;

	}

	@Override
	public Expert ExpertLogin(Expert expert) {

		return expertDao.ExpertSelectForLogin(expert);
	}

	@Override
	public Expert ExpertPersonal(Expert expert) {
		
		return expertDao.ExpertSelectForPersonal(expert);
	}

	@Override
	public int ExpertUpdatePersonal(Expert expert) {
		
		return expertDao.ExpertUpdateForPersonal(expert);
	}

	@Override
	public int ExpertUpdatePassword(Expert expert) {
		
		return expertDao.ExpertUpdateForPassword(expert);
	}

	@Override
	public Expert ExpertPersonalForTritune(Expert expert) {
		
		return expertDao.ExpertSelectForTribune(expert);
	}

	@Override
	public int ExpertUpdateImage(Expert expert) {
		
		return expertDao.ExpertUpdateForImage(expert);
	}

	@Override
	public Expert ExpertResearch(Expert expert) {
		
		return expertDao.ExpertSelectForResearch(expert);
	}

}
