package com.share.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DBUtil
 * @Author weijian
 * @Date 2022/4/24
 */
public class DBUtil {

	private static final String URL = "jdbc:mysql://116.62.223.130:3306/mybatis-test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true&useSSL=false&serverTimezone=Hongkong&allowMultiQueries=true";
	private static final String NAME = "root";
	private static final String PASSWORD = "Wj@123..*";

	private static Map<String, Execute> executeMap = new HashMap<>();

	private DBUtil() {
	}

	static {
		executeMap.put("insert", new InsertExecute());
		executeMap.put("select", new SelectExecute());
	}

	public static Connection getConn() {
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库的连接
			Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object execute(String sql, Object o, String method) {
		try {
			Execute execute = getExecute(method);
			return execute.execute(sql, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Execute getExecute(String method) {
		return executeMap.get(method);
	}
}
