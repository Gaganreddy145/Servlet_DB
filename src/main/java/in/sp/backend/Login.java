package in.sp.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		try {
			Connection conn = DbConnection.getConnection();
			String uname = request.getParameter("uname");
			String dept = request.getParameter("dept");
			String s = "select * from users where uname = ? and dept = ?";
			PreparedStatement ps = conn.prepareStatement(s);
			ps.setString(1, uname);
			ps.setString(2, dept);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (uname.equals(rs.getString(2)) && dept.equals(rs.getString(3))) {
					HttpSession hs = request.getSession();
					RequestDispatcher rd = request.getRequestDispatcher("myprofile.jsp");
					hs.setAttribute("uname", uname);
					hs.setAttribute("dept", dept);
					rd.forward(request, response);
				} 
			} else {
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.print("<h3>Incorrect credentials</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
