package com.bookstore.dao;

import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.bookstore.util.JDBCUtils;


public class BaseDao<T> {
	// 鏁版嵁搴撹闂搷浣�
	private static final String URL = "jdbc:mysql://192.168.106.138:3306/bookstore?characterEncoding=utf-8";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // 加载驱动
    static{
        boolean result = DbUtils.loadDriver(DRIVER);
        if (result == false) {
            try {
                throw new SQLException("加载驱动失败");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 创建连接
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
	/**
	 * 杩斿洖鍗曚釜瀵硅薄
	 * @param <T>
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 *            濡傛灉娌℃湁鍙傛暟灏辫涓� Object[] params={}
	 * @return
	 */
	public <T> T get(String sql, Class<T> clazz, Object[] params) {
		T obj = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			obj = qRunner.query(conn, sql, new BeanHandler<T>(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	/**
	 * 杩斿洖鍗曚釜瀵硅薄 浜嬪姟鎿嶄綔
	 * @param <T>
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 *            濡傛灉娌℃湁鍙傛暟灏辫涓� Object[] params={}
	 * @return
	 */
	public <T> T get(Connection conn,String sql, Class<T> clazz, Object[] params) throws SQLException {
		     T obj = null;
			QueryRunner qRunner = new QueryRunner();
			obj = qRunner.query(conn, sql, new BeanHandler<T>(clazz), params);		
		    return obj;
	}

	/**
	 * 杩斿洖澶氫釜瀵硅薄
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 *            濡傛灉娌℃湁鍙傛暟灏辫涓� Object[] params={}
	 * @return
	 */
	public <T> List<T> query(String sql, Class<T> clazz, Object[] params) {
		List beans = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			beans = (List) qRunner.query(conn, sql, new BeanListHandler<T>(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 杩斿洖澧炲垹鏀规槸鍚︽垚鍔�
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean update(String sql, Object[] params) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			int i = qRunner.update(conn, sql, params);
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
    /**
     * 闇�瑕佽繘琛屼簨鍔℃搷浣滄椂锛屽湪鍚屼竴浜嬪姟绠＄悊涓嬫搷浣�
     * @param conn
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
	public boolean update(Connection conn, String sql, Object[] params) throws SQLException {
		boolean flag = false;
		QueryRunner qRunner = new QueryRunner();
		int i = qRunner.update(conn, sql, params);
		if (i > 0) {
			flag = true;
		}
		return flag;
	}

	/***
	 * 鎵归噺鎿嶄綔锛岄渶瑕佺敤鍒颁簨鍔�
	 * 
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean batchUpdate(Connection conn, String sql, Object[][] params) throws SQLException {
		QueryRunner qRunner = new QueryRunner();
		int result = 0;
		boolean flag = false;
		result = qRunner.batch(conn, sql, params).length;
		if (result > 0) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 杩斿洖缁熻鍗曞��,
	 * @param sql
	 * @param params
	 * @return
	 */
	public long getCount(String sql,Object[] params){
		long count =0L;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			count  = (long) qRunner.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 杩斿洖涓婚敭,閫氬父鏄墽琛宨nsert璇彞鏃惰繑鍥炲綋鍓嶇殑涓婚敭鍊�
	 * @param sql
	 * @param params
	 * @return
	 */
    public Long getCurrentKey(String sql,Object[] params){
    	Connection conn = null;
		Long key = 0l;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			key = (long) qRunner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
    }
}
