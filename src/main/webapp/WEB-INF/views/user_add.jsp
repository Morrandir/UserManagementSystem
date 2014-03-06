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
</head>
<body>

<P> Welcome, <security:authentication property="name" />! </P>

<form:form action="/user/add" method="post" modelAttribute="addUserForm" >

    <form:errors path="*">
        <div style="color:#FF0000;font-size:13px"> Please fix the problems listed below. </div>
        <P></P>
        <P></P>
    </form:errors>

    <table cellpadding=4 cellspacing=2>
        <tr>
            <td><form:label path="userName"> User name: </form:label></td>
            <td>
                <form:input path="userName" required="true" title="Required, between 4-20 characters." pattern=".{4,20}" cssStyle="width:150px" />
                <form:errors path="userName" cssStyle="color:#FF0000;font-size:13px;width:150px">
                    <div><form:errors path="userName" htmlEscape="false" /></div>
                </form:errors>
            </td>
            <td>
                <div> Required. Between 4-20 characters. </div>
            </td>
        </tr>
        <tr>
            <td><form:label path="password"> Password: </form:label></td>
            <td>
                <form:password path="password" required="true" title="Required, between 4-20 characters." pattern=".{4,20}" cssStyle="width:150px" />
                <form:errors path="password">
                    <div><form:errors path="password" htmlEscape="false" cssStyle="color:#FF0000;font-size:13px;width:150px" /></div>
                </form:errors>
            </td>
            <td>
                <div> Required. Between 4-20 characters. </div>
            </td>
        </tr>
        <tr>
            <td><form:label path="confirmPassword"> Confirm password: </form:label></td>
            <td>
                <form:password path="confirmPassword" cssStyle="width:150px" />
                <form:errors path="confirmPassword">
                    <div><form:errors path="confirmPassword" htmlEscape="false" cssStyle="color:#FF0000;font-size:13px;width:150px" /></div>
                </form:errors>
            </td>
        </tr>
        <tr>
            <td><form:label path="userRole"> User role: </form:label></td>
            <td>
                <form:select path = "userRole" cssStyle="width:150px">
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
