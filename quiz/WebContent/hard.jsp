<%@page import="java.sql.*"%>
<html>

<body><style>
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
<a href="select.jsp"  >back</a>&nbsp
<h1 style="text-align:center; color: red;"> All The Best <%=request.getParameter("name") %></h1>

<form method="post" action="hard_ver">
 <%
String name = request.getParameter("name");
System.out.println(name);
String id = request.getParameter("id");
String q = request.getParameter("q");
System.out.println(q);

%>
 <input type="hidden" name="name" value=<%=request.getParameter("name") %>>
  <input type="hidden" name="id" value=<%=request.getParameter("id") %>>
    <input type="hidden" name="q" value=<%=request.getParameter("q") %>>
<table style="color:white">
<%
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root", "mysql");
Statement st=connection.createStatement();
ResultSet rs=st.executeQuery("Select * from hard");
int i=1;
while(rs.next()){
%>
<tr><td><%=i%>&nbsp :&nbsp<%=rs.getString("qustions")%></td></tr><tr><td><input type="radio" value="<%=rs.getString("QA")%>" name="radio<%=i%>"/><%=rs.getString("QA")%></td></tr><td><input type="radio" value="<%=rs.getString("QB")%>" name="radio<%=i%>"/><%=rs.getString("QB")%></td></tr><td><input type="radio" value="<%=rs.getString("QC")%>" name="radio<%=i%>"/><%=rs.getString("QC")%></td></tr><td><input type="radio" value="<%=rs.getString("QD")%>" name="radio<%=i%>"/><%=rs.getString("QD")%></td></tr>

<%
i++;
}
%>
<tr><td><br><br><input type="submit" value="submit">&nbsp&nbsp&nbsp<input type="reset" value="cancel"></td></tr>

</table>
</form>
</body>
</html>