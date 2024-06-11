<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 05.06.2024
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
    <style>
        #controlPanel{
            float: left;
            width: 70%;
            padding: 20px;
            border: 1px solid;
            box-shadow: black;

        }
        li{
            font-size: x-large;
        }
        #userInf{
            border: 1px solid;
            padding: 20px;
            float: right;
            width: 20%;
        }
    </style>
</head>
<body>
    <div id="controlPanel">
        <ul>
            <li><a href="/player/menu">Zarządzanie zawodnikami</a></li>
            <li><a href="/team/menu">Zarządzanie druzyną</a></li>
            <li><a href="/discipline/menu">Zarządzanie zawodami</a></li>
        </ul>
    </div>
    <div id="userInf">
        <sec:authorize access="isAuthenticated()">
            <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
            <p>Posiada role: <sec:authentication property="authorities"/></p>
        </sec:authorize><br>
            <form action="<c:url value="/logout"/>" method="post">
                <button type="submit">Wyloguj</button>
            </form>
    </div>
</body>
</html>
