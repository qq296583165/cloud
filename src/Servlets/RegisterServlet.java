package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoginRegister.Register;

import java.sql.Connection;
import Tool.DBconnection;



@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {}
    
    protected boolean isNumber(int n ,String s) {
//    	for(int i =0; i<n;i++) {
//    		if(s.charAt(i))
//    	}
//    	
    	return false; 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据

		String name =request.getParameter("userName");
		String  id =request.getParameter("userId");
		String  pass = request.getParameter("password");
		String  tel =request.getParameter("userTel");
		String sex = request.getParameter("sex");
		String cla =request.getParameter("cla");
		//初次判断
//		if(id.length()>=6&&pass.length()>=8) {
//			
//		}else {
//			
//		}
		
		//获取数据库链接
		Connection conn = (Connection) DBconnection.getConn();
		
		//判断
		if(new Register().register(name,pass,id,tel,sex, cla,conn).equals("1")) {
			//成功 存入session
			HttpSession session = request.getSession();
			session.setAttribute("pass", pass);
			session.setAttribute("id", id);
			session.setAttribute("cla", cla);
			session.setAttribute("name", name);
			session.setAttribute("flag", "1");
			//重定向
			request.getRequestDispatcher("HeadPage.jsp").forward(request, response); 
		}else {
			String message="您的输入有误，请重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
