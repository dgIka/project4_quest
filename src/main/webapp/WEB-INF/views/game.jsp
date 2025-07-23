<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Текстовый квест - Игра</title>
    <style>
        p {
            white-space: pre-wrap;
            word-wrap: break-word; /* перенос строк */
            max-width: 600px;
        }
        .heart {
            color: red;
            font-size: 24px; /* сердечки */
            margin-right: 5px;
        }
        .health-message {
             color: red;
             font-style: italic;
         }
    </style>
</head>
<body>
<h1>Игра</h1>
<p><c:out value="${sceneText}"/></p>
<c:if test="${healthDecreased}">
    <p class="health-message">Теряешь <span class="heart">♥</span></p>
</c:if>
<div>
    Здоровье:
    <c:forEach begin="1" end="${hp}">
        <span class="heart">♥</span>
    </c:forEach>
</div>
<form action="game" method="post">
    <c:forEach var="option" items="${options}">
        <input type="radio" name="choice" value="${option.result}" id="option${option.id}"/>
        <label for="option${option.id}">${option.text}</label><br/>
    </c:forEach>
    <br/>
    <input type="submit" value="Подтвердить"/>
</form>
</body>
</html>