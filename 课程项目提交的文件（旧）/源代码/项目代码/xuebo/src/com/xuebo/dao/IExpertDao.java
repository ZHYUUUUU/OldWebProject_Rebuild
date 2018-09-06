package com.xuebo.dao;

import com.xuebo.bean.Expert;

public interface IExpertDao {

	public int ExpertInsert(Expert expert);
	public Expert ExpertSelectForLogin(Expert expert);
	public Expert ExpertSelectForPersonal(Expert expert);
	public int ExpertUpdateForPersonal(Expert expert);
	public int ExpertUpdateForPassword(Expert expert);
	public Expert ExpertSelectForTribune(Expert expert);
	public int ExpertUpdateForImage(Expert expert);
	public Expert ExpertSelectForResearch(Expert expert);
	
}
