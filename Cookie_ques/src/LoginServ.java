

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String u=request.getParameter("t1");
		String p=request.getParameter("t2");
		RequestDispatcher rd=null;
		PrintWriter pt=response.getWriter();
		
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=");
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from register where (Name='"+u+"' and Pass='"+p+"')");
			
		if(rs.next())
		{
			Cookie ck1=new Cookie("username", u);
			response.addCookie(ck1);
			Cookie ck2=new Cookie("password", p);
			response.addCookie(ck2);
	        pt.println("cookies created");
		    pt.println("<a href='Profile'>Next</a><br><br>");
	   }
		else
		{
			pt.printf("INVALID DETAILS.........");
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
