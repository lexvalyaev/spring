<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: Белка
  Date: 15.02.2016
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Add user page</h1>
<p>Here you can add a new user.</p>
<h1>Add new</h1>
<form class="tg" method="post" action="add">
    Name: <input type="text" name="name"/>
    Age: <input type="text" name="age"/>
    Is Admin: <input type="checkbox" name="isAdmin" value="true" />
    <button>Add</button>
</form>
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>
