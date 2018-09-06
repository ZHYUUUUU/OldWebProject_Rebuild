package com.xuebo.controller.impl;

import java.util.List;

import com.xuebo.bean.Demand;
import com.xuebo.controller.IDemandController;
import com.xuebo.dao.IDemandDao;
import com.xuebo.dao.impl.DemandDaoImpl;

public class DemandControllerImpl implements IDemandController {
	
	private IDemandDao demandDao = new DemandDaoImpl();

	@Override
	public List<Demand> DemandListForStudent(Demand demand) {
		
		return demandDao.DemandSelectForShowStudentList(demand);
	}

	@Override
	public int DemandPublishForStudent(Demand demand) {
		
		return demandDao.DemandInsert(demand);
	}

	@Override
	public int DemandDeleteForStudent(Demand demand) {
		
		return demandDao.DemandDelete(demand);
	}

	@Override
	public List<Demand> DemandListForExpert() {
		
		return demandDao.DemandSelectForShowExpertList();
	}

	@Override
	public Demand DemandRead(Demand demand) {
		
		return demandDao.DemandSelectForShowDemandRead(demand);
	}

	@Override
	public List<Demand> DemandListForExpertScreenType(Demand demand) {
		
		return demandDao.DemandSelectForShowExpertListScreenType(demand);
	}

	@Override
	public int DemandAccept(Demand demand) {
		
		return demandDao.DemandUpdateForAccept(demand);
	}

}
