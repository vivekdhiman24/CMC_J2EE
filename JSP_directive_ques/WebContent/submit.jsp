<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String u=request.getParameter("t1");
String p=request.getParameter("t2");
session.setAttribute("user", u);
session.setAttribute("pass", p);

try
{
DriverManager.registerDriver(new com.mysql.jdbc.Driver());
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=");
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery("select * from register where (Name='"+u+"' and Pass='"+p+"')");
if(rs.next())
{
	response.sendRedirect("profile.jsp?u1="+u);
}
else
{
	out.println("Invalid Details.....");
%>	
	<%@ include file="login.html" %>
<%
}
}
catch(Exception e)
{
}
%>
</body>
</html>