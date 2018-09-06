package com.xuebo.dao;

import java.util.List;

import com.xuebo.bean.Demand;

public interface IDemandDao {
	
	public List<Demand> DemandSelectForShowStudentList(Demand demand);
	public int DemandInsert(Demand demand);
	public int DemandDelete(Demand demand);
	public List<Demand> DemandSelectForShowExpertList();
	public Demand DemandSelectForShowDemandRead(Demand demand);
	public List<Demand> DemandSelectForShowExpertListScreenType(Demand demand);
	public int DemandUpdateForAccept(Demand demand);

}
