<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Users</title>
</head>
<body>
<p>${message}</p>
<h1>List of users</h1>
<p>Users in a base. CRUD all.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="10%">id</th>
        <th width="15%">name</th>
        <th width="10%">age</th>
        <th width="10%">createdDate</th>
        <th width="10%">Edit/Delete</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.createdDate}</td>

            <td>
                <a href="${pageContext.request.contextPath}/user/edit/${user.id}.html">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/user/delete/${user.id}.html">Delete</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/user/add.html">Add new user</a></p>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>
