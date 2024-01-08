<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login Form</title>
	<link href="${pageContext.request.contextPath}/resources/css/design.css" rel="stylesheet"/>
	
</head>
<body>
	<div class="top">
		<h2>EMS-Employee Management System</h2>
	</div>
	<div class="main">
	<s:form action="checkLogin" modelAttribute="login">
		<div class="mainform">
			<span>Username:</span><br>
			<s:input path="userName"/>
			<s:errors path="userName" cssClass="error"/>
			<br>
			<span>Password:</span><br>
			<s:password path="userPass"/>
			<s:errors path="userPass" cssClass="error"/>
			<font color="red">${msg}</font>
			<br><br>
			<input type="submit" value="Login"/>
		</div>
	</s:form>
	</div>
</body>
</html>