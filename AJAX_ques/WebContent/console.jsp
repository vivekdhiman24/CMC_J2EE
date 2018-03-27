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
Thread.sleep(2000);
String name=request.getParameter("s1");
try{
DriverManager.registerDriver(new com.mysql.jdbc.Driver());
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=");
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery("select * from register where Name='"+name+"'");

if(rs.next())
{
	out.println("\n"+"Name : "+rs.getString(1)+"<br>");
	out.println("Password : "+rs.getString(2)+"<br>");
	out.println("Email : "+rs.getString(3)+"<br>");
	out.println("Country : "+rs.getString(4));
	
	while(rs.next())
	{
		out.println("Name : "+rs.getString(1)+"<br>");
		out.println("Password : "+rs.getString(2)+"<br>");
		out.println("Email : "+rs.getString(3)+"<br>");
		out.println("Country : "+rs.getString(4));

	}
}
else
	out.println("NO USER FOUND");
}
catch(Exception ex)
{
}
%>
</body>
</html>