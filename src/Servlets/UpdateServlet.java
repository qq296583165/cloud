package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserIInformation;
import Tool.DBconnection;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String id = (String) session.getAttribute("id");
		String pass =request.getParameter("pass");
		String tel =request.getParameter("tel");
		String  sex = request.getParameter("sex");
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(pass);
		System.out.println(tel);
		System.out.println(sex);
		
		String cla = (String) session.getAttribute("cla");
		//
		Connection conn = DBconnection.getConn();
		String sql = null;
		switch(cla) {
		case "0":
			sql = "update Student set stuName='"+name +"' ,stuPassWord = '"+pass+"',stuTel ='"+tel+"', stuSex='"+sex+"' where stuId= '"+id+"'" ;
			break;
		case "1":
			sql="update Teacher set tecName='"+name+"',tecPassWord='"+pass+"',tecTel='"+tel+"',tecSex='"+sex+"' where tecId = '"+id+"'";
			break;
		case"2":
			sql="update Manager set managerName='"+name+"',managerPassWord='"+pass+"',managerTel='"+tel+"',managerSex='"+sex+"' where managerId='"+id+"'";
			break;
		}
		//
		try {
			PreparedStatement prStatement = conn.prepareStatement(sql);
			prStatement.execute(sql);
			String message="修改成功";
			request.setAttribute("message", message);
			session.setAttribute("userInfo",new UserIInformation(name, id, pass, tel, sex));
			session.setAttribute("name", name);
			session.setAttribute("id", id);
			session.setAttribute("cla", cla);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.getRequestDispatcher("WEB-INF/Pages/UserCenter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
