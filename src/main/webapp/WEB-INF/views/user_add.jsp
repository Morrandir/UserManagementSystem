<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-3-1
  Time: 下午1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a user</title>
</head>
<body>

<P> Welcome, <security:authentication property="name" />! </P>

<form:form action="/user/add" method="post" modelAttribute="addUserForm" >
    <table cellpadding=4 cellspacing=2>
        <tr>
            <td><form:label path="userName"> User name: </form:label></td>
            <td><form:input path="userName" /></td>
        </tr>
        <tr>
            <td><form:label path="password"> Password: </form:label></td>
            <td><form:password path="password" /></td>
        </tr>
        <tr>
            <td><form:label path="confirmPassword"> Confirm password: </form:label></td>
            <td><form:password path="confirmPassword" /></td>
        </tr>
        <tr>
            <td><form:label path="userRole"> User role: </form:label></td>
            <td>
                <form:select path = "userRole">
                    <form:option value="ROLE_USER"> User </form:option>
                    <form:option value="ROLE_ADMIN"> Administrator </form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input name="submit" type="submit" value="Add User"/>
            </td>
        </tr>
    </table>
</form:form>

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
            <a href = "<c:url value="/logout" />"> Logout </a>
        </td>
    </tr>
</table>

</body>
</html>
