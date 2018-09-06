package com.xuebo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.xuebo.bean.Student;
import com.xuebo.dao.IStudentDao;
import com.xuebo.utils.JDBCUtil;

public class StudentDaoImpl implements IStudentDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	private Student new_student = null;

	@Override
	public int StudentInsert(Student student) {
		
		String sql1 = "select studentid from student where studentid=?";
		String sql2 = "insert into student (studentid,studentpassword,studentsex,studentemail,studentphone) values(?,?,?,?,?)";
		int effectRow;

		try {
			conn = JDBCUtil.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql1);
			pstmt.setString(1, student.getStudentid());
			rs = pstmt.executeQuery();
			if(rs.next()){//重复用户名
				return -1;
			}
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt.setString(1, student.getStudentid());
			pstmt.setString(2, student.getStudentpassword());
			pstmt.setString(3, student.getStudentsex());
			pstmt.setString(4, student.getStudentemail());
			pstmt.setString(5, student.getStudentphone());
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("注册失败！");
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
	public Student StudentSelectForLogin(Student student) {
		
		String sql = "select studentid,studentpassword from student where studentid=?";
		new_student = new Student();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentid());
			rs = pstmt.executeQuery();
			if(!rs.next()){
				//没有此用户名
				new_student.setStatecode(-1);
			}else if(!rs.getString("studentpassword").equals(student.getStudentpassword())){
				//密码匹配错误
				new_student.setStatecode(-2);
			}else{
				new_student.setStudentid(rs.getString("studentid"));
				new_student.setStudentpassword(rs.getString("studentpassword"));
				
				new_student.setStatecode(0);//成功
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
		
		return new_student;
	}

	@Override
	public Student StudentSelectForPersonal(Student student) {
		
		String sql = "select * from student where studentid=?";
		new_student = new Student();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentid());
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()){
				//查询失败
				new_student.setStatecode(-1);
			}else{
				new_student.setStudentid(rs.getString("studentid"));
				new_student.setStudentpassword(rs.getString("studentpassword"));
				new_student.setStudentname(rs.getString("studentname") == null ? "（姓名）" : rs.getString("studentname"));
				new_student.setStudentsex(rs.getString("studentsex"));
				new_student.setStudentemail(rs.getString("studentemail"));
				new_student.setStudentphone(rs.getString("studentphone"));
				new_student.setStudentimage(rs.getString("studentimage") == null ? "images/kong.jpg" : rs.getString("studentimage"));
				System.out.println(rs.getString("studentimage"));
				System.out.println(new_student.getStudentimage());
				new_student.setStudentintroduce(rs.getString("studentintroduce") == null ? "这个学员很懒，什么都没有写~" : rs.getString("studentintroduce"));
				
				new_student.setStatecode(0);//成功
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
		
		return new_student;
	}

	@Override
	public int StudentUpdateForPersonal(Student student) {
		
		String sql = "update student set studentname=?,studentemail=?,studentphone=?,studentintroduce=? where studentid=?";
		String sql2 = "update tribune set creator=? where creatorstate=0 and studentid=?";
		String sql3 = "update discuss set discussname=? where nametype=0 and studentid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentname());
			pstmt.setString(2, student.getStudentemail());
			pstmt.setString(3, student.getStudentphone());
			pstmt.setString(4, student.getStudentintroduce());
			pstmt.setString(5, student.getStudentid());
			
			effectRow = pstmt.executeUpdate();
			
			if(effectRow != 1){
				System.out.println("修改学员信息失败！");
			}else{//修改完资料后，修改论坛表和评论表的对应名字
				pstmt = (PreparedStatement) conn.prepareStatement(sql2);
				pstmt.setString(1, student.getStudentname());
				pstmt.setString(2, student.getStudentid());
				
				effectRow = pstmt.executeUpdate();
				
				pstmt = (PreparedStatement) conn.prepareStatement(sql3);
				pstmt.setString(1, student.getStudentname());
				pstmt.setString(2, student.getStudentid());
				
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
	public int StudentUpdateForPassword(Student student) {

		String sql1 = "select studentpassword from student where studentid=?";
		String sql2 = "update student set studentpassword=? where studentid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql1);
			pstmt.setString(1, student.getStudentid());
			
			rs = pstmt.executeQuery();
			if(!rs.next()){
				System.out.println("查找学员密码失败！");
			}else{
				if(!rs.getString("studentpassword").equals(student.getStudentpassword())){
					//原密码匹配失败
					return -1;
				}
			}
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql2);
			pstmt.setString(1, student.getNewpassword());
			pstmt.setString(2, student.getStudentid());
			
			effectRow = pstmt.executeUpdate();
			
			if(effectRow != 1){
				System.out.println("修改学员密码失败！");
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
	public Student StudentSelectForTritune(Student student) {
		
		String sql = "select studentid,studentname,studentimage from student where studentid=?";
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentid());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_student = new Student();
				new_student.setStudentid(rs.getString("studentid"));
				new_student.setStudentname(rs.getString("studentname"));
				new_student.setStudentimage(rs.getString("studentimage") == null ? "images/kong.jpg" : rs.getString("studentimage"));
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
		
		return new_student;
	}

	@Override
	public int StudentUpdateForImage(Student student) {
		
		String sql = "update student set studentimage=? where studentid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentimage());
			pstmt.setString(2, student.getStudentid());
			
			effectRow = pstmt.executeUpdate();
			
			if(effectRow != 1){
				System.out.println("修改学员头像失败！");
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
