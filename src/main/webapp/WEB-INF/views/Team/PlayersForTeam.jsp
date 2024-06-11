<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10.06.2024
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${playerNames}" var="playerName">
        <tr>
            <td>${playerName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
