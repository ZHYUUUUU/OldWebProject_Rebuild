package com.xuebo.controller;

import java.util.List;

import com.xuebo.bean.Discuss;

public interface IDiscussController {
	
	public List<Discuss> DiscussShowView(Discuss discuss);
	public int DiscussPublish(Discuss discuss);
	public int DiscussDelete(Discuss discuss);

}
