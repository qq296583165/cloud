package Servlets;

import Service.Course;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ShowCourseServlet
 */
@WebServlet("/ShowCourseServlet")
public class ShowCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id= (String) session.getAttribute("id");
		String cla = (String) session.getAttribute("cla");
		
		String message=null;
		 List<Course> course = new ArrayList<>() ; 
		 session.setAttribute("ShowCourse",course);
		 
		if(id==null&&cla==null) {
			message="请先登录！";
			request.setAttribute("message", message);
		}
		else {
			//
			Connection conn = (Connection) DBconnection.getConn();
			//
			String sql = null ;
			 switch(cla) {
			 case "0":
				 sql="select Course.courseName,Teacher.tecName,Course.courseId from StuCourse,Course ,Teacher  where StuCourse.studentId= ? and StuCourse.courseId=Course.courseId and Course.teacherId = Teacher.tecId";
				 break;
			 case"1":
				 sql="select Course.courseName,Teacher.tecName,Course.courseId from Course ,Teacher  where Course.teacherId=Teacher.tecId and Teacher.tecId= ?";
				 break;
			 case"2":
				 sql="select Course.courseName,Teacher.tecName,Course.courseId from Course,Teacher where Course.teacherId = Teacher.tecId ";
				 break;
			 }
			//
			 PreparedStatement ptStatement = null;
			 ResultSet rs=null;
			 //
			 try {
				ptStatement = conn.prepareStatement(sql);
				if(!cla.equals("2")) {
					ptStatement.setString(1, id);
				}
				rs = ptStatement.executeQuery();
				
				while(rs.next()) {
					course.add(new Course(rs.getString(1), rs.getString(2),rs.getString(3)));
				}
				//存
				session.setAttribute("ShowCourse",course);
				if(course.isEmpty()) {
					message="暂无课程！";
					request.setAttribute("message", message);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("WEB-INF/Pages/MyCoursePage.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
