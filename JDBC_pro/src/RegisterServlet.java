

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String name=request.getParameter("t1");
		String pssd=request.getParameter("t2");
		String email=request.getParameter("t3");
		String country=request.getParameter("c1");
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=");
			Statement stm=con.createStatement();
			stm.executeUpdate("insert into register values ('"+name+"','"+pssd+"','"+email+"','"+country+"')");
			
			PrintWriter pw=response.getWriter();
			pw.println("Successfully registered");
			pw.println("<a href='Login.html'>Click Here</a>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
