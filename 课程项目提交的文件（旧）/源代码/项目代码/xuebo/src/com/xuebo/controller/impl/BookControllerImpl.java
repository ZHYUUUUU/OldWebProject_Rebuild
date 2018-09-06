package com.xuebo.controller.impl;

import java.util.List;

import com.xuebo.bean.Book;
import com.xuebo.controller.IBookController;
import com.xuebo.dao.IBookDao;
import com.xuebo.dao.impl.BookDaoImpl;

public class BookControllerImpl implements IBookController {
	
	private IBookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> BookShowExpertListForStudent() {

		return bookDao.BookSelectForShowExpertList();
	}

	@Override
	public List<Book> BookScreenSeenExpertListForStudent() {
		
		return bookDao.BookSelectForScreenSeenExpertList();
	}

	@Override
	public List<Book> BookScreenPointExpertListForStudent() {
		
		return bookDao.BookSelectForScreenPointExpertList();
	}

	@Override
	public List<Book> BookScreenPriceExpertListForStudent() {
		
		return bookDao.BookSelectForScreenPriceExpertList();
	}

	@Override
	public List<Book> BookScreenTypeExpertListForStudent(Book book) {
		
		return bookDao.BookSelectForScreenTypeExpertList(book);
	}

	@Override
	public Book BookShowExpertForStudent(Book book) {
		
		return bookDao.BookSelectForShowExpert(book);
	}

	@Override
	public int BookForStudent(Book book) {
		
		return bookDao.BookInsert(book);
	}

	@Override
	public List<Book> BookListForStudent(Book book) {
		
		return bookDao.BookSelectForStudentBookList(book);
	}

	@Override
	public int BookCancelForStudent(Book book) {
		
		return bookDao.BookDelete(book);
	}

	@Override
	public int BookAssessForStudent(Book book) {
		
		return bookDao.BookUpdateAssessForStudent(book);
	}

	@Override
	public List<Book> BookListForExpert(Book book) {
		
		return bookDao.BookSelectForExpertBookList(book);
	}

	@Override
	public int BookFinishForExpert(Book book) {
		
		return bookDao.BookUpdateForBookFinish(book);
	}

	@Override
	public int BookAcceptForExpert(Book book) {
		
		return bookDao.BookUpdateForBookAccept(book);
	}

	@Override
	public List<Book> BookShowHomepage() {
		
		return bookDao.BookSelectForShowHomepage();
	}

}
