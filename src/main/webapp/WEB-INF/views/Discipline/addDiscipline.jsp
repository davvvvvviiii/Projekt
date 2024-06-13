<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 30.05.2024
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add discipline</title>
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
    <form:form action="/discipline/add" method="post" modelAttribute="discipline">
        Nazwa<br>
        <form:input path="name"/>
        <form:errors path="name"/>
        <br>
        <br>
        Opis<br>
        <form:textarea path="description"/>
        <form:errors path="description"/>
        <br>
        <br>
        <form:button>save</form:button>
    </form:form>
</body>
</html>
