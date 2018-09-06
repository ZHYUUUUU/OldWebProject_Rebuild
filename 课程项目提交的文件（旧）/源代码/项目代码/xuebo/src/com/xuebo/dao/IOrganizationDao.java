package com.xuebo.dao;

import java.util.List;

import com.xuebo.bean.Organization;

public interface IOrganizationDao {
	
	public List<Organization> OrganizationSelectForShowView();
	public Organization OrganizationSelectForShowIntroduce(Organization organ);
	public Organization OrganizationSelectForResearch(Organization organ);

}
