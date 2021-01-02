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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class studentInfo
 */
@WebServlet("/studentInfo")
public class studentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id= request.getParameter("id");
		String  cid = request.getParameter("courseId");
		String cname = request.getParameter("cname");
		String sql= "select * from Student where stuId='"+id+"'";
		Connection conn= DBconnection.getConn();
		ResultSet rs= null;
		HttpSession session = request.getSession();
		session.setAttribute("coursename", cname);
		session.setAttribute("cid", cid);
		
		try {
			Statement st = conn.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()) {
				session.setAttribute("student", new UserIInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
			sql="select Grade from StuCourse where courseId='"+cid+"'and studentId='"+id+"'";
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				session.setAttribute("Grade", rs.getString(1));
			}
			
//			request.getRequestDispatcher("WEB-INF/Pages/StuInfoPage.jsp").forward(request, response);
			
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
