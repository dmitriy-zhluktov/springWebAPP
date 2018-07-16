<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet" />
    <title>User part</title>
    <script type="text/javascript">
        var socketConnection = new WebSocket('ws://localhost:8080/socketEndpoint');;
        var clientMsg;
        var msgList;

        function init() {
            clientMsg = document.getElementById('user-message');
            msgList = document.getElementById('message-list');
        }

        //Send Message
        function sendMessage() {
            if (clientMsg.value) {
                socketConnection.send(clientMsg.value);
                addMessageToList('Я: ' + clientMsg.value);
                clientMsg.value = '';
            }
        }

        // Receive Message
        socketConnection.onmessage = function(event) {
            addMessageToList('Одмен: ' + event.data);
        }

        function addMessageToList(message) {
            var li = document.createElement('li');
            li.appendChild(document.createTextNode(message));
            msgList.appendChild(li);
        }
    </script>
</head>
<body onload="init();">
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
                <h5>Тут будет история переписки</h5>
                <ul id="message-list"></ul>
            </div>
            <input type="text" name="text" id="user-message" placeholder="Введите сообщение" class="message-input"/>
            <button type="button" class="msg-button" onclick="sendMessage();">отпрвить</button>
        </div>
    </div>

    <div id="footer">
        <p>Попячтесь!</p>
    </div>
</div>
</body>
</html>