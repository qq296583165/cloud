package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.DBconnection;

/**
 * Servlet implementation class AddIntoCourse
 */
@WebServlet("/AddIntoCourseServlet")
public class AddIntoCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddIntoCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String message = null;
		String sql = null;
		ResultSet rs= null;
		Statement prStatement  = null;
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");
		System.out.println(userId);
		//
		Connection conn = DBconnection.getConn();
		//
		sql="select courseId from Course where courseId = '"+id+"'";
		try {
			prStatement = conn.createStatement();
			rs=prStatement.executeQuery(sql);
			if(rs.next()) {
				sql="insert into StuCourse(courseId,studentId) values('"+id+"','"+userId+"')";
				prStatement=conn.createStatement();
				if(!prStatement.execute(sql)) {
					message = "添加成功！";
				}else {
					message = "已加入！";
				}
			}else {
				message = "无此课程，请重新输入！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("WEB-INF/Pages/AddIntoCoursePage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
