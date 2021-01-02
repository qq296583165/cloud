package LoginRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {
	private PreparedStatement ptStatement = null;
	String sql;
	public String log(String pass, String id,String cla, Connection conn) {
		//sql
		switch (cla) {
		case "0":
			sql = "select stuId,stuPassWord,stuName from Student where stuId=? and stuPassWord=?";
			break;
		case "1":
			sql = "select tecId,tecPassWord,tecName from Teacher where tecId=? and tecPassWord=?";
			break;
		case "2":
			sql = "select managerId,managerPassWord,managerName from Manager where managerId=? and managerPassWord=?";
			break;
		default:
			break;
		}
		//
		ResultSet rs=null;
		try {
			ptStatement = conn.prepareStatement(sql);
			ptStatement.setString(1, id);
			ptStatement.setString(2, pass);
			rs = ptStatement.executeQuery();
			if (rs.next()) {
				//获得用户登录信息
				return rs.getString(3);
			} else {
			return null;
			}
		} catch (SQLException e) {	
			e.printStackTrace();
			return null;
		}
	}	
}
