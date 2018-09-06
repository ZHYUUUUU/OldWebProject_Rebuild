package com.xuebo.bean;

public class Expert {
	
	private String expertid;
	
	private String expertpassword;
	
	private String newpassword;
	
	private String expertname;
	
	private String expertsex;
	
	private String expertidcard;
	
	private String expertintroduce;
	
	private String expertresearch;

	private String experttype;
	
	private int expertprice;
	
	private String expertemail;
	
	private String expertphone;
	
	private String expertoccupation;
	
	private String expertaddress;
	
	private String expertimage;
	
	private int statecode;//记录查询的状态
	
	public Expert(){
		
	}

	public Expert(String expertid, String expertpassword, String expertsex, String expertidcard, String experttype,
			String expertemail, String expertphone) {
		this.expertid = expertid;
		this.expertpassword = expertpassword;
		this.expertsex = expertsex;
		this.expertidcard = expertidcard;
		this.experttype = experttype;
		this.expertemail = expertemail;
		this.expertphone = expertphone;
	}

	public Expert(String expertid, String expertpassword, String expertidcard) {
		this.expertid = expertid;
		this.expertpassword = expertpassword;
		this.expertidcard = expertidcard;
	}

	public Expert(String expertid, String expertname, String expertintroduce, String expertresearch, String experttype,
			int expertprice, String expertemail, String expertphone, String expertoccupation, String expertaddress) {
		this.expertid = expertid;
		this.expertname = expertname;
		this.expertintroduce = expertintroduce;
		this.expertresearch = expertresearch;
		this.experttype = experttype;
		this.expertprice = expertprice;
		this.expertemail = expertemail;
		this.expertphone = expertphone;
		this.expertoccupation = expertoccupation;
		this.expertaddress = expertaddress;
	}

	public String getExpertid() {
		return expertid;
	}

	public void setExpertid(String expertid) {
		this.expertid = expertid;
	}

	public String getExpertpassword() {
		return expertpassword;
	}

	public void setExpertpassword(String expertpassword) {
		this.expertpassword = expertpassword;
	}
	
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getExpertname() {
		return expertname;
	}

	public void setExpertname(String expertname) {
		this.expertname = expertname;
	}

	public String getExpertsex() {
		return expertsex;
	}

	public void setExpertsex(String expertsex) {
		this.expertsex = expertsex;
	}

	public String getExpertidcard() {
		return expertidcard;
	}

	public void setExpertidcard(String expertidcard) {
		this.expertidcard = expertidcard;
	}

	public String getExpertintroduce() {
		return expertintroduce;
	}

	public void setExpertintroduce(String expertintroduce) {
		this.expertintroduce = expertintroduce;
	}
	
	public String getExpertresearch() {
		return expertresearch;
	}

	public void setExpertresearch(String expertresearch) {
		this.expertresearch = expertresearch;
	}

	public String getExperttype() {
		return experttype;
	}

	public void setExperttype(String experttype) {
		this.experttype = experttype;
	}

	public int getExpertprice() {
		return expertprice;
	}

	public void setExpertprice(int expertprice) {
		this.expertprice = expertprice;
	}

	public String getExpertemail() {
		return expertemail;
	}

	public void setExpertemail(String expertemail) {
		this.expertemail = expertemail;
	}

	public String getExpertphone() {
		return expertphone;
	}

	public void setExpertphone(String expertphone) {
		this.expertphone = expertphone;
	}

	public String getExpertoccupation() {
		return expertoccupation;
	}

	public void setExpertoccupation(String expertoccupation) {
		this.expertoccupation = expertoccupation;
	}

	public String getExpertaddress() {
		return expertaddress;
	}

	public void setExpertaddress(String expertaddress) {
		this.expertaddress = expertaddress;
	}

	public String getExpertimage() {
		return expertimage;
	}

	public void setExpertimage(String expertimage) {
		this.expertimage = expertimage;
	}

	public int getStatecode() {
		return statecode;
	}

	public void setStatecode(int statecode) {
		this.statecode = statecode;
	}
	
	
}
