<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 25.05.2024
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add player</title>
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
    <form:form method="post" action="/player/addPlayer" modelAttribute="player">
        <label>
            Imię<br>
            <form:input path="name"/>
            <form:errors path="name"/>
        </label>
        <br>
        <br>
        <label>
            Nazwisko<br>
            <form:input path="surname"/>
            <form:errors path="surname"/>
        </label>
        <br>
        <br>
<%--        <label>--%>
<%--            Drużyna--%>
<%--            <form:input path="team"/>--%>
<%--        </label>--%>
        <form:button>Save</form:button>
    </form:form>
</body>
</html>
