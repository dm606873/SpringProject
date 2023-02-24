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
   
   background-color: aqua;
}
h1{
text-align: center; 
color: red;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<h1 >Wellcome Admin Page</h1>
<form:form action="admincode.html" method="post" name="frm1">
 <form:input path="username" />Enter username <br><br>
 <form:password path="password" />Enter Password <br><br>
 <input type="submit" name="btnsubmit" value="login"/><br>
</form:form>
${key}
</body>
</html>