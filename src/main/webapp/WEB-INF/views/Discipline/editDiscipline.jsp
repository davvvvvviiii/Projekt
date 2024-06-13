<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 30.05.2024
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit discipline</title>
    <style>
        form{
            border: 1px solid black;
            text-align: center;
            font-size: large;
            padding-top: 30px;
            padding-bottom: 30px;
        }
    </style>
</head>
<body>
    <form:form action="/discipline/edit" method="post" modelAttribute="discipline">
        <form:hidden path="id"/>
        nazwa<br>
        <form:input path="name"/>
        <br>
        <br>
        opis<br>
        <form:textarea path="description"/>
        <br>
        <br>
        <form:button>save</form:button>
    </form:form>
</body>
</html>
