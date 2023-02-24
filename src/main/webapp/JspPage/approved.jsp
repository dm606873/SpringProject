 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<a href="homecode.html">home</a>
<form:form method="post" action="update1.html">

 <form:input type="hidden" path  ="username" /> <br>
 <form:input type="hidden" path="password" /><br>
 <form:input type="hidden" path="email" /><br>
 <form:input type="hidden" path="mobile" /><br>
 <form:input type="hidden" path="status" value="1" /><br>
 <input type="submit" name="btnsubmit" value="Approved"/><br>
 </form:form>
</body>
</html>