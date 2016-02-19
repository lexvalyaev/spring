<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Белка
  Date: 15.02.2016
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>${message}</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit/${user.id}.html">
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Edit" /></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>
