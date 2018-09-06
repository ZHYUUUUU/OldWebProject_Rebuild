package com.xuebo.controller.impl;

import java.util.List;

import com.xuebo.bean.Article;
import com.xuebo.controller.IArticleController;
import com.xuebo.dao.IArticleDao;
import com.xuebo.dao.impl.ArticleDaoImpl;

public class ArticleControllerImpl implements IArticleController {
	
	private IArticleDao articleDao = new ArticleDaoImpl();

	@Override
	public int ArticlePublish(Article article) {
		
		return articleDao.ArticleInsert(article);
	}

	@Override
	public List<Article> ArticleListForExpertPersonal(Article article) {
		
		return articleDao.ArticleSelectForExpertPersonalList(article);
	}

	@Override
	public Article ArticleReadForExpert(Article article) {
		
		return articleDao.ArticleSelectForRead(article);
	}

	@Override
	public int ArticleDelete(Article article) {
		
		return articleDao.ArticleDelete(article);
	}

	@Override
	public List<Article> ArticleListForExpert() {
		
		return articleDao.ArticleSelectForExpert();
	}

	@Override
	public List<Article> ArticleScreenTypeListForExpert(Article article) {
		
		return articleDao.ArticleSelectForExpertListType(article);
	}

	@Override
	public List<Article> ArticleListForStudentExpertMessage(Article article) {
		
		return articleDao.ArticleSelectForStudentExpertMessage(article);
	}

}
