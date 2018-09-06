package com.xuebo.dao;

import java.util.List;

import com.xuebo.bean.Article;

public interface IArticleDao {
	
	public int ArticleInsert(Article article);
	public List<Article> ArticleSelectForExpertPersonalList(Article article);
	public Article ArticleSelectForRead(Article article);
	public int ArticleDelete(Article article);
	public List<Article> ArticleSelectForExpert();
	public List<Article> ArticleSelectForExpertListType(Article article);
	public List<Article> ArticleSelectForStudentExpertMessage(Article article);

}
