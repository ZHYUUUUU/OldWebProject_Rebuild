package com.xuebo.controller;

import java.util.List;

import com.xuebo.bean.Book;

public interface IBookController {
	
	public List<Book> BookShowExpertListForStudent();
	public List<Book> BookScreenSeenExpertListForStudent();
	public List<Book> BookScreenPointExpertListForStudent();
	public List<Book> BookScreenPriceExpertListForStudent();
	public List<Book> BookScreenTypeExpertListForStudent(Book book);
	public Book BookShowExpertForStudent(Book book);
	public int BookForStudent(Book book);
	public List<Book> BookListForStudent(Book book);
	public int BookCancelForStudent(Book book);
	public int BookAssessForStudent(Book book);
	public List<Book> BookListForExpert(Book book);
	public int BookFinishForExpert(Book book);
	public int BookAcceptForExpert(Book book);
	public List<Book> BookShowHomepage();

}
