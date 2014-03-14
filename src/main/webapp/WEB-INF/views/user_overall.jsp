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
            <div class="navbar-brand"  > User Management System </div>
        </div>
        <div class="navbar-left navbar-collapse collapse" >
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/bbs">BBS</a></li>
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

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Current User Status</h3>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th scope="col" class="col-xs-4">User Name</th>
                        <th scope="col" class="col-xs-4">User Enabled?</th>
                        <th scope="col" class="col-xs-4">Online Status</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sysUser" items="${sysUsers}">
                            <tr>
                                <td>
                                    <c:if test="${isAdmin}">
                                        <a href="${pageContext.request.contextPath}/user/${sysUser.user_id}">
                                    </c:if>
                                ${sysUser.user_name}
                                    <c:if test="${isAdmin}">
                                        </a>
                                    </c:if>
                                </td>
                                    <c:choose>
                                        <c:when test="${sysUser.enabled}">
                                            <td>
                                                <span class="glyphicon glyphicon-ok text-success"></span>
                                                <c:if test="${isAdmin && sysUser.user_id!=1}"> (<a href="${pageContext.request.contextPath}/user/disable/${sysUser.user_id}">Disable</a>) </c:if>
                                                <c:if test="${isAdmin && sysUser.user_id==1}"><span style="color:darkgray"> (Default Admin cannot be disabled) </span></c:if>

                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                <span class="glyphicon glyphicon-remove text-danger"></span>
                                                <c:if test="${isAdmin}"> (<a href="${pageContext.request.contextPath}/user/enable/${sysUser.user_id}">Enable</a>) </c:if>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                <c:choose>
                                    <c:when test="${sysUser.online}"><td class="text-success">Online</td></c:when>
                                    <c:otherwise><td style="color:darkgray">Offline</td></c:otherwise>
                                </c:choose>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../resources/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../resources/js/bootstrap.min.js"></script>

</body>
</html>
