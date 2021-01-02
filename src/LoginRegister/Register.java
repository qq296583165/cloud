package LoginRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {
	private PreparedStatement psStatement =null;
	String sql;
	public String register(String name,String  pass,String  id,String tel ,String  sex,String cla,Connection conn) {
		switch(cla) {
		case "0" ://student
			sql="insert into Student (stuName ,stuPassWord,stuId,stuTel,stuSex) values (?,?,?,?,?)";
			break;
		case "1"://teacher
			sql="insert into Teacher (tecName ,tecPassWord,tecId,tecTel,tecSex) values (?,?,?,?,?)";
			break;
		}
		try {
			psStatement=conn.prepareStatement(sql);
			psStatement.setString(1, name);
			psStatement.setString(2, pass);
			psStatement.setString(3, id);
			psStatement.setString(4, tel);
			psStatement.setString(5, sex);
			psStatement.execute();	
			return "1";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return "0";
		}
	}
}
