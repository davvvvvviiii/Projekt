<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 30.05.2024
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All disciplines</title>
</head>
<body>
    <table>
        <c:forEach items="${disciplines}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.description}</td>
                <td><a href="/discipline/remove/${p.id}">usuń</a></td>
                <td><a href="/discipline/edit/${p.id}">edytuj</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
