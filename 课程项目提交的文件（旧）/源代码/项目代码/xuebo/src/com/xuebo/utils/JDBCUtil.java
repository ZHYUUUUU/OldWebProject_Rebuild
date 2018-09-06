package com.xuebo.utils;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.xuebo.utils.JDBCUtil;

public class JDBCUtil {

	private static Properties prop = null;
	
	static{
		
		try {
			InputStream is = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
			
			prop = new Properties();
			
			prop.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//饿汉式（线程安全）
	private JDBCUtil jdbcUtil = new JDBCUtil();
	
	//构造方法私有化，防止外部创建该对象
	private JDBCUtil(){
		
	}
	
	public JDBCUtil getInstance(){
		
		return jdbcUtil;
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pwd = prop.getProperty("pwd");

		Connection conn = null;
		Class.forName(driver);

		conn = (Connection) DriverManager.getConnection(url, user, pwd);
		
		return conn;
		
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException{
		
		if (null != rs) {
			rs.close();
		}

		if (null != stmt) {
			stmt.close();
		}

		if (null != conn) {
			conn.close();
		}
		System.out.println(conn+" closeAll");
		
	}
	
}
