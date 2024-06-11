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
            border: 1px solid;
            padding: 15px;
        }

    </style>
</head>
<body>
<%--<form method="post">--%>
<%--    <div><label> User Name : <input type="text" name="surname"/> </label></div>--%>
<%--    <div><label> Password: <input type="password" name="password"/> </label></div>--%>
<%--    <div><input type="submit" value="Sign In"/></div>--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--</form>--%>
<h2>Logowanie</h2>
<form  method="post" action="<c:url value='/login' />">
    <label for="username">Nazwa użytkownika:</label>
    <input type="text" id="username" name="username"><br>

    <label for="password">Hasło:</label>
    <input type="password" id="password" name="password"><br>

    <input type="submit" value="Zaloguj">
</form>
<c:if test="${not empty loginError}">
    <p style="color: red;">Błędne hasło lub login. Spróbuj ponownie </p><Br>
    lub<br>
    <a href="/user/add"> stwórz konto</a>
</c:if>
<%--<form action="${pageContext.request.contextPath}/login" method="post">--%>
<%--    <label for="username">Nazwa użytkownika:</label>--%>
<%--    <input type="text" id="username" name="username"><br>--%>

<%--    <label for="password">Hasło:</label>--%>
<%--    <input type="password" id="password" name="password"><br>--%>

<%--    <input type="submit" value="Zaloguj">--%>
<%--</form>--%>
</body>
</html>
