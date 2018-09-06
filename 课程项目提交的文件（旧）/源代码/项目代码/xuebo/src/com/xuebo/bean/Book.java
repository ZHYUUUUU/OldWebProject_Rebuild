package com.xuebo.bean;

public class Book {
	
	private String bookid;
	
	private int order;
	
	private String expertid;
	
	private String studentid;
	
	private String expertname;
	
	private String expertimage;
	
	private String expertintroduce;
	
	private String expertresearch;
	
	private String experttype;
	
	private int expertprice;
	
	private String expertoccupation;
	
	private String studentname;
	
	private String studentphone;
	
	private String bookdate;
	
	private String meetdate;
	
	private String meetaddress;
	
	private int bookstate;
	
	private String bookstate_str;
	
	private String bookintroduce;
	
	private int bookassess;
	
	private double avg_bookassess;
	
	private int count_book;
	
	public Book(){
		
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getExpertid() {
		return expertid;
	}

	public void setExpertid(String expertid) {
		this.expertid = expertid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getExpertname() {
		return expertname;
	}

	public void setExpertname(String expertname) {
		this.expertname = expertname;
	}

	public String getExpertimage() {
		return expertimage;
	}

	public void setExpertimage(String expertimage) {
		this.expertimage = expertimage;
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

	public String getExpertoccupation() {
		return expertoccupation;
	}

	public void setExpertoccupation(String expertoccupation) {
		this.expertoccupation = expertoccupation;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentphone() {
		return studentphone;
	}

	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}

	public String getBookdate() {
		return bookdate;
	}

	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}

	public String getMeetdate() {
		return meetdate;
	}

	public void setMeetdate(String meetdate) {
		this.meetdate = meetdate;
	}

	public String getMeetaddress() {
		return meetaddress;
	}

	public void setMeetaddress(String meetaddress) {
		this.meetaddress = meetaddress;
	}

	public int getBookstate() {
		return bookstate;
	}

	public void setBookstate(int bookstate) {
		this.bookstate = bookstate;
		switch(bookstate){
			case 0:
				setBookstate_str("预约失败");
				break;
			case 1:
				setBookstate_str("预约成功");
				break;
			case 2:
				setBookstate_str("预约中");
				break;
			case 3:
				setBookstate_str("未评价");
				break;
			case 4:
				setBookstate_str("已评价");
				break;
		}
	}

	public String getBookstate_str() {
		return bookstate_str;
	}

	public void setBookstate_str(String bookstate_str) {
		this.bookstate_str = bookstate_str;
	}

	public String getBookintroduce() {
		return bookintroduce;
	}

	public void setBookintroduce(String bookintroduce) {
		this.bookintroduce = bookintroduce;
	}

	public int getBookassess() {
		return bookassess;
	}

	public void setBookassess(int bookassess) {
		this.bookassess = bookassess;
	}

	public double getAvg_bookassess() {
		return avg_bookassess;
	}

	public void setAvg_bookassess(double avg_bookassess) {
		this.avg_bookassess = avg_bookassess;
	}

	public int getCount_book() {
		return count_book;
	}

	public void setCount_book(int count_book) {
		this.count_book = count_book;
	}
	

}
