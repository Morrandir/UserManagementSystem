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
<form action='/j_spring_security_check' method='POST'>
    <table>
        <tr><td>User name:</td><td><label>
            <input type='text' name='j_username' value=''>
        </label></td></tr>
        <tr><td>Password:</td><td><label>
            <input type='password' name='j_password'/>
        </label></td></tr>
        <tr><td colspan='2'><input name="submit" type="submit" value="login"/></td></tr>
    </table>
</form>
</body>
</html>
