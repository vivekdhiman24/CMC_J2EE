

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Answer
 */
@WebServlet("/Answer")
public class Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answer() {
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

		String a=request.getParameter("r1");
		String b=request.getParameter("r2");
		String c=request.getParameter("r3");
		String an1=request.getParameter("1");
		String an2=request.getParameter("2");
		String an3=request.getParameter("3");
	
		int score = 0;
		
		if(an1.equals(a))
			score++;
		if(an2.equals(b))
			score++;
		if(an3.equals(c))
			score++;
		
		response.setContentType("text/html");
		PrintWriter pt=response.getWriter();
		pt.println("Your score : "+ score);
		pt.println("<br><br><a href='quiz.html'>PLAY AGAIN</a>");
	}

}
