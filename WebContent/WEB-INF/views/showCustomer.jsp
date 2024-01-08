<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Add New Customer</title>
		<link href="${pageContext.request.contextPath}/resources/css/design.css" rel="stylesheet"/>
	</head>
	<body>
		<div class="top">
			<h2>CRM-Customer Relationship Management</h2>
		</div>
		<div class="main">
			<s:form action="saveCust" modelAttribute="customer">
				<div class="mainform">
					<s:hidden path="custId"/>
					<span>Name:</span><br>
					<s:input path="custName"/>
					<s:errors path="custName" cssClass="error"/>
					<br>
					<span>Mobile:</span><br>
					<s:input path="custMb"/>
					<s:errors path="custMb" cssClass="error"/>
					<br>
					<span>Email:</span><br>
					<s:input path="custEmail"/>
					<s:errors path="custEmail" cssClass="error"/>
					<br>
					<span>Date:</span><br>
					<s:input path="custDate"/>
					<s:errors path="custDate" cssClass="error"/>
					<br>
					<span>City:</span><br>
					<s:input path="custCity"/>
					<s:errors path="custCity" cssClass="error"/>
					<br><br>
					<input type="submit" value="Save" />
				</div>
			</s:form>
		</div>
	</body>
</html>