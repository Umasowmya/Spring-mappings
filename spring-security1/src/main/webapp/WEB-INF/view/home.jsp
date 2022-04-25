<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>


    <p>
    		User: <security:authentication property="principal.username" />
    		<br><br>
    		Role(s): <security:authentication property="principal.authorities" />
    </p>


	Welcome to the luv2code company home page!

	<!-- Add a link to point to /leaders ... this is for the managers -->

        <security:authorize access="hasRole('MANAGER')">
    	<p>
    		<a href="/spring-security1/leaders">Leadership Meeting</a>
    		(Only for Manager peeps)
    	</p>
         </security:authorize>

    	<!-- Add a link to point to /systems ... this is for the admins -->

        <security:authorize access="hasRole('ADMIN')">
    	<p>
    		<a href="/spring-security1/systems">IT Systems Meeting</a>
    		(Only for Admin peeps)
    	</p>
        </security:authorize>


	<form:form action="/spring-security1/logout" method="POST">
	        <input  type="submit" value="logout"/>

	</form:form>

</body>

</html>