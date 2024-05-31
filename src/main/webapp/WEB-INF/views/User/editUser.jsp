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
</head>
<body>
  <form:form modelAttribute="user" method="post" action="/user/edit">
    <form:hidden path="id"  />
    imię
    <form:input path="name"/>
    nazwisko
    <form:input path="surname"/>
    <form:button>save</form:button>
  </form:form>
</body>
</html>
