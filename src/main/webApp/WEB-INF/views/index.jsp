<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" />
    <title>
        <c:choose>
            <c:when test="${not empty title}">
                ${title}
            </c:when>
            <c:otherwise>
                Welcome, stranger!
            </c:otherwise>
        </c:choose>
    </title>
</head>
<body>
<div id="content">
    <div class="login-box">
        <form method="post" action="/login">
            <input type="text" name="user">
            <input type="password" name="password"/>
            <button type="submit">Login</button>
        </form>
    </div>
</div>
<div class="footer">
    <p>Попячтесь!</p>
</div>
</body>
</html>