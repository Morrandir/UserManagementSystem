<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<P> Welcome, <security:authentication property="name" />! </P>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href = "<c:url value="/j_spring_security_logout" />">Logout</a>

</body>
</html>
