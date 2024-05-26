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
</head>
<body>
    <form:form method="post" action="/player/addPlayer" modelAttribute="player">
        <label>
            Imię
            <form:input path="name"/>
        </label>
        <label>
            Nazwisko
            <form:input path="surname"/>
        </label>
<%--        <label>--%>
<%--            Drużyna--%>
<%--            <form:input path="team"/>--%>
<%--        </label>--%>
        <form:button>Save</form:button>
    </form:form>
</body>
</html>
