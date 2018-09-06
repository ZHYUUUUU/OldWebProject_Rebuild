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
import com.xuebo.bean.Discuss;
import com.xuebo.dao.IDiscussDao;
import com.xuebo.utils.JDBCUtil;

public class DiscussDaoImpl implements IDiscussDao {

	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	private Discuss new_discuss = null;
	
	private List<Discuss> discusses = null;
	
	@Override
	public List<Discuss> DiscussSelectForShowView(Discuss discuss) {
		
		String sql = "select * from discuss where tribuneid=? order by discussdate desc";
		String sql2 = "select studentimage from student where studentid=?";
		String sql3 = "select expertimage from expert where expertid=?";
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		discusses = new ArrayList<Discuss>();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, discuss.getTribuneid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_discuss = new Discuss();
				new_discuss.setDiscussid(rs.getString("discussid"));
				new_discuss.setDiscussname(rs.getString("discussname"));
				int nametype = rs.getInt("nametype");
				if(nametype == 0){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
					pstmt2.setString(1, rs.getString("studentid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("image查找失败！");
					}else{
						new_discuss.setDiscussimage(rs2.getString("studentimage") == null ? "images/kong.jpg" : rs2.getString("studentimage"));
					}
				}else if(nametype == 1){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql3);
					pstmt2.setString(1, rs.getString("expertid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("image查找失败！");
					}else{
						new_discuss.setDiscussimage(rs2.getString("expertimage") == null ? "images/kong.jpg" : rs2.getString("expertimage"));
					}
				}
				new_discuss.setNametype(nametype);
				new_discuss.setExpertid(rs.getString("expertid"));
				new_discuss.setStudentid(rs.getString("studentid"));
				String discussdate = rs.getString("discussdate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date dd = dateFormat1.parse(discussdate);
					discussdate = dateFormat2.format(dd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_discuss.setDiscussdate(discussdate);
				new_discuss.setDiscusscontent(rs.getString("discusscontent"));
				new_discuss.setTribuneid(rs.getString("tribuneid"));
				discusses.add(new_discuss);
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
		
		return discusses;
	}

	@Override
	public int DiscussInsert(Discuss discuss) {
		
		String sql;
		int effectRow;
		int nametype = discuss.getNametype();
		
		try {
			conn = JDBCUtil.getConnection();
			
			if(nametype == 0){
				sql = "insert into discuss values(?,?,?,?,null,?,?,?)";
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, discuss.getDiscussid());
				pstmt.setString(2, discuss.getDiscussname());
				pstmt.setInt(3, nametype);
				pstmt.setString(4, discuss.getStudentid());
				pstmt.setString(5, discuss.getDiscussdate());
				pstmt.setString(6, discuss.getDiscusscontent());
				pstmt.setString(7, discuss.getTribuneid());
			}else if(nametype == 1){
				sql = "insert into discuss values(?,?,?,null,?,?,?,?)";
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, discuss.getDiscussid());
				pstmt.setString(2, discuss.getDiscussname());
				pstmt.setInt(3, nametype);
				pstmt.setString(4, discuss.getExpertid());
				pstmt.setString(5, discuss.getDiscussdate());
				pstmt.setString(6, discuss.getDiscusscontent());
				pstmt.setString(7, discuss.getTribuneid());
			}
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("评论失败！");
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
	public int DiscussDelete(Discuss discuss) {
		
		String sql = "delete from discuss where discussid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, discuss.getDiscussid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("删除评论失败！");
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
