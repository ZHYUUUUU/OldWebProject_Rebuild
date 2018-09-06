package com.xuebo.controller.impl;

import java.util.List;

import com.xuebo.bean.Organization;
import com.xuebo.controller.IOrganizationController;
import com.xuebo.dao.IOrganizationDao;
import com.xuebo.dao.impl.OrganizationDaoImpl;

public class OrganizationControllerImpl implements IOrganizationController {
	
	private IOrganizationDao organizationdao = new OrganizationDaoImpl();

	@Override
	public List<Organization> OrganizationShowView() {
		
		return organizationdao.OrganizationSelectForShowView();
	}

	@Override
	public Organization OrganizationShowIntroduce(Organization organ) {
		
		return organizationdao.OrganizationSelectForShowIntroduce(organ);
	}

	@Override
	public Organization OrganizationResearch(Organization organ) {
		
		return organizationdao.OrganizationSelectForResearch(organ);
	}

}
