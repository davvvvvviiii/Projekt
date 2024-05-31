<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 25.05.2024
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<table>
    <c:forEach items="${users}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.surname}</td>
            <td><a href="/user/remove/${p.id}">usuń</a></td>
            <td><a href="/user/edit/${p.id}">edytuj</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
