package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tool.DBconnection;

/**
 * Servlet implementation class InsertCourseServlet
 */
@WebServlet("/InsertCourseServlet")
public class InsertCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String tecId=request.getParameter("tecId");
		int count=0;
		//
		Connection conn= DBconnection.getConn();
		//count
		String sql1= "select courseName  from Course ";
		String sql3="select tecId from Teacher where tecId =?";
		PreparedStatement prStatement=null;
		ResultSet rs=null;
		String message=null;
		//
		try {
			prStatement = conn.prepareStatement(sql1);
			rs=prStatement.executeQuery();
			while(rs.next()) {
				count++;
			}
			count++;
			String sql2="insert into Course(courseId,courseName,teacherId)values('"+count+"','"+name+"','"+tecId+"')";
			prStatement=conn.prepareStatement(sql3);
			prStatement.setString(1, tecId);
			rs=prStatement.executeQuery();
			if(rs.next()) {
				prStatement=conn.prepareStatement(sql2);
				prStatement.execute(sql2);
				message = "添加成功！课程号为"+count;
			}
			else {
				message="教师账号输入有误，请重新输入！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message="输入有误，请重新输入！";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("WEB-INF/Pages/InsertCoursePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
