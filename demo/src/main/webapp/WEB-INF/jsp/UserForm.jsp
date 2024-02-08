<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form aaaaaa</title>
</head>
<body>
<h2>Enter your details:</h2>
<form:form modelAttribute="user" method="POST" action="/addUser">
    <table>
        <tr>
            <td>First name:</td>
            <td><form:input path="fname" /></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><form:input path="lname" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>