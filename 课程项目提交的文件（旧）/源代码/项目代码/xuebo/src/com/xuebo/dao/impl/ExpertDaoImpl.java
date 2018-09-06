package com.xuebo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.xuebo.bean.Expert;
import com.xuebo.dao.IExpertDao;
import com.xuebo.utils.JDBCUtil;

public class ExpertDaoImpl implements IExpertDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	private Expert new_expert = null;

	@Override
	public int ExpertInsert(Expert expert) {
		
		String sql1 = "select expertid from expert where expertid=?";
		String sql2 = "select expertidcard from expert where expertidcard=?";
		String sql3 = "insert into expert (expertid,expertpassword,expertsex,expertidcard,experttype,expertemail,expertphone) values(?,?,?,?,?,?,?)";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			//重复用户名检查
			pstmt = (PreparedStatement) conn.prepareStatement(sql1);
			pstmt.setString(1, expert.getExpertid());
			
			rs = pstmt.executeQuery();
			if(rs.next()){//重复用户名，返回-1
				return -1;
			}
			
			//重复使用身份证号检查
			pstmt = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt.setString(1, expert.getExpertidcard());
			
			rs = pstmt.executeQuery();
			if(rs.next()){//重复身份证号，返回-2
				return -2;
			}
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql3);
			pstmt.setString(1, expert.getExpertid());
			pstmt.setString(2, expert.getExpertpassword());
			pstmt.setString(3, expert.getExpertsex());
			pstmt.setString(4, expert.getExpertidcard());
			pstmt.setString(5, expert.getExperttype());
			pstmt.setString(6, expert.getExpertemail());
			pstmt.setString(7, expert.getExpertphone());
			
			effectRow = pstmt.executeUpdate();
			
			if(effectRow != 1){
				System.out.println("注册专家失败");
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
	public Expert ExpertSelectForLogin(Expert expert) {
		
		String sql = "select expertid,expertpassword,expertidcard from expert where expertid=?";
		new_expert = new Expert();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, expert.getExpertid());
			rs = pstmt.executeQuery();
			if(!rs.next()){
				//没有此用户名
				new_expert.setStatecode(-1);
			}else if(!rs.getString("expertpassword").equals(expert.getExpertpassword())){
				//密码匹配错误
				new_expert.setStatecode(-2);
			}else if(!rs.getString("expertidcard").equals(expert.getExpertidcard())){
				//身份认证不匹配
				new_expert.setStatecode(-3);
			}else{
				new_expert.setExpertid(rs.getString("expertid"));
				new_expert.setExpertpassword(rs.getString("expertpassword"));
				new_expert.setExpertidcard(rs.getString("expertidcard"));
				
				new_expert.setStatecode(0);//成功
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
		
		return new_expert;
	}

	@Override
	public Expert ExpertSelectForPersonal(Expert expert) {
		
		String sql = "select * from expert where expertid=?";
		new_expert = new Expert();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, expert.getExpertid());
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()){
				//查询失败
				new_expert.setStatecode(-1);
			}else{
				new_expert.setExpertid(rs.getString("expertid"));
				new_expert.setExpertpassword(rs.getString("expertpassword"));
				new_expert.setExpertname(rs.getString("expertname") == null ? "（姓名）" : rs.getString("expertname"));
				new_expert.setExpertsex(rs.getString("expertsex"));
				new_expert.setExpertidcard(rs.getString("expertidcard"));
				new_expert.setExpertintroduce(rs.getString("expertintroduce") == null ? "这个专家很懒，什么都没有写~" : rs.getString("expertintroduce"));
				new_expert.setExpertresearch(rs.getString("expertresearch") == null ? "——没有研究成果——" : rs.getString("expertresearch"));
				new_expert.setExperttype(rs.getString("experttype"));
				new_expert.setExpertprice(rs.getInt("expertprice"));
				new_expert.setExpertemail(rs.getString("expertemail"));
				new_expert.setExpertphone(rs.getString("expertphone"));
				new_expert.setExpertoccupation(rs.getString("expertoccupation") == null ? "（职业或职称）" : rs.getString("expertoccupation"));
				new_expert.setExpertaddress(rs.getString("expertaddress") == null ? "（地址）" : rs.getString("expertaddress"));
				new_expert.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				
				new_expert.setStatecode(0);//成功
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
		
		return new_expert;
	}

	@Override
	public int ExpertUpdateForPersonal(Expert expert) {
		
		String sql = "update expert set expertname=?,expertintroduce=?,"
				+ "expertresearch=?,experttype=?,expertprice=?,expertemail=?,"
				+ "expertphone=?,expertoccupation=?,expertaddress=? "
				+ "where expertid=?";
		String sql2 = "update tribune set creator=? where creatorstate=1 and expertid=?";
		String sql3 = "update discuss set discussname=? where nametype=1 and expertid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, expert.getExpertname());
			pstmt.setString(2, expert.getExpertintroduce());
			pstmt.setString(3, expert.getExpertresearch());
			pstmt.setString(4, expert.getExperttype());
			pstmt.setDouble(5, expert.getExpertprice());
			pstmt.setString(6, expert.getExpertemail());
			pstmt.setString(7, expert.getExpertphone());
			pstmt.setString(8, expert.getExpertoccupation());
			pstmt.setString(9, expert.getExpertaddress());
			pstmt.setString(10, expert.getExpertid());
			
			effectRow = pstmt.executeUpdate();
			
			if(effectRow != 1){
				System.out.println("修改专家信息失败！");
			}else{//修改完资料后，修改论坛表和评论表的对应名字
				pstmt = (PreparedStatement) conn.prepareStatement(sql2);
				pstmt.setString(1, expert.getExpertname());
				pstmt.setString(2, expert.getExpertid());
				
				effectRow = pstmt.executeUpdate();
				
				pstmt = (PreparedStatement) conn.prepareStatement(sql3);
				pstmt.setString(1, expert.getExpertname());
				pstmt.setString(2, expert.getExpertid());
				
				effectRow = pstmt.executeUpdate();
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
	public int ExpertUpdateForPassword(Expert expert) {
		
		String sql1 = "select expertpassword from expert where expertid=?";
		String sql2 = "update expert set expertpassword=? where expertid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql1);
			pstmt.setString(1, expert.getExpertid());
			
			rs = pstmt.executeQuery();
			if(!rs.next()){
				System.out.println("查找专家密码失败！");
			}else{
				if(!rs.getString("expertpassword").equals(expert.getExpertpassword())){
					//原密码匹配失败
					return -1;
				}
			}
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt.setString(1, expert.getNewpassword());
			pstmt.setString(2, expert.getExpertid());
			
			effectRow = pstmt.executeUpdate();
			
			if(effectRow != 1){
				System.out.println("修改专家密码失败！");
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
	public Expert ExpertSelectForTribune(Expert expert) {
		
		String sql = "select expertid,expertname,expertimage from expert where expertid=?";
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, expert.getExpertid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_expert = new Expert();
				new_expert.setExpertid(rs.getString("expertid"));
				new_expert.setExpertname(rs.getString("expertname"));
				new_expert.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
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
		
		return new_expert;
	}

	@Override
	public int ExpertUpdateForImage(Expert expert) {
		
		String sql = "update expert set expertimage=? where expertid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, expert.getExpertimage());
			pstmt.setString(2, expert.getExpertid());
			
			effectRow = pstmt.executeUpdate();
			
			if(effectRow != 1){
				System.out.println("修改专家头像失败！");
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
	public Expert ExpertSelectForResearch(Expert expert) {
		
		String sql = "select expertid,expertname from expert where expertname=?";
		new_expert = new Expert();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, expert.getExpertname());
			rs = pstmt.executeQuery();
			if(!rs.next()){
				//没有此用户名
				new_expert.setStatecode(-1);
			}else{
				new_expert.setExpertid(rs.getString("expertid"));
				new_expert.setExpertname(rs.getString("expertname"));
				
				new_expert.setStatecode(0);//成功
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
		
		return new_expert;
	}

}
