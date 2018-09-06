package com.xuebo.dao;

import java.util.List;

import com.xuebo.bean.Book;

public interface IBookDao {
	
	public List<Book> BookSelectForShowExpertList();
	public List<Book> BookSelectForScreenSeenExpertList();
	public List<Book> BookSelectForScreenPointExpertList();
	public List<Book> BookSelectForScreenPriceExpertList();
	public List<Book> BookSelectForScreenTypeExpertList(Book book);
	public Book BookSelectForShowExpert(Book book);
	public int BookInsert(Book book);
	public List<Book> BookSelectForStudentBookList(Book book);
	public int BookDelete(Book book);
	public int BookUpdateAssessForStudent(Book book);
	public List<Book> BookSelectForExpertBookList(Book book);
	public int BookUpdateForBookFinish(Book book);
	public int BookUpdateForBookAccept(Book book);
	public List<Book> BookSelectForShowHomepage();

}
