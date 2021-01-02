package Servlets;

import Service.Course;
import Service.UserIInformation;
import Tool.DBconnection;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class CourseInfoPrintServlet
 */
@WebServlet("/CourseInfoPrintServlet")
public class CourseInfoPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseInfoPrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		//
		String id =request.getParameter("id");//course
		String userId= (String) session.getAttribute("id");
		String cla = (String) session.getAttribute("cla");

		//
		Connection conn =DBconnection.getConn();
		//基本信息
		String sql="select Course.courseName,Teacher.tecName from Course,Teacher where Teacher.tecId = Course.teacherId and Course.courseId = ?" ;
		ResultSet rs= null;
		PreparedStatement prStatement=null;
		List<String> source=new ArrayList<String>();
		List< UserIInformation> students = new ArrayList<>();
		List< UserIInformation> teachers = new ArrayList<>();
		String cname =null;
		String tname = null;
		int grade = -1;
		//老师或管理员无成绩
		try {
			prStatement= conn.prepareStatement(sql);
			prStatement.setString(1, id);
			rs=prStatement.executeQuery();
			if(rs.next()) {
				cname=rs.getString(1);
				tname =rs.getString(2);
			}
			sql = "select source from CourseSource where courseId = '"+id+"'";//资源
			prStatement = conn.prepareStatement(sql);
			rs =prStatement.executeQuery();
			int i =0;
			while(rs.next()) {
				source.add(rs.getString(1));
			}
			
			//学生 查询成绩
			if(cla.equals("0")) {
				sql = "select Grade from StuCourse where studentId='"+userId+"'and courseId='"+id+"'";
				prStatement = conn.prepareStatement(sql);
				rs=prStatement.executeQuery();
				if(rs.next()) {
					grade=rs.getInt(1);
				}
				System.out.println(grade);
			}else if(cla.equals("1")) {//教师、管理员可以查看学生名单
				sql = "select Student.stuName,Student.stuId from StuCourse,Student where StuCourse.courseId = '"+id+"'and Student.stuId= StuCourse.studentId";
				prStatement = conn.prepareStatement(sql);
				rs=prStatement.executeQuery();
				while(rs.next()) {
					students.add(new UserIInformation(rs.getString(1),rs.getString(2)));
				}
			} else if(cla.equals("2")) {//管理员可以查看教师名单
				sql = "select teacher.tecName,teacher.tecId from teacher";
				prStatement = conn.prepareStatement(sql);
				rs=prStatement.executeQuery();
				while(rs.next()) {
					teachers.add(new UserIInformation(rs.getString(1),rs.getString(2)));
				}
			}
			session.setAttribute("cid", id);
			session.setAttribute("students",students);
			session.setAttribute("teachers",teachers);
			session.setAttribute("CourseInfo", new Course(cname, id, tname, grade, source));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("TeacherManagement.jsp");
		dispatcher.forward(request,response);


	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
