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
</head>
<body>
    <c:forEach items="${teams}" var="p">
        <table>
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td><c:forEach items="${team.players}" var="player">
                    ${player.name} ${player.surname}<br/>
                </c:forEach>
                </td>
            </tr>
        </table>
    </c:forEach>
</body>
</html>
