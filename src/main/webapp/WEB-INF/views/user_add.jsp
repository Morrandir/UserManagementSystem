<%--
  Created by IntelliJ IDEA.
  User: Morrandir
  Date: 14-3-1
  Time: 下午1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a user</title>
</head>
<body>

<script type="text/javascript">
    function validate(action) {
        var userName = document.addUser.username.value;
        var userWarning = document.getElementById("username_warning");
        var password1 = document.addUser.password1.value;
        var p1Warning = document.getElementById("password1_warning")
        var password2 = document.addUser.password2.value;
        var p2Warning = document.getElementById("password2_warning");
        var invalid;
        var submitResult = true;


        invalid = /[\W\s]/;
        //Alphanumeric characters
        if(userName == "" || invalid.test(userName)) {
            p1Warning.style.color = "#000000";
            p1Warning.style.fontWeight = "normal";
            p2Warning.style.visibility = "hidden";
            userWarning.style.color = "#FF0000";
            userWarning.style.fontWeight = "bold";
            if(action != "submit") {
                return false;
            } else {
                submitResult = false;
            }
        } else {
            userWarning.style.color = "#000000";
            userWarning.style.fontWeight = "normal";
        }

        if(action != "check_username") {
            invalid = /[\W_]/;
            //Alphanumeric characters only allowed
            if (password1 == "" || invalid.test(password1)) {
                p2Warning.style.visibility = "hidden";
                p1Warning.style.color = "#FF0000";
                p1Warning.style.fontWeight = "bold";
                if(action != "submit") {
                    return false;
                } else {
                    submitResult = false;
                }
            } else {
                p1Warning.style.color = "#000000";
                p1Warning.style.fontWeight = "normal";
            }
        }


        if(action != "check_username" && action != "check_password1") {
            if(password2 == "" || password2 != document.addUser.password1.value){
                p2Warning.style.visibility = "visible";
                if(action != "submit") {
                    return false;
                } else {
                    submitResult = false;
                }
            } else {
                p2Warning.style.visibility = "hidden";
            }
        }

        if(!submitResult) {
            alert("Some information provided are not correct, please check them again.");
            return false;
        }
        return true;

    }

</script>

<P> Welcome, <security:authentication property="name" />! </P>

<form name="addUser" action="/user/add" method="post" onsubmit="return validate('submit')" >
    <table cellpadding=4 cellspacing=2>
        <tr>
            <td>
                User name:
            </td>
            <td>
                <label>
                    <input type='text' name='username' value='' size="15" maxlength="20" onblur="validate('check_username')">
                </label>
            </td>
            <td>
                <span name="username_warning" style='color:#000000;visibility:visible;font-size:12' id="username_warning"> Cannot be blank. Can only contain alphanumeric characters. </span>
            </td>
        </tr>
        <tr>
            <td>
                Password:
            </td>
            <td>
                <label>
                    <input type='password' name='password1' value='' size="15" maxlength="20" onblur="validate('check_password1')">
                </label>
            </td>
            <td>
                <span name="password1_warning" style='color:#000000;visibility:visible;font-size:12' id="password1_warning"> Cannot be blank. Can only contain alphanumeric characters. </span>
            </td>
        </tr>
        <tr>
            <td>
                Confirm password:
            </td>
            <td>
                <label>
                    <input type='password' name='password2' value='' size="15" maxlength="20" onblur="validate('check_password2')">
                </label>
            </td>
            <td>
                <span name="password2_warning" style='color:#ff0000;visibility:hidden;font-size:12' id="password2_warning"> 2 passwords are not the same. </span>
            </td>
        </tr>
        <tr>
            <td>
                User type:
            </td>
            <td>
                <label>
                    <select>
                        <option value="ROLE_USER">
                            User
                        </option>
                        <option vaule="ROLE_ADMIN">
                            Administrator
                        </option>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input name="submit" type="submit" value="Add User"/>
            </td>
        </tr>
    </table>
</form>

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
