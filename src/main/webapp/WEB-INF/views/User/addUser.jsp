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
    <style>
        form{
            border: 1px solid;
            padding: 15px;
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="user" action="/user/add">
    <form:hidden path="id"/>
    <label>First name:
        <form:input path="name"/>
        <form:errors path="name"/>
    </label>
    <hr/>
    <label>Last name:
        <form:input path="surname"/>
        <form:errors path="surname"/>
    </label>
    <hr/>
    <label>Password:
        <form:password path="password"/>
        <form:errors path="password"/>
    </label>
    <hr/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
