<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 25.05.2024
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Players</title>
    <style>
        table{
            border: 1px solid ;
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
        }
    </style>
</head>
<body>
<a href="/home">Wróć do menu</a><br>
    <table>
        <c:forEach items="${players}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.surname}</td>
                <td><a href="/player/remove/${p.id}">usuń</a></td>
                <td><a href="/player/edit/${p.id}">Edytuj</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
