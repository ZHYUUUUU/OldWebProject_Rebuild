package com.xuebo.controller.impl;

import java.util.List;

import com.xuebo.bean.Discuss;
import com.xuebo.controller.IDiscussController;
import com.xuebo.dao.IDiscussDao;
import com.xuebo.dao.impl.DiscussDaoImpl;

public class DiscussControllerImpl implements IDiscussController {
	
	private IDiscussDao discussDao = new DiscussDaoImpl();

	@Override
	public List<Discuss> DiscussShowView(Discuss discuss) {
		
		return discussDao.DiscussSelectForShowView(discuss);
	}

	@Override
	public int DiscussPublish(Discuss discuss) {
		
		return discussDao.DiscussInsert(discuss);
	}

	@Override
	public int DiscussDelete(Discuss discuss) {
		
		return discussDao.DiscussDelete(discuss);
	}

}
