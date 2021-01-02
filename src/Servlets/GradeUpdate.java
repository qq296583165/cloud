package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserIInformation;
import Tool.DBconnection;

/**
 * Servlet implementation class GradeUpdate
 */
@WebServlet("/GradeUpdate")
public class GradeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String grade=request.getParameter("grade");
		String pass=request.getParameter("pass");
		System.out.println(grade);
		String message = null;
		HttpSession session=request.getSession();
		UserIInformation student = (UserIInformation) session.getAttribute("student");
		String cid = (String) session.getAttribute("cid");
		String sql1 = "update Student set stuPassWord='"+pass+"' where stuId='"+student.getId()+"'";
		String sql2 ="update StuCourse set Grade='"+grade+"'  where studentId='"+student.getId()+"' and courseId='"+cid+"'";
		Connection conn =DBconnection.getConn();
		try {
			Statement st = conn.createStatement();
			if(!st.execute(sql1)&&!st.execute(sql2)) {
				student.setPass(pass);
				session.setAttribute("Grade", grade);
				session.setAttribute("student", student);
				message = "修改成功！";
			}else {
				message="输入有误！";
			}
			request.getRequestDispatcher("WEB-INF/Pages/StuInfoPage.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}