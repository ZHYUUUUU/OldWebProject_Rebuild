package com.xuebo.controller;

import com.xuebo.bean.Expert;

public interface IExpertController {
	
	public int ExpertRegister(Expert expert);
	public Expert ExpertLogin(Expert expert);
	public Expert ExpertPersonal(Expert expert);
	public int ExpertUpdatePersonal(Expert expert);
	public int ExpertUpdatePassword(Expert expert);
	public Expert ExpertPersonalForTritune(Expert expert);
	public int ExpertUpdateImage(Expert expert);
	public Expert ExpertResearch(Expert expert);
}
