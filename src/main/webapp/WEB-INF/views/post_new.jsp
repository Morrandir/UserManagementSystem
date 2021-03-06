<%--
  Created by IntelliJ IDEA.
  User: Qubo_Song
  Date: 3/24/14
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>

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

<div class="container">
    <form:form action="${pageContext.request.contextPath}/bbs/new" method="post" cssStyle="margin-top:50px" modelAttribute="newPostForm">
        <div class="form-group">
            <form:errors path="post_title" >
            <div class="has-error">
            </form:errors>
            <label class="control-label" for="post_title"> Post Title </label>
                <form:errors path="post_title" >
                    <span class="control-label"> cannot be empty. </span>
                </form:errors>
            <form:input type="text" path="post_title" cssClass="form-control" id="post_title" placeholder="Enter title of the new post" />
            <form:errors path="post_title" >
            </div>
            </form:errors>
            <br>
        </div>
        <div class="form-group">
            <form:errors path="post_content" >
            <div class="has-error">
            </form:errors>
            <label class="control-label" for="post_content"> Content </label>
                <form:errors path="post_content" >
                    <span class="control-label"> cannot be more than 500 characters. </span>
                </form:errors>
            <form:textarea cssClass="form-control" rows="10" path="post_content" id="post_content" placeholder="No more than 500 characters." />
            <form:errors path="post_content" >
            </div>
            </form:errors>
        </div>
        <div class="form-inline btn-group-sm">
            <button class="btn btn-primary" name="submit" type="submit"> Submit </button>
            <button class="btn btn-primary" name="reset" type="reset"> Reset </button>
            <a href="javascript:javascript:history.go(-1)" class="btn btn-primary"> Cancel </a>
        </div>
    </form:form>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../resources/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../resources/js/bootstrap.min.js"></script>

</body>
</html>
