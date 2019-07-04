package verification;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class easy_ver
 */
@WebServlet("/easy_ver")
public class easy_ver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public easy_ver() {
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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String q = request.getParameter("q");
		
		
		
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(q);
		int num = 0;
		int status=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "mysql");  
			
			String query = "select max(id) from easy";
			
		PreparedStatement ps = c.prepareStatement(query);


	    ResultSet rs = ps.executeQuery();
	    
	    rs.next();
	    int myMaxId = rs.getInt(1);
	    num = myMaxId;
	

	    while(rs.next()) {
	    	
	    	 
	    
	    }
		}catch(Exception e)
		{
			System.out.println("error in getting maximum id");
		}
		
		
		ArrayList ar = new ArrayList();
		ArrayList al = new ArrayList();
		int mark=0;
		for(int i=1 ; i<=num;i++)
		{
			
		String select = request.getParameter("radio"+i) ;
		System.out.println(select);

      ar.add(select);
	}
System.out.println(ar);
try {
	Class.forName("com.mysql.jdbc.Driver");
//loads driver
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "mysql");  
	
		String query = "select * from easy ";
		
	PreparedStatement ps = c.prepareStatement(query);


    ResultSet rs = ps.executeQuery();
    
 

    while(rs.next()) {
    	
    	   al.add(rs.getString("answer"));
    
    }
    
	System.out.println(al);
	for(int k=0;k<al.size();k++)
	{
String	cr_an=(String) al.get(k);
String	se_an=(String) ar.get(k);
	if(cr_an.equals(se_an))
	{
	mark=mark+1;	
	}
	else
	{
		mark=mark;
	}
	}
	System.out.println(mark);
	
    System.out.println(num);
    
    
    if(mark>=(num/2)&&mark<=(num))
    {
    	status = status+1;
    }
    else
    {
    	status=status;
    }
    System.out.println(status);
    
    request.setAttribute("id",name);
    
    String Driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/quiz";
    String uName ="root";
    String pwd = "mysql";
    Connection conn=null;
     
    try {
    Class.forName(Driver).newInstance();
    conn = DriverManager.getConnection(url, uName, pwd);
    Statement stmt = conn.createStatement();
    String sql = "UPDATE st_reg SET mark="+mark+" where id="+id+" ";
    String sql1 = "UPDATE st_reg SET status="+status+" where id="+id+" ";
    String sql2 = "UPDATE st_reg SET q_status="+q+" where id="+id+" ";
    stmt.executeUpdate(sql);
    stmt.executeUpdate(sql1);
    stmt.executeUpdate(sql2);
  
    System.out.println("Data update sucessfully");
     
    } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    finally{
    try {
    conn.close();
    } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }
  
    
	
    request.setAttribute("ErrorMessage", name);
    request.setAttribute("ErrorMessage1", mark);
 String errorMsg=(String)request.getAttribute("ErrorMessage");
 int errorMsg1=(Integer)request.getAttribute("ErrorMessage1");
  RequestDispatcher dispatcher =  request.getRequestDispatcher("result_easy.jsp");
  dispatcher.forward(request, response);
    
    return;
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
}

}
}
