package com.authentication;

import java.io.IOException;
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student_reg
 */
@WebServlet("/Student_reg")
public class Student_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_reg() {
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
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("userName");  
		String p=request.getParameter("userPass");  
		String e=request.getParameter("userEmail");  
		  
		          
		try{  
			Class.forName("com.mysql.jdbc.Driver");
 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "mysql");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into st_reg values(?,?,?,?,?,?,?)");  
		ps.setString(1,null);  
		ps.setString(2,n);  
		ps.setString(3,p);  
		ps.setString(4,e);  
		ps.setString(5,"no result found");  
		ps.setString(6,"take test first"); 
		ps.setString(7,"take test first"); 
		          
		int i=ps.executeUpdate();  
		if(i>0)  
			  response.sendRedirect("success.jsp"); 
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
		  
		}  
