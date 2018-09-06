package com.xuebo.controller;

import java.util.List;

import com.xuebo.bean.Article;

public interface IArticleController {
	
	public int ArticlePublish(Article article);
	public List<Article> ArticleListForExpertPersonal(Article article);
	public Article ArticleReadForExpert(Article article);
	public int ArticleDelete(Article article);
	public List<Article> ArticleListForExpert();
	public List<Article> ArticleScreenTypeListForExpert(Article article);
	public List<Article> ArticleListForStudentExpertMessage(Article article);

}
