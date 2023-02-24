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
   color: aqua;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert User Record </title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<h1>Are You Sure You Want to Bloak </h1>
<form:form action="update2.html" method="post" name="frm1">
 <form:input type="hidden" path  ="username" /> <br>
 <form:input type="hidden" path="password" /><br>
 <form:input type="hidden" path="email" /><br>
 <form:input type="hidden" path="mobile" /><br>
 <form:input type="hidden" path="status" value="0" /><br>
 <input type="submit" name="btnsubmit" value="Block"/><br>
</form:form>
${key}
</body>
</html>