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
import com.xuebo.bean.Tribune;
import com.xuebo.dao.ITribuneDao;
import com.xuebo.utils.JDBCUtil;

public class TribuneDaoImpl implements ITribuneDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	private Tribune new_tribune = null;
	
	private List<Tribune> tribunes = null;

	@Override
	public List<Tribune> TribuneSelectForExpertList(Tribune tribune) {
		
		String sql = "select * from tribune where expertid is null "
				+ "union "
				+ "select * from tribune where expertid <> ? "
				+ "order by createdate desc";
		String sql2 = "select studentimage from student where studentid=?";
		String sql3 = "select expertimage from expert where expertid=?";
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		tribunes = new ArrayList<Tribune>();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, tribune.getExpertid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_tribune = new Tribune();
				new_tribune.setTribuneid(rs.getString("tribuneid"));
				new_tribune.setCreator(rs.getString("creator"));
				int creatorstate = rs.getInt("creatorstate");
				if(creatorstate == 0){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
					pstmt2.setString(1, rs.getString("studentid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("查找image失败！");
					}else{
						new_tribune.setCreatorimage(rs2.getString("studentimage") == null ? "images/kong.jpg" : rs2.getString("studentimage"));
					}
				}else if(creatorstate == 1){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql3);
					pstmt2.setString(1, rs.getString("expertid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("查找image失败！");
					}else{
						new_tribune.setCreatorimage(rs2.getString("expertimage") == null ? "images/kong.jpg" : rs2.getString("expertimage"));
					}
				}
				new_tribune.setCreatorstate(creatorstate);
				new_tribune.setStudentid(rs.getString("studentid"));
				new_tribune.setExpertid(rs.getString("expertid"));
				String createdate = rs.getString("createdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date cd = dateFormat1.parse(createdate);
					createdate = dateFormat2.format(cd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_tribune.setCreatedate(createdate);
				new_tribune.setTribunetitle(rs.getString("tribunetitle"));
				new_tribune.setTribunetheme(rs.getString("tribunetheme"));
				new_tribune.setTribunecontent(rs.getString("tribunecontent"));
				tribunes.add(new_tribune);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
				JDBCUtil.closeAll(conn, pstmt2, rs2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tribunes;
	}

	@Override
	public List<Tribune> TribuneSelectForExpertPersonalList(Tribune tribune) {
		
		String sql = "select * from tribune where expertid=? order by createdate desc";
		String sql2 = "select expertimage from expert where expertid=?";
		tribunes = new ArrayList<Tribune>();
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		String creatorimage = null;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt2.setString(1, tribune.getExpertid());
			
			rs2 = pstmt2.executeQuery();
			while(rs2.next()){
				creatorimage = rs2.getString("expertimage");
			}
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, tribune.getExpertid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_tribune = new Tribune();
				new_tribune.setTribuneid(rs.getString("tribuneid"));
				new_tribune.setCreator(rs.getString("creator"));
				new_tribune.setCreatorstate(rs.getInt("creatorstate"));
				new_tribune.setCreatorimage(creatorimage == null ? "images/kong.jpg" : creatorimage);
				new_tribune.setStudentid(rs.getString("studentid"));
				new_tribune.setExpertid(rs.getString("expertid"));
				String createdate = rs.getString("createdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date cd = dateFormat1.parse(createdate);
					createdate = dateFormat2.format(cd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_tribune.setCreatedate(createdate);
				new_tribune.setTribunetitle(rs.getString("tribunetitle"));
				new_tribune.setTribunetheme(rs.getString("tribunetheme"));
				new_tribune.setTribunecontent(rs.getString("tribunecontent"));
				tribunes.add(new_tribune);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
				JDBCUtil.closeAll(conn, pstmt2, rs2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tribunes;
	}

	@Override
	public List<Tribune> TribuneSelectForStudentList(Tribune tribune) {
		
		String sql = "select * from tribune where studentid is null "
				+ "union "
				+ "select * from tribune where studentid <> ? "
				+ "order by createdate desc";
		String sql2 = "select studentimage from student where studentid=?";
		String sql3 = "select expertimage from expert where expertid=?";
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		tribunes = new ArrayList<Tribune>();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, tribune.getStudentid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_tribune = new Tribune();
				new_tribune.setTribuneid(rs.getString("tribuneid"));
				new_tribune.setCreator(rs.getString("creator"));
				int creatorstate = rs.getInt("creatorstate");
				if(creatorstate == 0){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
					pstmt2.setString(1, rs.getString("studentid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("查找image失败！");
					}else{
						new_tribune.setCreatorimage(rs2.getString("studentimage") == null ? "images/kong.jpg" : rs2.getString("studentimage"));
					}
				}else if(creatorstate == 1){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql3);
					pstmt2.setString(1, rs.getString("expertid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("查找image失败！");
					}else{
						new_tribune.setCreatorimage(rs2.getString("expertimage") == null ? "images/kong.jpg" : rs2.getString("expertimage"));
					}
				}
				new_tribune.setCreatorstate(creatorstate);
				new_tribune.setStudentid(rs.getString("studentid"));
				new_tribune.setExpertid(rs.getString("expertid"));
				String createdate = rs.getString("createdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date cd = dateFormat1.parse(createdate);
					createdate = dateFormat2.format(cd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_tribune.setCreatedate(createdate);
				new_tribune.setTribunetitle(rs.getString("tribunetitle"));
				new_tribune.setTribunetheme(rs.getString("tribunetheme"));
				new_tribune.setTribunecontent(rs.getString("tribunecontent"));
				tribunes.add(new_tribune);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
				JDBCUtil.closeAll(conn, pstmt2, rs2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tribunes;
	}

	@Override
	public List<Tribune> TribuneSelectForStudentPersonalList(Tribune tribune) {
		
		String sql = "select * from tribune where studentid=? order by createdate desc";
		String sql2 = "select studentimage from student where studentid=?";
		tribunes = new ArrayList<Tribune>();
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		String creatorimage = null;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt2.setString(1, tribune.getStudentid());
			
			rs2 = pstmt2.executeQuery();
			while(rs2.next()){
				creatorimage = rs2.getString("studentimage");
			}
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, tribune.getStudentid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_tribune = new Tribune();
				new_tribune.setTribuneid(rs.getString("tribuneid"));
				new_tribune.setCreator(rs.getString("creator"));
				new_tribune.setCreatorstate(rs.getInt("creatorstate"));
				new_tribune.setCreatorimage(creatorimage == null ? "images/kong.jpg" : creatorimage);
				new_tribune.setStudentid(rs.getString("studentid"));
				new_tribune.setExpertid(rs.getString("expertid"));
				String createdate = rs.getString("createdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date cd = dateFormat1.parse(createdate);
					createdate = dateFormat2.format(cd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_tribune.setCreatedate(createdate);
				new_tribune.setTribunetitle(rs.getString("tribunetitle"));
				new_tribune.setTribunetheme(rs.getString("tribunetheme"));
				new_tribune.setTribunecontent(rs.getString("tribunecontent"));
				tribunes.add(new_tribune);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
				JDBCUtil.closeAll(conn, pstmt2, rs2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tribunes;
	}

	@Override
	public Tribune TribuneSelectForView(Tribune tribune) {
		
		String sql = "select * from tribune where tribuneid=?";
		String sql2 = "select studentimage from student where studentid=?";
		String sql3 = "select expertimage from expert where expertid=?";
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, tribune.getTribuneid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_tribune = new Tribune();
				new_tribune.setTribuneid(rs.getString("tribuneid"));
				new_tribune.setCreator(rs.getString("creator"));
				int creatorstate = rs.getInt("creatorstate");
				if(creatorstate == 0){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
					pstmt2.setString(1, rs.getString("studentid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("image查询失败！");
					}else{
						new_tribune.setCreatorimage(rs2.getString("studentimage") == null ? "images/kong.jpg" : rs2.getString("studentimage"));
					}
				}else if(creatorstate == 1){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql3);
					pstmt2.setString(1, rs.getString("expertid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("image查询失败！");
					}else{
						new_tribune.setCreatorimage(rs2.getString("expertimage") == null ? "images/kong.jpg" : rs2.getString("expertimage"));
					}
				}
				new_tribune.setCreatorstate(creatorstate);
				new_tribune.setStudentid(rs.getString("studentid"));
				new_tribune.setExpertid(rs.getString("expertid"));
				String createdate = rs.getString("createdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date cd = dateFormat1.parse(createdate);
					createdate = dateFormat2.format(cd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_tribune.setCreatedate(createdate);
				new_tribune.setTribunetitle(rs.getString("tribunetitle"));
				new_tribune.setTribunetheme(rs.getString("tribunetheme"));
				new_tribune.setTribunecontent(rs.getString("tribunecontent"));
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JDBCUtil.closeAll(conn, pstmt, rs);
				JDBCUtil.closeAll(conn, pstmt2, rs2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return new_tribune;
	}

	@Override
	public int TribuneInsertForExpert(Tribune tribune) {
		
		String sql = "insert into tribune values (?,?,?,null,?,?,?,?,?)";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, tribune.getTribuneid());
			pstmt.setString(2, tribune.getCreator());
			pstmt.setInt(3, 1);
			pstmt.setString(4, tribune.getExpertid());
			pstmt.setString(5, tribune.getCreatedate());
			pstmt.setString(6, tribune.getTribunetitle());
			pstmt.setString(7, tribune.getTribunetheme());
			pstmt.setString(8, tribune.getTribunecontent());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("创建论坛失败！");
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
	public int TribuneInsertForStudent(Tribune tribune) {
		
		String sql = "insert into tribune values (?,?,?,?,null,?,?,?,?)";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, tribune.getTribuneid());
			pstmt.setString(2, tribune.getCreator());
			pstmt.setInt(3, 0);
			pstmt.setString(4, tribune.getStudentid());
			pstmt.setString(5, tribune.getCreatedate());
			pstmt.setString(6, tribune.getTribunetitle());
			pstmt.setString(7, tribune.getTribunetheme());
			pstmt.setString(8, tribune.getTribunecontent());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("创建论坛失败！");
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
	public int TribuneDelete(Tribune tribune) {
		
		String sql = "delete from tribune where tribuneid=?";
		String sql2 = "delete from discuss where tribuneid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			//先清空该论坛的全部评论
			pstmt = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt.setString(1, tribune.getTribuneid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("删除该论坛全部评论失败！");
			}
			
			//再执行论坛的删除操作
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, tribune.getTribuneid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("删除论坛失败！");
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

}
