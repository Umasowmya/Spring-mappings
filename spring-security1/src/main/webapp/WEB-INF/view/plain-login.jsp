<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<title>Custom Login Page</title>

	<style>
		.failed {
			color: red;
		}
	</style>

</head>

<body>

<h3>My Custom Login Page</h3>

    <div th:if="${param.error}">
    			Invalid username and password.</div>

	<form:form action="/spring-security1/authenticateTheUser"
			   method="POST">

		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="Login" />

	</form:form>

</body>

</html>











