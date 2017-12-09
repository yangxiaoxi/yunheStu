package cn.yunhe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class JDBCutil {
	private static Connection conn = null;
	private static ResultSet cursor = null;
	private static PreparedStatement prSate = null;
	private static DataSource ds=null;
	static{
		
		try {
			Context c = new InitialContext();
			ds = (DataSource) c.lookup("java:comp/env/jdbc/yunhe");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 连接数据库
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void connection() throws ClassNotFoundException, SQLException {
		conn = ds.getConnection();
	}

	 
	/**
	 * @param sql        外部传入需要执行的sql语句
	 * @param obj        传入sql语句中参数列表
	 * @return           返回影响行数
	 * @throws SQLException
	 */
	public static int update(String sql,Object[] obj) throws SQLException {
		prSate = conn.prepareStatement(sql);
		if(obj!=null){
			for (int i = 0; i < obj.length; i++) {
				prSate.setObject(i+1, obj[i]);
			}
		}
		
		int result = prSate.executeUpdate();
		return result;
	}
	 
	/** 
	 * @param sql 外部传入需要执行的sql语句
	 * @param obj   传入sql语句中参数列表
	 * @return    返回查询到的结果集
	 * @throws SQLException
	 */
	public static ResultSet query(String sql,Object[] obj) throws SQLException {
		prSate = conn.prepareStatement(sql);
		if(obj!=null){
			for (int i = 0; i < obj.length; i++) {
				prSate.setObject(i+1, obj[i]);
			}
		}
		cursor = prSate.executeQuery();
		return cursor;
	}

	/**
	 * 释放资源
	 * 
	 * @throws SQLException
	 */
	public static void closeSource() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
		if (prSate != null) {
			prSate.close();
			prSate = null;
		}
		if (cursor != null) {
			cursor.close();
			cursor = null;
		}
	}

}
