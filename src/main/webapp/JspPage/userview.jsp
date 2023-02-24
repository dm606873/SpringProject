<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator" %>
    <%@page import="java.util.List" %>
    <%@page import="Model.UserModel" %>
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function validuser(a){
	var xmlhttp= new XMLHttpRequest();
	
	xmlhttp.onreadystatechange= function(){
		document.getElementById("spl").innerHTML=xmlhttp.responseText;
	}
	xmlhttp.open("post","checkuserinfo.html?q="+a,true);
	xmlhttp.send();
}
</script>
<style>
body{
  background-color: aqua;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert User Record </title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

</head>
<body>
<a href="homecode.html">Home</a>
<h1>Insert New  User Record</h1>
<form:form action="usercode.html" method="post" name="frm1">
 <form:input path="username" onblur="validuser(this.value)" /><span id="spl"></span>Enter Name <br>
 <form:input path="password" />Enter Password <br>
 <form:input path="email" />Enter Email <br>
 <form:input path="mobile" />Enter Mobile <br>
 <input type="submit" name="btnsubmit" value="click"/><br>

</form:form>
${key}


</body>
</html>