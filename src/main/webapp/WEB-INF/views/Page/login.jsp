<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 01.06.2024
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style>
        form{
            border-top: 1px solid;
            border-right: 1px solid;
            border-left: 1px solid;
            padding: 15px;
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
            text-align: center;
        }
        h2{
            text-align: center;
        }
        #error_message{

            border-bottom: 1px solid;
            border-left: 1px solid;
            border-right: 1px solid;
            padding: 15px;
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Logowanie</h2>
<form  method="post" action="<c:url value='/login' />">
    <label for="username">Nazwa użytkownika:</label><br>
    <input type="text" id="username" name="username"><br>
    <br>
    <br>
    <label for="password">Hasło:</label>
    <br>
    <input type="password" id="password" name="password"><br>
    <br>
    <br>
    <input type="submit" value="Zaloguj">
</form>
<div id="error_message">
<c:if test="${not empty loginError}">
    <p style="color: red;">Błędne hasło lub login. Spróbuj ponownie </p><Br>
    lub<br>
    <a href="/user/add"> stwórz konto</a>
</c:if>
</div>
<%--<form action="${pageContext.request.contextPath}/login" method="post">--%>
<%--    <label for="username">Nazwa użytkownika:</label>--%>
<%--    <input type="text" id="username" name="username"><br>--%>

<%--    <label for="password">Hasło:</label>--%>
<%--    <input type="password" id="password" name="password"><br>--%>

<%--    <input type="submit" value="Zaloguj">--%>
<%--</form>--%>
</body>
</html>
