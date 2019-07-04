package update;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class staff_add_medium
 */
@WebServlet("/staff_add_medium")
public class staff_add_medium extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staff_add_medium() {
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

		doGet(request, response);
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String q=request.getParameter("q");  
		String a=request.getParameter("a");  
		String b=request.getParameter("b");
		String c=request.getParameter("c");  
		String d=request.getParameter("d");  
		String answer=request.getParameter("ans");  
		  
		          
		try{  
			Class.forName("com.mysql.jdbc.Driver");
 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "mysql");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into easy values(?,?,?,?,?,?,?)");  
		ps.setString(1,null);  
		ps.setString(2,q);  
		ps.setString(3,a);  
		ps.setString(4,b); 
		ps.setString(5,c); 
		ps.setString(6,d); 
		ps.setString(7,answer); 
	
		          
		int i=ps.executeUpdate();  
		if(i>0)  
			response.sendRedirect("success.jsp");
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
		  
		}  
