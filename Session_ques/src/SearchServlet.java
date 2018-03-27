

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServlet
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u=request.getParameter("t1");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		HttpSession ses=request.getSession();
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=");
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from register where Name like '%"+u+"%'");
		
			if(rs.next())
			{
				String user=rs.getString(1);
				ses.setAttribute("uname", user);
				pw.println("Name list : "+"<a href='Details'>"+rs.getString(1)+"</a>"+"\n");
			while(rs.next())
			{
				pw.println("\n"+"<a href='Details?user="+u+"'>"+ rs.getString(1)+"</a>"+"\n");
			}
			
			}
			else
			{
			
			pw.println("NO USER FOUND.....");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
