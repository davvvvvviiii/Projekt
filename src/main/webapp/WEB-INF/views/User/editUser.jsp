<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 31.05.2024
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit user</title>
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
  <form:form modelAttribute="user" method="post" action="/user/edit">
    <form:hidden path="id"  />
    imię<br>
    <form:input path="name"/>
    <br>
    <br>
    nazwisko<br>
    <form:input path="surname"/>
    <br>
    <br>
    password<br>
    <form:password path="password"/>
    <br>
    <br>
    <form:button>save</form:button>
  </form:form>
</body>
</html>
