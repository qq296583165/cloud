package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Service.Course;
import Tool.DBconnection;
/**
 * Servlet implementation class HeadServlet
 */


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取参数
		String key = request. getParameter("keywords");
		//链接数据库
		Connection conn = (Connection) DBconnection.getConn();
		//联合查找
		String sql="select courseName,Teacher.tecName,Course.courseId from Course inner join Teacher on Course.teacherId = Teacher.tecId where  Course.courseId=?  or Teacher.tecName=? or Course.courseName like ? ";
		
		//
		ResultSet rs=null;
		PreparedStatement ptStatement = null;
		List<Course> course = new ArrayList<>();
		//读
		try {
			ptStatement = conn.prepareStatement(sql);
			ptStatement.setString(1, key);
			ptStatement.setString(2, key);
			ptStatement.setString(3, "%"+key+"%");
			rs = ptStatement.executeQuery();
				while(rs.next()) {
					course.add(new Course(rs.getString(1), rs.getString(2), rs.getString(3)));
				}
				//存
				HttpSession session = request.getSession();
				session.setAttribute("CourseList",course);
				if(course.isEmpty()) {
					String message="暂无搜索结果！";
					request.setAttribute("message", message);
				}
			request.getRequestDispatcher("WEB-INF/Pages/ResultPage.jsp").forward(request, response);//搜索结果页面
//			response.sendRedirect("JumpSerlevt?jump=lib/ResultPage.jsp");
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
