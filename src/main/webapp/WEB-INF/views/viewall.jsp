<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-2-27
  Time: 下午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>View Users</title>
</head>
<body>
<h3>Current User Status:</h3>

<c:forEach items="${sysUserNames}" var="sysUserName">
    <p>${sysUserName}</p>
</c:forEach>

</body>
</html>
