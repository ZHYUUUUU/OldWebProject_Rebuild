package com.xuebo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.xuebo.bean.Organization;
import com.xuebo.dao.IOrganizationDao;
import com.xuebo.utils.JDBCUtil;

public class OrganizationDaoImpl implements IOrganizationDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	private Organization new_organ = null;
	
	private List<Organization> organs = null;

	@Override
	public List<Organization> OrganizationSelectForShowView() {
		
		String sql = "select organizationid,organizationname,organizationimage from organization";
		organs = new ArrayList<Organization>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_organ = new Organization();
				new_organ.setOrganizationid(rs.getString("organizationid"));
				new_organ.setOrganizationname(rs.getString("organizationname"));
				new_organ.setOrganizationimage(rs.getString("organizationimage"));
				organs.add(new_organ);
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
		
		return organs;
	}

	@Override
	public Organization OrganizationSelectForShowIntroduce(Organization organ) {
		
		String sql = "select * from organization where organizationid=?";
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, organ.getOrganizationid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_organ = new Organization();
				new_organ.setOrganizationid(rs.getString("organizationid"));
				new_organ.setOrganizationname(rs.getString("organizationname"));
				new_organ.setOrganizationclass(rs.getString("organizationclass"));
				new_organ.setOrganizationadd(rs.getString("organizationadd"));
				new_organ.setOrganizationaddress(rs.getString("organizationaddress"));
				new_organ.setOrganizationclass_price(rs.getString("organizationclass_price"));
				new_organ.setOrganizationintroduce(rs.getString("organizationintroduce"));
				new_organ.setOrganizationphone(rs.getString("organizationphone"));
				new_organ.setOrganizationimage(rs.getString("organizationimage"));
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
		
		return new_organ;
	}

	@Override
	public Organization OrganizationSelectForResearch(Organization organ) {
		
		String sql = "select * from organization where organizationname like ?";
		new_organ = new Organization();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, "%" + organ.getOrganizationname() + "%");
			rs = pstmt.executeQuery();
			if(!rs.next()){
				new_organ.setStatecode(-1);
			}else{
				new_organ.setOrganizationid(rs.getString("organizationid"));
				new_organ.setOrganizationname(rs.getString("organizationname"));
				new_organ.setStatecode(0);
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
		
		return new_organ;
	}

}
