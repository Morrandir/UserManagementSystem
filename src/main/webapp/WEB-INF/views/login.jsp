<%--
  Created by IntelliJ IDEA.
  User: Qubo_Song
  Date: 2/26/14
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Login</title>
</head>
<body>
<h3>${message}</h3>
<form action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
    <table>
        <tr>
            <td>User name:</td>
            <td>
                <label>
                    <input type='text' name='j_username' value='' size=15 />
                </label>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <label>
                    <input type='password' name='j_password' value='' size=15 />
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <input name="submit" type="submit" value="login"/>
            </td>
            <td>
                New user? Click here to
                <a href = "<c:url value="/user/register" />">Register</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
