package Tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	// 连接数据库
	private static Connection conn = null;
	
//获取
	public static void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseSupSystem?characterEncoding=utf8", "root" , "cyq990710");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		if(conn == null)
			getConnection();
		return conn;
	}
}
