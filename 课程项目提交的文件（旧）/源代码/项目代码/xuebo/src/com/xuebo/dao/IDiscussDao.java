package com.xuebo.dao;

import java.util.List;

import com.xuebo.bean.Discuss;

public interface IDiscussDao {
	
	public List<Discuss> DiscussSelectForShowView(Discuss discuss);
	public int DiscussInsert(Discuss discuss);
	public int DiscussDelete(Discuss discuss);

}
