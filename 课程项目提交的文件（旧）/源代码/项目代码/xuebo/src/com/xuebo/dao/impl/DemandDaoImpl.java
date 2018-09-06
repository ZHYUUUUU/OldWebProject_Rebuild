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
import com.xuebo.bean.Demand;
import com.xuebo.dao.IDemandDao;
import com.xuebo.utils.JDBCUtil;

public class DemandDaoImpl implements IDemandDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	private Demand new_demand = null;
	
	private List<Demand> demands = null;

	@Override
	public List<Demand> DemandSelectForShowStudentList(Demand demand) {
		
		String sql = "select demandid,student.studentid,bookid,studentname,demandtype,demanddate,demandmeetdate,demandmeetaddress,demandcontent,demandstate "
				+ "from demand,student "
				+ "where demand.studentid=student.studentid "
				+ "and student.studentid=? "
				+ "order by demanddate desc";
		String sql2 = "select bookid,bookdate,expertname "
				+ "from book,expert "
				+ "where book.expertid=expert.expertid "
				+ "and bookid=?";
		demands = new ArrayList<Demand>();
		int order = 0;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, demand.getStudentid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				order = order + 1;
				new_demand = new Demand();
				int demandstate = rs.getInt("demandstate");
				if(demandstate == 0){
					new_demand.setOrder(order);
					new_demand.setStudentid(rs.getString("studentid"));
					new_demand.setDemandid(rs.getString("demandid"));
					new_demand.setDemandtype(rs.getString("demandtype"));
					String demanddate = rs.getString("demanddate");
					//处理时间在特定格式，例如2018/06/13 18:00:00
					try {
						Date dd = dateFormat1.parse(demanddate);
						demanddate = dateFormat2.format(dd);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					new_demand.setDemanddate(demanddate);
					new_demand.setDemandmeetdate(rs.getString("demandmeetdate"));
					new_demand.setDemandmeetaddress(rs.getString("demandmeetaddress"));
					new_demand.setDemandcontent(rs.getString("demandcontent"));
					new_demand.setDemandstate(demandstate);
				}else if(demandstate == 1){
					pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
					pstmt2.setString(1, rs.getString("bookid"));
					rs2 = pstmt2.executeQuery();
					if(!rs2.next()){
						System.out.println("查找预约表失败！");
					}else{
						new_demand.setOrder(order);
						new_demand.setStudentid(rs.getString("studentid"));
						new_demand.setDemandid(rs.getString("demandid"));
						new_demand.setDemandtype(rs.getString("demandtype"));
						String demanddate = rs.getString("demanddate");
						//处理时间在特定格式，例如2018/06/13 18:00:00
						try {
							Date dd = dateFormat1.parse(demanddate);
							demanddate = dateFormat2.format(dd);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						new_demand.setDemanddate(demanddate);
						new_demand.setDemandmeetdate(rs.getString("demandmeetdate"));
						new_demand.setDemandmeetaddress(rs.getString("demandmeetaddress"));
						new_demand.setDemandcontent(rs.getString("demandcontent"));
						new_demand.setDemandstate(demandstate);
						new_demand.setBookid(rs2.getString("bookid"));
						String bookdate = rs2.getString("bookdate");
						//处理时间在特定格式，例如2018/06/13 18:00:00
						try {
							Date bd = dateFormat1.parse(bookdate);
							bookdate = dateFormat2.format(bd);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						new_demand.setBookdate(bookdate);
						new_demand.setExpertname(rs2.getString("expertname"));
					}
				}
				demands.add(new_demand);
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
		
		return demands;
	}

	@Override
	public int DemandInsert(Demand demand) {
		
		String sql = "insert into demand values(?,?,null,?,?,?,?,?,?);";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, demand.getDemandid());
			pstmt.setString(2, demand.getStudentid());
			pstmt.setString(3, demand.getDemandtype());
			pstmt.setString(4, demand.getDemanddate());
			pstmt.setString(5, demand.getDemandmeetdate());
			pstmt.setString(6, demand.getDemandmeetaddress());
			pstmt.setString(7, demand.getDemandcontent());
			pstmt.setInt(8, 0);
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("发布需求失败！");
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
	public int DemandDelete(Demand demand) {
		
		String sql = "delete from demand where demandid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, demand.getDemandid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("删除需求失败！");
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
	public List<Demand> DemandSelectForShowExpertList() {
		
		String sql = "select demandid,student.studentid,bookid,studentname,studentimage,demandtype,demanddate,demandmeetdate,demandmeetaddress,demandcontent,demandstate "
				+ "from demand,student "
				+ "where demand.studentid=student.studentid "
				+ "order by demanddate desc";
		demands = new ArrayList<Demand>();
		int order = 0;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy.MM.dd");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt("demandstate") == 1){
					continue;
				}
				order = order + 1;
				new_demand = new Demand();
				int demandstate = rs.getInt("demandstate");
				new_demand.setOrder(order);
				new_demand.setStudentid(rs.getString("studentid"));
				new_demand.setStudentname(rs.getString("studentname"));
				new_demand.setDemandid(rs.getString("demandid"));
				new_demand.setDemandtype(rs.getString("demandtype"));
				new_demand.setStudentimage(rs.getString("studentimage") == null ? "images/kong.jpg" : rs.getString("studentimage"));
				String demanddate = rs.getString("demanddate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date dd = dateFormat1.parse(demanddate);
					demanddate = dateFormat2.format(dd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_demand.setDemanddate(demanddate);
				String demandcontent = rs.getString("demandcontent");
				if(demandcontent.length() > 13){
					demandcontent = demandcontent.substring(0,12);
					new_demand.setDemandcontent(demandcontent + "……");
				}else if(demandcontent.equals("")){
					new_demand.setDemandcontent("——（需求内容）——");
				}else{
					new_demand.setDemandcontent(demandcontent);
				}
				new_demand.setDemandstate(demandstate);

				demands.add(new_demand);
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
		
		return demands;
	}

	@Override
	public Demand DemandSelectForShowDemandRead(Demand demand) {
		
		String sql = "select demandid,student.studentid,studentname,studentphone,demandtype,demanddate,demandmeetdate,demandmeetaddress,demandcontent,demandstate "
				+ "from demand,student "
				+ "where demand.studentid=student.studentid "
				+ "and demandid=?";
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		new_demand = new Demand();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, demand.getDemandid());
			
			rs = pstmt.executeQuery();
			if(!rs.next()){
				System.out.println("查询该条需求记录失败！");
			}else{
				new_demand.setDemandid(rs.getString("demandid"));
				new_demand.setStudentid(rs.getString("studentid"));
				new_demand.setStudentname(rs.getString("studentname"));
				new_demand.setStudentphone(rs.getString("studentphone"));
				new_demand.setDemandtype(rs.getString("demandtype"));
				String demanddate = rs.getString("demanddate");
				//处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date dd = dateFormat1.parse(demanddate);
					demanddate = dateFormat2.format(dd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_demand.setDemanddate(demanddate);
				new_demand.setDemandmeetdate(rs.getString("demandmeetdate"));
				new_demand.setDemandmeetaddress(rs.getString("demandmeetaddress"));
				new_demand.setDemandcontent(rs.getString("demandcontent"));
				new_demand.setDemandstate(rs.getInt("demandstate"));
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
		
		return new_demand;
	}

	@Override
	public List<Demand> DemandSelectForShowExpertListScreenType(Demand demand) {
		
		String sql = "select demandid,student.studentid,bookid,studentname,studentimage,demandtype,demanddate,demandmeetdate,demandmeetaddress,demandcontent,demandstate "
				+ "from demand,student "
				+ "where demand.studentid=student.studentid and demandtype=?"
				+ "order by demanddate desc";
		demands = new ArrayList<Demand>();
		int order = 0;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy.MM.dd");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, demand.getDemandtype());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt("demandstate") == 1){
					continue;
				}
				order = order + 1;
				new_demand = new Demand();
				int demandstate = rs.getInt("demandstate");
				new_demand.setOrder(order);
				new_demand.setStudentid(rs.getString("studentid"));
				new_demand.setStudentname(rs.getString("studentname"));
				new_demand.setDemandid(rs.getString("demandid"));
				new_demand.setDemandtype(rs.getString("demandtype"));
				new_demand.setStudentimage(rs.getString("studentimage") == null ? "images/kong.jpg" : rs.getString("studentimage"));
				String demanddate = rs.getString("demanddate");
				// 处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date dd = dateFormat1.parse(demanddate);
					demanddate = dateFormat2.format(dd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_demand.setDemanddate(demanddate);
				String demandcontent = rs.getString("demandcontent");
				if(demandcontent.length() > 13){
					demandcontent = demandcontent.substring(0,12);
					new_demand.setDemandcontent(demandcontent + "……");
				}else if(demandcontent.equals("")){
					new_demand.setDemandcontent("——（需求内容）——");
				}else{
					new_demand.setDemandcontent(demandcontent);
				}
				new_demand.setDemandstate(demandstate);

				demands.add(new_demand);
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
		
		return demands;

	}

	@Override
	public int DemandUpdateForAccept(Demand demand) {
		
		String sql = "update demand set demandstate=?,bookid=? where demandid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setString(2, demand.getBookid());
			pstmt.setString(3, demand.getDemandid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("修改需求表失败！");
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
