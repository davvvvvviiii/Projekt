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
</head>
<body>
    <form:form action="/discipline/edit" method="post" modelAttribute="discipline">
        <form:hidden path="id"/>
        nazwa
        <form:input path="name"/>
        opis
        <form:textarea path="description"/>
        <form:button>save</form:button>
    </form:form>
</body>
</html>
