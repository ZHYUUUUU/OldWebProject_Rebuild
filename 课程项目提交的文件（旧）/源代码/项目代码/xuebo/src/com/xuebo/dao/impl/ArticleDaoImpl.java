package com.xuebo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.xuebo.bean.Article;
import com.xuebo.dao.IArticleDao;
import com.xuebo.utils.JDBCUtil;

public class ArticleDaoImpl implements IArticleDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	private Article new_article = null;
	
	private List<Article> articles = null;

	@Override
	public int ArticleInsert(Article article) {
		
		String sql = "insert into article values (?,?,?,?,?,?)";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, article.getArticleid());
			pstmt.setString(2, article.getExpertid());
			pstmt.setString(3, article.getPublishdate());
			pstmt.setString(4, article.getArticletitle());
			pstmt.setString(5, article.getArticletype());
			pstmt.setString(6, article.getArticlecontent());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("添加文章失败！");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public List<Article> ArticleSelectForExpertPersonalList(Article article) {
		
		String sql = "select articleid,expert.expertid,expertname,publishdate,articletitle,articletype,articlecontent "
				+ "from article,expert "
				+ "where expert.expertid=article.expertid "
				+ "and expert.expertid=? "
				+ "order by publishdate desc";
		articles = new ArrayList<Article>();
		int order = 0;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, article.getExpertid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				order = order + 1;
				new_article = new Article();
				new_article.setOrder(order);
				new_article.setArticleid(rs.getString("articleid"));
				new_article.setExpertid(rs.getString("expertid"));
				new_article.setExpertname(rs.getString("expertname"));
				String publishdate = rs.getString("publishdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date pd = dateFormat1.parse(publishdate);
					publishdate = dateFormat2.format(pd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_article.setPublishdate(publishdate);
				new_article.setArticletitle(rs.getString("articletitle"));
				new_article.setArticletype(rs.getString("articletype"));
				new_article.setArticlecontent(rs.getString("articlecontent"));
				articles.add(new_article);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return articles;
	}

	@Override
	public Article ArticleSelectForRead(Article article) {
		
		String sql = "select articleid,expert.expertid,expertname,publishdate,articletitle,articletype,articlecontent "
				+ "from article,expert "
				+ "where expert.expertid=article.expertid "
				+ "and articleid=?";
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, article.getArticleid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				new_article = new Article();
				new_article.setArticleid(rs.getString("articleid"));
				new_article.setExpertid(rs.getString("expertid"));
				new_article.setExpertname(rs.getString("expertname"));
				String publishdate = rs.getString("publishdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date pd = dateFormat1.parse(publishdate);
					publishdate = dateFormat2.format(pd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_article.setPublishdate(publishdate);
				new_article.setArticletitle(rs.getString("articletitle"));
				new_article.setArticletype(rs.getString("articletype"));
				new_article.setArticlecontent(rs.getString("articlecontent"));
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return new_article;
	}

	@Override
	public int ArticleDelete(Article article) {
		
		String sql = "delete from article where articleid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, article.getArticleid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("删除文章失败！");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public List<Article> ArticleSelectForExpert() {
		
		String sql = "select articleid,expert.expertid,expertname,expertimage,publishdate,articletitle,articletype,articlecontent "
				+ "from article,expert "
				+ "where expert.expertid=article.expertid";
		articles = new ArrayList<Article>();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy.MM.dd");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				new_article = new Article();
				new_article.setArticleid(rs.getString("articleid"));
				new_article.setExpertid(rs.getString("expertid"));
				new_article.setExpertname(rs.getString("expertname"));
				String publishdate = rs.getString("publishdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date pd = dateFormat1.parse(publishdate);
					publishdate = dateFormat2.format(pd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_article.setPublishdate(publishdate);
				new_article.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				new_article.setArticletitle(rs.getString("articletitle"));
				new_article.setArticletype(rs.getString("articletype"));
				String articlecontent = rs.getString("articlecontent");
				if(articlecontent.length() >= 50){
					articlecontent = articlecontent.substring(0, 50);
					new_article.setArticlecontent(articlecontent);
				}else{
					new_article.setArticlecontent(articlecontent);
				}
				articles.add(new_article);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return articles;
	}

	@Override
	public List<Article> ArticleSelectForExpertListType(Article article) {
		
		String sql = "select articleid,expert.expertid,expertname,expertimage,publishdate,articletitle,articletype,articlecontent "
				+ "from article,expert "
				+ "where expert.expertid=article.expertid "
				+ "and articletype=?";
		articles = new ArrayList<Article>();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy.MM.dd");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, article.getArticletype());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				new_article = new Article();
				new_article.setArticleid(rs.getString("articleid"));
				new_article.setExpertid(rs.getString("expertid"));
				new_article.setExpertname(rs.getString("expertname"));
				new_article.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				String publishdate = rs.getString("publishdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date pd = dateFormat1.parse(publishdate);
					publishdate = dateFormat2.format(pd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_article.setPublishdate(publishdate);
				new_article.setArticletitle(rs.getString("articletitle"));
				new_article.setArticletype(rs.getString("articletype"));
				String articlecontent = rs.getString("articlecontent");
				if(articlecontent.length() >= 50){
					articlecontent = articlecontent.substring(0, 50);
					new_article.setArticlecontent(articlecontent);
				}else{
					new_article.setArticlecontent(articlecontent);
				}
				articles.add(new_article);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return articles;
	}

	@Override
	public List<Article> ArticleSelectForStudentExpertMessage(Article article) {
		
		String sql = "select articleid,expert.expertid,articletitle,articlecontent "
				+ "from article,expert "
				+ "where expert.expertid=article.expertid "
				+ "and expert.expertid=?";
		articles = new ArrayList<Article>();
		int order = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, article.getExpertid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				order = order + 1;
				new_article = new Article();
				new_article.setOrder(order);
				new_article.setArticleid(rs.getString("articleid"));
				new_article.setExpertid(rs.getString("expertid"));
				new_article.setArticletitle(rs.getString("articletitle"));
				String articlecontent = rs.getString("articlecontent");
				if(articlecontent.length() >= 50){
					articlecontent = articlecontent.substring(0, 50);
					new_article.setArticlecontent(articlecontent);
				}else{
					new_article.setArticlecontent(articlecontent);
				}
				articles.add(new_article);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return articles;
	}

}
