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
</head>
<body>
<form:form method="post" action="/team/edit" modelAttribute="team">
    <form:hidden path="id"/>
    <label>
        Imię
        <form:input path="name"/>
    </label>
    <form:button>Save</form:button>

</form:form>
</body>
</html>
