<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>leads</title>
	<style type="text/css">
		table tr:nth-child(odd){
			background-color: lightgray;
		}
		table tr:nth-child(even){
			background-color: skyblue;
		}
	</style>
</head>
<body>
	<a href="viewCreateLeadPage">New Lead</a>
	<h2>All Leads</h2>
	<form>
		<table border="5px solid">
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Source</th>
			</tr>
			<c:forEach var="lead" items="${leads}">
				<tr>
					<td><a href="leadInfo?id=${lead.id }">${lead.firstName}</a></td>
					<td>${lead.lastName}</td>
					<td>${lead.email}</td>
					<td>${lead.mobile}</td>
					<td>${lead.source }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>