package com.xuebo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.xuebo.bean.Book;
import com.xuebo.dao.IBookDao;
import com.xuebo.utils.JDBCUtil;

public class BookDaoImpl implements IBookDao {
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null;
	
	private ResultSet rs = null;
	
	private Book new_book = null;
	
	private List<Book> books = null;

	@Override
	public List<Book> BookSelectForShowExpertList() {
		
		String sql = "select expert.expertid,expertname,expertimage,expertoccupation,expertprice,expertintroduce,experttype,avg(bookassess) avg_bookassess,count(studentid) count_book "
				+ "from book right join expert on expert.expertid=book.expertid "
				+ "group by expert.expertid,expertname,expertoccupation,expertprice,expertintroduce,experttype";
		books = new ArrayList<Book>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_book = new Book();
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setExpertname(rs.getString("expertname"));
				new_book.setExpertoccupation(rs.getString("expertoccupation"));
				new_book.setExpertprice(rs.getInt("expertprice"));
				new_book.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				String introduce = rs.getString("expertintroduce");
				if(introduce == null){
					new_book.setExpertintroduce("该专家没有留话~");
				}else if(introduce.length() > 20){
					introduce = introduce.substring(0,19);
					new_book.setExpertintroduce(introduce + "……");
				}else if(introduce.equals("")){
					new_book.setExpertintroduce("该专家没有留话~");
				}else{
					new_book.setExpertintroduce(introduce);
				}
				
				new_book.setExperttype(rs.getString("experttype"));
				new_book.setAvg_bookassess(Double.parseDouble(new DecimalFormat("0.0").format(rs.getDouble("avg_bookassess"))));//定义平均评分为一位小数
				new_book.setCount_book(rs.getInt("count_book"));
				books.add(new_book);
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
		
		return books;
	}

	@Override
	public List<Book> BookSelectForScreenSeenExpertList() {
		
		String sql = "select expert.expertid,expertname,expertimage,expertoccupation,expertprice,expertintroduce,experttype,avg(bookassess) avg_bookassess,count(studentid) count_book "
				+ "from book right join expert on expert.expertid=book.expertid "
				+ "group by expert.expertid,expertname,expertoccupation,expertprice,expertintroduce,experttype "
				+ "order by count_book desc";
		books = new ArrayList<Book>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_book = new Book();
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setExpertname(rs.getString("expertname"));
				new_book.setExpertoccupation(rs.getString("expertoccupation"));
				new_book.setExpertprice(rs.getInt("expertprice"));
				new_book.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				String introduce = rs.getString("expertintroduce");
				if(introduce.length() > 20){
					introduce = introduce.substring(0,19);
					new_book.setExpertintroduce(introduce + "……");
				}else if(introduce.equals("")){
					new_book.setExpertintroduce("该专家没有留话~");
				}else{
					new_book.setExpertintroduce(introduce);
				}
				
				new_book.setExperttype(rs.getString("experttype"));
				new_book.setAvg_bookassess(Double.parseDouble(new DecimalFormat("0.0").format(rs.getDouble("avg_bookassess"))));//定义平均评分为一位小数
				new_book.setCount_book(rs.getInt("count_book"));
				books.add(new_book);
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
		
		return books;
	}

	@Override
	public List<Book> BookSelectForScreenPointExpertList() {
		
		String sql = "select expert.expertid,expertname,expertimage,expertoccupation,expertprice,expertintroduce,experttype,avg(bookassess) avg_bookassess,count(studentid) count_book "
				+ "from book right join expert on expert.expertid=book.expertid "
				+ "group by expert.expertid,expertname,expertoccupation,expertprice,expertintroduce,experttype "
				+ "order by avg_bookassess desc";
		books = new ArrayList<Book>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_book = new Book();
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setExpertname(rs.getString("expertname"));
				new_book.setExpertoccupation(rs.getString("expertoccupation"));
				new_book.setExpertprice(rs.getInt("expertprice"));
				new_book.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				String introduce = rs.getString("expertintroduce");
				if(introduce.length() > 20){
					introduce = introduce.substring(0,19);
					new_book.setExpertintroduce(introduce + "……");
				}else if(introduce.equals("")){
					new_book.setExpertintroduce("该专家没有留话~");
				}else{
					new_book.setExpertintroduce(introduce);
				}
				
				new_book.setExperttype(rs.getString("experttype"));
				new_book.setAvg_bookassess(Double.parseDouble(new DecimalFormat("0.0").format(rs.getDouble("avg_bookassess"))));//定义平均评分为一位小数
				new_book.setCount_book(rs.getInt("count_book"));
				books.add(new_book);
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
		
		return books;
	}

