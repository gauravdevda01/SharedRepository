<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Request Page</title>
</head>
<body>

	<h3 style="margin-left:200px"><strong>Expense Management</strong></h3>
	<form action="RequestServlet" method="post">
		<table>
			<tr>
			<td>First Name:</td>
			<td><input type="text" name="fname" id="fname"></input></td>
			</tr>
		
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="mname" id="mname"></input></td>
			</tr>
			
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname" id="lname" /></td>
			</tr>
			
			<tr>
				<td>User Id:</td>
				<td><input type="text" name="uId" id="uId"/></td>
			</tr>
			
			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="email" id="email"/></td>
			</tr>
			
			<tr>
				<td>Mobile No:</td>
				<td><input type="text" name="mNum" id="mNum"/></td>
			</tr>
		</table>
		  <p style="color:red"><%=request.getAttribute("fieldMsg")==null?"" :request.getAttribute("fieldMsg") %></p>
		<input  type="submit" name="Submit" value="Submit" style="margin-left:100px"/>
	</form>

</body>
</html>