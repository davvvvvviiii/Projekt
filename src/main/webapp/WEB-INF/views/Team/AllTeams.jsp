<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 26.05.2024
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All teams</title>
    <style>
        table{
            border: 1px solid;
            margin: 0 auto;
            width: 50%;
            border-collapse: collapse;
        }

    </style>
</head>
<body>
<a href="/home">Wróć do menu</a><br>
    <c:forEach items="${teams}" var="p">
        <table>
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td><c:forEach items="${team.players}" var="player">
                    ${player.name} ${player.surname}<br/>
                </c:forEach>
                </td>
                <td><a href="/team/remove/${p.id}">usuń</a></td>
                <td><a href="/team/edit/${p.id}">Edytuj</a></td>
                <td><a href="/team/addPlayer/${p.id}">Dodaj zawodnika</a></td>
                <td><a href="/team/showPlayers/${p.id}">Lista zawodników</a></td>
            </tr>
        </table>
    </c:forEach>
</body>
</html>
