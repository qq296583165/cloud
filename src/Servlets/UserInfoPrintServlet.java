package Servlets;

import Service.UserIInformation;
import Tool.DBconnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class InfoPrintServlet
 */
@WebServlet("/UserInfoPrintServlet")
public class UserInfoPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoPrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//

		HttpSession session =request.getSession();
		//
		String  id = (String) session.getAttribute("id");
		String cla = (String) session.getAttribute("cla");
		String pass = (String )session.getAttribute("pass");
		//
		String message=null;
		if(id==null) {
			message="请先登录！";
			request.setAttribute("message", message);
		}else {
			Connection conn = DBconnection.getConn();
			//
			String  sql = null;
			PreparedStatement prStatement = null;
			ResultSet rs = null;
			//
			switch(cla) {
			case "0":
				sql= "select * from Student WHERE stuId = ?";
				break;
			case"1":
				sql="select * from Teacher  WHERE tecId = ?";
				break;
			case"2":
				sql="select *from Manager WHERE managerId = ?";
				break;
			}
			//
			try {
				prStatement = conn.prepareStatement(sql);
				prStatement.setObject(1,session.getAttribute("id"));
				rs = prStatement.executeQuery();

				if (rs.next()) {
					session.setAttribute("userInfo", new UserIInformation(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("WEB-INF/Pages/UserCenter.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
