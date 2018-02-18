<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Expense Management</title>
</head>
<body>
	
	<h3 style="margin-left:200px"><strong>Expense Management</strong></h3>
	<form action="login" method="post">
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="uName" id="uNAme"></input></td>
			</tr>
		
			<tr>
				<td>Password:</td>
				<td> <input type="password" name="pwd" id="pwd"/></td>
			</tr>
		</table><br/>
		<p style="color:red"><%=request.getAttribute("msg")==null?"" :request.getAttribute("msg")%></p>
		<button style="margin-left:100px" name="submit" value="Submit">Submit</button>
	</form>
	
</body>
</html>