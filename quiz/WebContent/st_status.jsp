<!DOCTYPE html>
<html lang="en">
<head>

<body data-spy="scroll" data-target=".navbar-collapse" data-offset="50">

<style type="text/css" media="screen">
a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: red;
}
body{
background-color: #2b3f61;
}
</style>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="index.jsp"  >home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="staff_select.jsp"  >back</a>&nbsp


				
				<h1 style="text-align:center">STUDENT STATUS</h1>
				<%@ page import="java.sql.*" %>
	<% 
	String s=request.getParameter("Dname");
 try
   {
String sql="select * from st_reg";
Class.forName("com.mysql.jdbc.Driver");
		
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","mysql");
PreparedStatement pr= con.prepareStatement(sql);
ResultSet rs=pr.executeQuery();
%>

	

<table align="center"  border="2" width="90%" bgcolor="yellow">
<tr>
<th>ID NUMBER</th>
<th>NAME</th>

<th>E-MAIL</th>
<th>PERFORMANCE</th>
<th>MARKS</th>
<th>QUESTION TYPE</th>





</tr>
<% while(rs.next())
{
%>
<tr>
<td><p style="text-align:center"><%=(rs.getString(1))%></p></td>
<td><p style="text-align:center"><%=(rs.getString(2))%></p></td>
<td><p style="text-align:center"><%=(rs.getString(4))%></p></td>

<%String s1 = (rs.getString(5));
int i =1;
String status = "";

int ss1 = Integer.parseInt(s1);

if(ss1==i)
{
	status = "EXCELENT";
}
else
{
	status = "BAD";
}

%>

<td><p style="text-align:center"><%=status%></p></td>




<td><p style="text-align:center"><%=(rs.getString(6))%></p></td>

<% String q=(rs.getString(7));
String qs= "";
int j=1;
int k = 2;
int l = 3;
int qq=Integer.parseInt(q);
if(qq==j)
		{
	qs="ESAY";
		}
else if(qq==k)
{
	qs = "MEDIUM";
}
else if(qq==l)
{
	qs = "HARD";
}
%>


<td><p style="text-align:center"><%=qs%></p></td></tr>

<%}%>


     <% }%><%

 
     catch(Exception e)
     {
     System.out.println(e);
     }   %>

</table>


</body>
</html>