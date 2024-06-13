<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 26.05.2024
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add team</title>
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
    <form:form method="post" action="/team/add" modelAttribute="team">
        <label>
            Nazwa drużyny<br>
        <form:input path="name"/>
        <form:errors path="name"/>
        </label>
        <br>
        <br>
<%--        <form:hidden path="players"/>--%>
        <form:button>save  </form:button>
    </form:form>
</body>
</html>
