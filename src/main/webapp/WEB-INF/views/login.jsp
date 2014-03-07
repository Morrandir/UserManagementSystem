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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../../resources/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/css/login.css" rel="stylesheet">

</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container" >
        <div class="navbar-header" >
            <h1 class="navbar-text" style="color:#eeeeee" > User Management System </h1>
        </div>
    </div>
</div>


<div class="container"  >
    <form action='${pageContext.request.contextPath}/j_spring_security_check' method='POST' class="form-signin" style="margin-left:0" >
        <h4 class="form-signin-heading"> ${message} </h4>
        <P></P>
        <input type='username' name='j_username' value='' class="form-control" placeholder="User Name" required autofocus />
        <input type='password' name='j_password' value='' class="form-control" placeholder="Password" required />
        <input name="submit" type="submit" value="login" class="btn btn-lg btn-primary btn-block" />
        <P></P>
        <P> New user? Click here to
            <a href = "<c:url value="/user/register" />"> Register </a>
        </P>
    </form>
</div>


</body>
</html>
