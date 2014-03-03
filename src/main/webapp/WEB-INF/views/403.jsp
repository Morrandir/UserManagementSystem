<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-3-1
  Time: 下午5:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Access Denied</title>
</head>
<body>

<P> Welcome, <security:authentication property="name" />! </P>
<h1>
    Access Denied!
</h1>

<P>  You have no access to the resource on this page. </P>

<table>
    <tr>
        <td>
            <a href = "<c:url value="/" />"> Home </a>
        </td>
        <td>
            |
        </td>
        <td>
            <a href = "<c:url value="/user/overall" />"> View all users </a>
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
