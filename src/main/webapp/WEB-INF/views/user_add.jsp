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

<c:if test="${origin != 'register'}">
    <P> Welcome, <security:authentication property="name" />! </P>
</c:if>
<c:if test="${origin == 'register'}">
    <P> Welcome, please provide registration information. </P>
</c:if>

<form:form action="/user/${origin}" method="post" modelAttribute="addUserForm" >

    <form:errors path="*">
        <div style="color:#FF0000;font-size:13px"> Please fix the problems listed below. </div>
        <P></P>
        <P></P>
    </form:errors>

    <table cellpadding=4 cellspacing=2 border="0.1">
        <tr>
            <td><form:label path="userName"> User name: </form:label></td>
            <td style="width:160px">
                <form:input path="userName" required="true" title="Required, between 4-20 characters." pattern=".{4,20}" cssStyle="width:150px" />
                <form:errors path="userName" >
                    <div><form:errors path="userName" htmlEscape="false" cssStyle="color:#FF0000;font-size:13px" /></div>
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
        <c:if test="${origin != 'register'}">
            <tr>
                <td><form:label path="userRole"> User role: </form:label></td>
                <td>
                    <form:select path = "userRole" cssStyle="width:150px">
                        <form:option value="ROLE_USER"> User </form:option>
                        <form:option value="ROLE_ADMIN"> Administrator </form:option>
                    </form:select>
                </td>
            </tr>
        </c:if>
        <tr>
            <td colspan="2">
                <c:if test="${origin != 'register'}">
                    <input name="submit" type="submit" value="Add User"/>
                </c:if>
                <c:if test="${origin == 'register'}">
                    <input name="submit" type="submit" value="Register"/>
                </c:if>
            </td>
        </tr>
    </table>


</form:form>

<c:if test="${origin != 'register'}">
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
</c:if>

</body>
</html>
