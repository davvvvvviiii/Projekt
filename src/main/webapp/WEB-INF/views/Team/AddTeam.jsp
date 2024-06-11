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
</head>
<body>
    <form:form method="post" action="/team/add" modelAttribute="team">
        <label>
            Nazwa drużyny
        <form:input path="name"/>
        <form:errors path="name"/>
        </label>
<%--        <form:hidden path="players"/>--%>
        <form:button>save  </form:button>
    </form:form>
</body>
</html>
