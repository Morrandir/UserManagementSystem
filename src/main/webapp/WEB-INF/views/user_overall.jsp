<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-2-27
  Time: 下午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>View Users</title>
</head>
<body>

<P> Welcome, <security:authentication property="name" />! </P>

<h3>Current User Status:</h3>

<table border="0">
    <c:forEach var="sysUser" items="${sysUsers}">
            <tr>
                <td>${sysUser.user_name}</td>
                <td>
                    <c:choose>
                        <c:when test="${sysUser.enabled == true}">Enabled</c:when>
                        <c:otherwise>Disabled</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${sysUser.online ==true}">Online</c:when>
                        <c:otherwise>Offline</c:otherwise>
                    </c:choose>
                </td>
            </tr>
    </c:forEach>
</table>

<P><a href = "<c:url value="/" />">Home</a></P>
<P><a href = "<c:url value="/j_spring_security_logout" />">Logout</a></P>

</body>
</html>
