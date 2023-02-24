<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.Iterator" %>
<%@page import="java.util.Iterator" %>
    <%@page import="java.util.List" %>
    <%@page import="Model.UserModel" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<a href="homecode.html">Home</a>
<table border="1">
<tr><td>UserName</td><td>Password</td><td>Email</td><td>Mobile</td><td>Status</td></tr>
<%
if(request.getAttribute("key")!=null)
{
	List lst = (List)request.getAttribute("key");
	Iterator it = lst.iterator();
	while(it.hasNext()){
		UserModel ss = (UserModel)it.next(); %>
		<tr><td><%= ss.getUsername() %></td><td><%= ss.getPassword() %></td><td><%= ss.getEmail() %></td><td><%= ss.getMobile() %></td><td><%= ss.getStatus() %></td>
	
	<% }
}
%>
</table>
</body>
</html>