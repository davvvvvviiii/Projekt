<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 26.05.2024
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PlayerToTeam</title>
</head>
<body>
    <c:forEach items="${players}" var="p">
        <table>
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.surname}</td>
            <td><a href="/team/addToTeam/${teamId}/${p.id}">Dodaj</a></td>
        </tr>
        </table>
    </c:forEach>
</body>
</html>
