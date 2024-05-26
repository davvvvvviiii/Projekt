<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 23.05.2024
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<form:form method="post" modelAttribute="user" action="/addUser">
    <form:hidden path="id"/>
    <label>First name:
        <form:input path="name"/>
    </label>
    <hr/>
    <label>Last name:
        <form:input path="surname"/>
    </label>
    <hr/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
