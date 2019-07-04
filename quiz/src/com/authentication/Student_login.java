package com.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student_login
 */
@WebServlet("/Student_login")
public class Student_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_login() {
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
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String un = request.getParameter("username");
        String pw = request.getParameter("password");
      
        request.setAttribute("myname",un);
     

// Connect to mysql(mariadb) and verify username password

        try {
    		Class.forName("com.mysql.jdbc.Driver");
// loads driver
    		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "mysql");  
    		
            PreparedStatement ps = c.prepareStatement("select name,password,id from st_reg where name=? and password=?");
            ps.setString(1, un);
            ps.setString(2, pw);
   
         
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String v =rs.getString("id");
                System.out.println(v);
                request.setAttribute("id",v);
                request.getRequestDispatcher("select.jsp").forward(request, response); 
                response.sendRedirect("select.jsp");
                return;
            }
            request.setAttribute("ErrorMessage", "please enter correct username and password");
//          String errorMsg=(String)request.getAttribute("ErrorMessage");
          RequestDispatcher dispatcher =  request.getRequestDispatcher("error.jsp");
          dispatcher.forward(request, response);
            
            return;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
    }

}