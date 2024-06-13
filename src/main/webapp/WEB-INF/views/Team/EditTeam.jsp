<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 26.05.2024
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit team</title>
    <style>
        form{
            border: 1px solid black;
            text-align: center;
            font-size: large;
            padding-top: 30px;
            padding-bottom: 30px;
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
        }
    </style>
</head>
<body>
<form:form method="post" action="/team/edit" modelAttribute="team">
    <form:hidden path="id"/>
    <label>
        Imię<br>
        <form:input path="name"/>
    </label>
    <br>
    <br>
    <form:button>Save</form:button>

</form:form>
</body>
</html>
