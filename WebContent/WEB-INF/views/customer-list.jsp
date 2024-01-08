<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome to Customer Relationship Management</title>
	<link href="${pageContext.request.contextPath}/resources/css/design.css" rel="stylesheet"/>
</head>
<body>
		<div class="top">
			<h2>CRM-Customer Relationship Management</h2>
		</div>
		
		<div class="divbut">
			<input type="button" value="Add Customer"
				onclick="window.location.href='showCustomer'"/>
		</div>
		
		<div class="divtab">
			<table>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Date</th>
					<th>City</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="temp" items="${customers}">
			 		<c:url var="updateLink" value="showUpdate">
						<c:param name="custUpdate" value="${temp.custId}"/>
					</c:url>
					<c:url var="deleteLink" value="delete">
						<c:param name="custDelete" value="${temp.custId}"/>
					</c:url>
			 		
					<tr>
						<td>${temp.custId}</td>
						<td>${temp.custName}</td>
						<td>${temp.custMb}</td>
						<td>${temp.custEmail}</td>
						<td>${temp.custDate}</td>
						<td>${temp.custCity}</td>
							<td>
							<a href="${updateLink}">Update</a>
							<a href="${deleteLink}"
							onclick="if(!(confirm('Do u want to delete?'))) return false;">Delete</a>
						</td>
				
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>