	@Override
	public List<Book> BookSelectForScreenPriceExpertList() {
		
		String sql = "select expert.expertid,expertname,expertimage,expertoccupation,expertprice,expertintroduce,experttype,avg(bookassess) avg_bookassess,count(studentid) count_book "
				+ "from book right join expert on expert.expertid=book.expertid "
				+ "group by expert.expertid,expertname,expertoccupation,expertprice,expertintroduce,experttype "
				+ "order by expertprice";
		books = new ArrayList<Book>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_book = new Book();
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setExpertname(rs.getString("expertname"));
				new_book.setExpertoccupation(rs.getString("expertoccupation"));
				new_book.setExpertprice(rs.getInt("expertprice"));
				new_book.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				String introduce = rs.getString("expertintroduce");
				if(introduce.length() > 20){
					introduce = introduce.substring(0,19);
					new_book.setExpertintroduce(introduce + "……");
				}else if(introduce.equals("")){
					new_book.setExpertintroduce("该专家没有留话~");
				}else{
					new_book.setExpertintroduce(introduce);
				}
				
				new_book.setExperttype(rs.getString("experttype"));
				new_book.setAvg_bookassess(Double.parseDouble(new DecimalFormat("0.0").format(rs.getDouble("avg_bookassess"))));//定义平均评分为一位小数
				new_book.setCount_book(rs.getInt("count_book"));
				books.add(new_book);
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
		
		return books;
		
	}

	@Override
	public List<Book> BookSelectForScreenTypeExpertList(Book book) {
		
		String sql = "select expert.expertid,expertname,expertimage,expertoccupation,expertprice,expertintroduce,experttype,avg(bookassess) avg_bookassess,count(studentid) count_book "
				+ "from book right join expert on expert.expertid=book.expertid "
				+ "where experttype=? "
				+ "group by expert.expertid,expertname,expertoccupation,expertprice,expertintroduce,experttype";
		books = new ArrayList<Book>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, book.getExperttype());
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_book = new Book();
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setExpertname(rs.getString("expertname"));
				new_book.setExpertoccupation(rs.getString("expertoccupation"));
				new_book.setExpertprice(rs.getInt("expertprice"));
				new_book.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				String introduce = rs.getString("expertintroduce");
				if(introduce.length() > 20){
					introduce = introduce.substring(0,19);
					new_book.setExpertintroduce(introduce + "……");
				}else if(introduce.equals("")){
					new_book.setExpertintroduce("该专家没有留话~");
				}else{
					new_book.setExpertintroduce(introduce);
				}
				
				new_book.setExperttype(rs.getString("experttype"));
				new_book.setAvg_bookassess(Double.parseDouble(new DecimalFormat("0.0").format(rs.getDouble("avg_bookassess"))));//定义平均评分为一位小数
				new_book.setCount_book(rs.getInt("count_book"));
				books.add(new_book);
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
		
