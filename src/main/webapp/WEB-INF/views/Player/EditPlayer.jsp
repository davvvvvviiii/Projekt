<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Player</title>
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
<form:form method="post" action="/player/edit" modelAttribute="player">
        <form:hidden path="id"/>
    <label>
        Imię<br>
        <form:input path="name"/>
    </label>
    <br>
    <br>
    <label>
        Nazwisko<br>
        <form:input path="surname"/>
    </label>
    <br>
    <br>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
