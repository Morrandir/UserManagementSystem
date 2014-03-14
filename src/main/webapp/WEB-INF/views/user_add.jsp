<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-3-1
  Time: 下午1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a user</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../../resources/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/css/theme.css" rel="stylesheet">

<%--    <!-- Custom styles for this template -->
    <link href="../../resources/css/login.css" rel="stylesheet">--%>


</head>
<body>

<security:authorize ifAnyGranted="ROLE_ADMIN" var="isAdmin" />


<c:if test="${origin != 'register'}">
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
</c:if>

<div class="jumbotron">
    <c:if test="${origin == 'register'}">
        <P> Welcome, please provide registration information. </P>
    </c:if>

    <div class="container" style="margin-left:0px">
        <form:form cssClass="form-horizontal" action="/user/${origin}" method="post" modelAttribute="addUserForm" >

            <form:errors path="*">
                <div class="form-group has-error" >
                    <div class="col-sm-offset-2 col-sm-10">
                        <span class="control-label glyphicon glyphicon-warning-sign"></span>
                        <span class="control-label"> Please fix the problems listed below. </span>
                    </div>
                </div>
            </form:errors>

            <div class="form-group">
                <form:errors path="userName" >
                    <div class="has-error">
                </form:errors>
                <label for="userName" class="col-sm-2 control-label"> User Name </label>
                <div class="form-inline col-sm-10">
                    <form:input path="userName" id="userName" class="form-control" placeholder="User Name" cssStyle="width:200px" />
                    <span class="control-label" style="font-weight:normal"> Required, must be 4~20 characters. </span>
                </div>
                <form:errors path="userName" >
                    </div>
                </form:errors>
            </div>

            <div class="form-group">
                <form:errors path="password" >
                    <div class="has-error">
                </form:errors>
                <label for="password" class="col-sm-2 control-label"> Password </label>
                <div class="form-inline col-sm-10">
                    <form:password path="password" id="password" class="form-control" placeholder="Password" cssStyle="width:200px" />
                    <span class="control-label" style="font-weight:normal"> Required, between 4~20 characters. </span>
                </div>
                <form:errors path="password" >
                    </div>
                </form:errors>
            </div>

            <div class="form-group">
                <form:errors path="confirmPassword" >
                    <div class="has-error">
                </form:errors>
                <label for="confirmPassword" class="col-sm-2 control-label"> Confirm Password </label>
                <div class="form-inline col-sm-10">
                    <form:password path="confirmPassword" id="confirmPassword" class="form-control" placeholder="Confirm Password" cssStyle="width:200px" />
                    <form:errors path="confirmPassword" >
                        <span class="control-label" style="font-weight:normal"> Your passwords didn't match. </span>
                    </form:errors>
                </div>
                <form:errors path="confirmPassword" >
                    </div>
                </form:errors>
            </div>

            <c:if test="${origin != 'register'}">
                <div class="form-group">
                    <label for="userRole" class="col-sm-2 control-label"> User Role </label>
                    <div class="col-sm-10">
                        <form:select path="userRole" id="userRole" class="form-control" cssStyle="width:200px;">
                            <form:option selected="true" value="ROLE_USER"> User </form:option>
                            <form:option value="ROLE_ADMIN"> Administrator </form:option>
                        </form:select>
                    </div>
                </div>
            </c:if>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:if test="${origin != 'register'}">
                        <button class="btn btn-primary" name="submit" type="submit" > Add User </button>
                    </c:if>
                    <c:if test="${origin == 'register'}">
                        <button class="btn btn-lg btn-success" name="submit" type="submit" > Register </button>
                    </c:if>
                </div>
            </div>

        </form:form>
    </div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../resources/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../resources/js/bootstrap.min.js"></script>

</body>
</html>
