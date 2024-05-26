<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Player</title>
</head>
<body>
<form:form method="post" action="/player/edit" modelAttribute="player">
        <form:hidden path="id"/>
    <label>
        Imię
        <form:input path="name"/>
    </label>
    <label>
        Nazwisko
        <form:input path="surname"/>
    </label>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
