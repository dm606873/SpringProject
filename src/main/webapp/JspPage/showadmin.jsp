<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator" %>
    <%@page import="java.util.List" %>
    <%@page import="Model.UserModel" %>
<!DOCTYPE html>
<html>
<head>
<style>
body{
  background-color:orange;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

</head>
<body>
<a href="homecode.html">Home</a>
<h1>Wellcome User View Record</h1>
<br>
<table border="1">
<tr><th>username</th><th>password</th> <th>Email</th> <th>Mobile</th> <th>Status</th></tr>
<%
if(request.getAttribute("key1")!=null){
	 List lst=(List)request.getAttribute("key1");
	 Iterator it=lst.iterator();
	 while(it.hasNext()){
		 UserModel s=(UserModel)it.next(); %>
 <tr><td> <%=s.getUsername() %></td><td><%=s.getPassword() %><td><%=s.getEmail() %><td><%=s.getMobile() %><td><%=s.getStatus()%></td>
     <td> <a href="edituser.html?q=<%=s.getUsername()%>">Approved</a>
      <td> <a href="edituser1.html?q=<%=s.getUsername()%>">Bloak</a></td>
		 </tr>
<%  }
}
%>
</table>
</body>
</html>