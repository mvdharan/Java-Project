package update;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class staff_up_hard
 */
@WebServlet("/staff_up_hard")
public class staff_up_hard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staff_up_hard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		   
		String q = request.getParameter("q");
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String c = request.getParameter("c");
		String d = request.getParameter("d");
		String answer = request.getParameter("ans");
		String id = request.getParameter("id");
		
		
		 try
		    {
		      // create a java mysql database connection
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/quiz";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "mysql");
		    
		      // create the java mysql update preparedstatement
		      String query = "update hard set qustions = ? where id = "+id+"";
		      String query1 = "update hard set QA = ? where id = "+id+"";
		      String query2 = "update hard set QB = ? where id = "+id+"";
		      String query3 = "update hard set QC = ? where id = "+id+"";
		      String query4 = "update hard set QD = ? where id = "+id+"";
		      String query5 = "update hard set answer = ? where id = "+id+"";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      PreparedStatement preparedStmt1 = conn.prepareStatement(query1);
		      PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
		      PreparedStatement preparedStmt3 = conn.prepareStatement(query3);
		      PreparedStatement preparedStmt4 = conn.prepareStatement(query4);
		      PreparedStatement preparedStmt5 = conn.prepareStatement(query5);
		      preparedStmt.setString   (1, q);
		      preparedStmt1.setString   (1, a);
		      preparedStmt2.setString   (1, b);
		      preparedStmt3.setString   (1, c);
		      preparedStmt4.setString   (1, d);
		      preparedStmt5.setString   (1, answer);
		 

		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      preparedStmt1.executeUpdate();
		      preparedStmt2.executeUpdate();
		      preparedStmt3.executeUpdate();
		      preparedStmt4.executeUpdate();
		      preparedStmt5.executeUpdate();
		      
		   
		      
		      int i=preparedStmt5.executeUpdate();  
				if(i>0)
					response.sendRedirect("success.jsp"); 
				   conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
	}}