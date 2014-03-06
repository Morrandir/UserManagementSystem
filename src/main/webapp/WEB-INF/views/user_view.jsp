<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-3-6
  Time: 下午9:33
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

<c:if test="${origin == 'add'}">
    <h3>
        User has been added successfully!
    </h3>
</c:if>
<c:if test="${origin == 'register'}">
    <h3>
        You have been registered successfully!
    </h3>
</c:if>

<P>  User details: </P>

<table>
    <tr>
        <td>
            User name:
        </td>
        <td>
            ${sysUser.user_name}
        </td>
    </tr>
    <tr>
        <td>
            Status:
        </td>
        <td>
            <c:choose>
                <c:when test="${sysUser.enabled}">Enabled</c:when>
                <c:otherwise>Disabled</c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>



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