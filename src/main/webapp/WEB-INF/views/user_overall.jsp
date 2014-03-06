<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-2-27
  Time: 下午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>View Users</title>
</head>
<body>

<P> Welcome, <security:authentication property="name" />! </P>

<h3>Current User Status:</h3>

<table>
    <c:forEach var="sysUser" items="${sysUsers}">
            <tr>
                <td>${sysUser.user_name}</td>
                <td>
                    <c:choose>
                        <c:when test="${sysUser.enabled}">Enabled</c:when>
                        <c:otherwise>Disabled</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${sysUser.online}">Online</c:when>
                        <c:otherwise>Offline</c:otherwise>
                    </c:choose>
                </td>
            </tr>
    </c:forEach>
</table>

<table>
    <tr>
        <td>
            <a href = "<c:url value="/" />"> Home </a>
        </td>
        <td>
            |
        </td>
        <td>
            <a href = "<c:url value="/user/add" />"> Add a user </a>
        </td>
        <td>
            |
        </td>
        <td>
            <a href = "<c:url value="/logout" />"> Logout </a>
        </td>
    </tr>
</table>

</body>
</html>
