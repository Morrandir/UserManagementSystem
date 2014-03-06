<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-3-6
  Time: 下午9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Home</title>
</head>
<body>

<P> Welcome, <security:authentication property="name" />! </P>
<h1>
    Hello world!
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  Currently number of users online is ${numOnline}. </P>

<table>
    <tr>
        <td>
            <a href = "<c:url value="/user/overall" />">View all users</a>
        </td>
        <td>
            |
        </td>
        <td>
            <a href = "<c:url value="/user/add" />">Add a user</a>
        </td>
        <td>
            |
        </td>
        <td>
            <a href = "<c:url value="/logout" />">Logout</a>
        </td>
    </tr>
</table>

</body>
</html>
