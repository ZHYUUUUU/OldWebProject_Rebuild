package com.xuebo.controller;

import java.util.List;

import com.xuebo.bean.Organization;

public interface IOrganizationController {
	
	public List<Organization> OrganizationShowView();
	public Organization OrganizationShowIntroduce(Organization organ);
	public Organization OrganizationResearch(Organization organ);

}
