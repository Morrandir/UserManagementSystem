<%--
  Created by IntelliJ IDEA.
  User: Qubo_Song
  Date: 3/14/14
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../../resources/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/css/theme.css" rel="stylesheet">

</head>

<body>

<security:authorize ifAnyGranted="ROLE_ADMIN" var="isAdmin" />

<div class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container" >
        <div class="navbar-header" >
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="navbar-brand" > User Management System </div>
        </div>
        <div class="navbar-left navbar-collapse collapse" >
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/bbs">BBS</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <c:if test="${isAdmin}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Maintenance <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header"> User Management </li>
                            <li><a href="${pageContext.request.contextPath}/user/overall"> View all users </a></li>
                            <li><a href="${pageContext.request.contextPath}/user/add"> Add a new user </a></li>
                            <li class="divider"></li>
                            <li class="dropdown-header"> Placeholder </li>
                            <li><a href="#"> Placeholder </a></li>
                            <li><a href="#"> Placeholder </a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
        <ul class="nav navbar-nav navbar-right navbar-collapse collapse" >
            <li class="dropdown" >
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"  style="color:#429ada" > Welcome, <security:authentication property="name" />! <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/user/profile">Profile</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </ul>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/user/overall"> Users online: ${numOnline} </a>
            </li>
        </ul>
    </div>
</div>

<div class="container" style="float:left">
    <a class="btn btn-lg btn-primary"> Up </a>
</div>

<div class="jumbotron">
    <div class="container">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col" class="col-xs-1"> # </th>
                    <th scope="col" class="col-xs-5"> Topic </th>
                    <th scope="col" class="col-xs-3"> Last Update Time </th>
                    <th scope="col" class="col-xs-3"> Poster </th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<div class="container" style="display: inline">

</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../resources/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../resources/js/bootstrap.min.js"></script>

</body>
</html>