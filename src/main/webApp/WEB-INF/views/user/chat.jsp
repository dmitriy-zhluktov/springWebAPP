<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet" />
    <title>Admin part</title>
</head>
<body>
<div id="container">
    <div id="header">
        <div id="navigtion">
            <ul class="nav">
            </ul>
        </div>
        <div id="message-box">
            <c:if test="${not empty sessionScope.message}">
                <span class="info-message"><c:out value="${sessionScope.message}"/></span>
                <c:remove var="message" scope="session" />
            </c:if>

            <c:if test="${not empty sessionScope.error}">
                <span class="error-message"><c:out value="${sessionScope.error}"/></span>
                <c:remove var="error" scope="session" />
            </c:if>
        </div>
    </div>

    <div id="content">
        <div id="chat">
            <div class="messages">

            </div>
            <input type="text" name="text" placeholder="Введите сообщение" class="message-input"/>
            <button type="button" class="msg-button">отпрвить</button>
        </div>
    </div>

    <div id="footer">
        <p>Попячтесь!</p>
    </div>
</div>
</body>
</html>