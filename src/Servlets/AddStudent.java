package Servlets;

import Tool.DBconnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String message=null;
		String cid = (String) session.getAttribute("cid");
		String sid = request.getParameter("id");
		String sql1 = "select stuId from Student where stuId='"+sid+"'";
		String sql ="insert into StuCourse(ourseId,studentIcd) values('"+cid+"','"+sid+"')";
		Connection conn= DBconnection.getConn();
		try {
			Statement st = conn.createStatement();

				if(st.execute(sql1)) {
					if(!st.execute(sql)) {
						message="添加成功！";
					}
				}

			else {
				message="无此学生！";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message="学生已存在！";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("WEB-INF/Pages/AddStudentPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
