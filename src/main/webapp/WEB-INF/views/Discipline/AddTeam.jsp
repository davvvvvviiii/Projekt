<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10.06.2024
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add team</title>
    <style>
        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
            border: 1px solid;
        }
    </style>
</head>
<body>
<c:forEach items="${teams}" var="p">
    <table>
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td><a href="/discipline/addToDiscipline/${teamId}/${p.id}">Dodaj</a></td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
