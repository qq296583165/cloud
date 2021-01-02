package Servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoginRegister.Login;
import Tool.DBconnection;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数

		String  id =request.getParameter("userId") ;
		String pass= request.getParameter("password");
		String cla =request.getParameter("cla");
		//获取
		Connection conn = (Connection) DBconnection.getConn();
		HttpSession session = request.getSession();
		//判断
		if(new Login().log(pass,id, cla,conn)!=null) {
			//正确 存入session
			
			session.setAttribute("id", id);
			session.setAttribute("pass", pass);
			session.setAttribute("cla", cla);
			session.setAttribute("name", new Login().log(pass,id, cla,conn));
			session.setAttribute("flag", "1");
			//重定向
			request.getRequestDispatcher("HeadPage.jsp").forward(request, response);
		}
		else {
			String message="您的输入有误，请重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
