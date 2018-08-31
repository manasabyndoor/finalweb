<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Customers List</h1>
	<jstl:if test="${customer!=null }"></jstl:if>
	<table>
		<tr>
			<th>Customer</th>
			<th>Name</th>
		</tr>
		<jstl:forEach items="${customer}" var="customer">

			<tr>
			
				<td>${customer.customerId}</td>
				<td>${customer.customerName }</td>
			</tr>


		</jstl:forEach>
	</table>



</body>
</html>