		return books;

		
	}

	@Override
	public Book BookSelectForShowExpert(Book book) {
		
		String sql = "select expert.expertid,expertname,expertimage,expertoccupation,expertprice,expertintroduce,experttype,avg(bookassess) avg_bookassess,count(studentid) count_book "
				+ "from book right join expert on expert.expertid=book.expertid "
				+ "where expert.expertid=? "
				+ "group by expert.expertid,expertname,expertoccupation,expertprice,expertintroduce,experttype";
		new_book = new Book();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, book.getExpertid());
			rs = pstmt.executeQuery();
			while(rs.next()){
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setExpertname(rs.getString("expertname") == null ? "（姓名）" : rs.getString("expertname"));
				new_book.setExpertoccupation(rs.getString("expertoccupation") == null ? "（职业或职称）" : rs.getString("expertoccupation"));
				new_book.setExpertprice(rs.getInt("expertprice"));
				new_book.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				new_book.setAvg_bookassess(Double.parseDouble(new DecimalFormat("0.0").format(rs.getDouble("avg_bookassess"))));//定义平均评分为一位小数
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
		
		return new_book;
	}

	@Override
	public int BookInsert(Book book) {
		
		String sql = "insert into book (bookid,expertid,studentid,bookdate,meetdate,meetaddress,bookstate,bookintroduce) values "
				+ "(?,?,?,?,?,?,?,?)";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookid());
			pstmt.setString(2, book.getExpertid());
			pstmt.setString(3, book.getStudentid());
			pstmt.setString(4, book.getBookdate());
			pstmt.setString(5, book.getMeetdate());
			pstmt.setString(6, book.getMeetaddress());
			pstmt.setInt(7, book.getBookstate());
			pstmt.setString(8, book.getBookintroduce());
			
			effectRow = pstmt.executeUpdate();
			System.out.println(effectRow);
			if(effectRow != 1){
				System.out.println("添加预约失败！");
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
	public List<Book> BookSelectForStudentBookList(Book book) {
		
		String sql = "select bookid,expert.expertid,expertname,student.studentid,bookdate,meetdate,meetaddress,bookstate,bookintroduce,bookassess "
				+ "from book,expert,student "
				+ "where expert.expertid=book.expertid and student.studentid=book.studentid "
				+ "and student.studentid=? "
				+ "order by bookdate desc";
		int order = 0;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		books = new ArrayList<Book>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, book.getStudentid());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				order = order + 1;
				new_book = new Book();
				new_book.setBookid(rs.getString("bookid"));
				new_book.setOrder(order);
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setStudentid(rs.getString("studentid"));
				new_book.setExpertname(rs.getString("expertname"));
				String bookdate = rs.getString("bookdate");
				//处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date bd = dateFormat1.parse(bookdate);
					bookdate = dateFormat2.format(bd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_book.setBookdate(bookdate);
				new_book.setMeetdate(rs.getString("meetdate"));
				new_book.setMeetaddress(rs.getString("meetaddress"));
				new_book.setBookstate(rs.getInt("bookstate"));
				new_book.setBookintroduce(rs.getString("bookintroduce"));
				new_book.setBookassess(rs.getInt("bookassess"));
				books.add(new_book);
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
		
		return books;
	}

	@Override
	public int BookDelete(Book book) {

		String sql = "delete from book where bookid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("删除预约失败！");
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
	public int BookUpdateAssessForStudent(Book book) {
		
		String sql = "update book set bookassess=?,bookstate=? where bookid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, book.getBookassess());
			pstmt.setInt(2, 4);
			pstmt.setString(3, book.getBookid());
			
			effectRow = pstmt.executeUpdate();
			
			if(effectRow != 1){
				System.out.println("修改评分失败！");
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
	public List<Book> BookSelectForExpertBookList(Book book) {
		
		String sql = "select bookid,expert.expertid,student.studentid,studentname,studentphone,bookdate,meetdate,meetaddress,bookstate,bookintroduce,bookassess "
				+ "from book,expert,student "
				+ "where expert.expertid=book.expertid and student.studentid=book.studentid "
				+ "and expert.expertid=? "
				+ "order by bookdate desc";
		int order = 0;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		books = new ArrayList<Book>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, book.getExpertid());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				order = order + 1;
				new_book = new Book();
				new_book.setBookid(rs.getString("bookid"));
				new_book.setOrder(order);
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setStudentid(rs.getString("studentid"));
				new_book.setStudentname(rs.getString("studentname"));
				new_book.setStudentphone(rs.getString("studentphone"));
				String bookdate = rs.getString("bookdate");
				//处理时间在特定格式，例如2018/06/13 18:00:00
				try {
					Date bd = dateFormat1.parse(bookdate);
					bookdate = dateFormat2.format(bd);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new_book.setBookdate(bookdate);
				new_book.setMeetdate(rs.getString("meetdate"));
				new_book.setMeetaddress(rs.getString("meetaddress"));
				new_book.setBookstate(rs.getInt("bookstate"));
				new_book.setBookintroduce(rs.getString("bookintroduce"));
				new_book.setBookassess(rs.getInt("bookassess"));
				books.add(new_book);
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
		
		return books;
	}

	@Override
	public int BookUpdateForBookFinish(Book book) {
		
		String sql = "update book set bookstate=? where bookid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, 3);
			pstmt.setString(2, book.getBookid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("修改预约状态位失败！");
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
	public int BookUpdateForBookAccept(Book book) {
		
		String sql = "update book set bookstate=?,bookintroduce=? where bookid=?";
		int effectRow;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, book.getBookstate());
			pstmt.setString(2, book.getBookintroduce());
			pstmt.setString(3, book.getBookid());
			
			effectRow = pstmt.executeUpdate();
			if(effectRow != 1){
				System.out.println("接受预约失败！");
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
	public List<Book> BookSelectForShowHomepage() {
		
		String sql = "select expert.expertid,expertname,expertimage,expertoccupation,avg(bookassess) avg_bookassess,count(studentid) count_book "
				+ "from book right join expert on expert.expertid=book.expertid "
				+ "group by expert.expertid,expertname,expertoccupation,expertprice,expertintroduce,experttype";
		books = new ArrayList<Book>();
		int count = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				count = count + 1;
				if(count > 4){//主页面只显示4条
					break;
				}
				new_book = new Book();
				new_book.setOrder(count);
				new_book.setExpertid(rs.getString("expertid"));
				new_book.setExpertname(rs.getString("expertname"));
				new_book.setExpertoccupation(rs.getString("expertoccupation"));
				new_book.setExpertimage(rs.getString("expertimage") == null ? "images/kong.jpg" : rs.getString("expertimage"));
				new_book.setAvg_bookassess(Double.parseDouble(new DecimalFormat("0.0").format(rs.getDouble("avg_bookassess"))));//定义平均评分为一位小数
				new_book.setCount_book(rs.getInt("count_book"));
				books.add(new_book);
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
		
		return books;
	}

}
