package com.xuebo.controller;

import java.util.List;

import com.xuebo.bean.Demand;

public interface IDemandController {

	public List<Demand> DemandListForStudent(Demand demand);
	public int DemandPublishForStudent(Demand demand);
	public int DemandDeleteForStudent(Demand demand);
	public List<Demand> DemandListForExpert();
	public Demand DemandRead(Demand demand);
	public List<Demand> DemandListForExpertScreenType(Demand demand);
	public int DemandAccept(Demand demand);
	
}
