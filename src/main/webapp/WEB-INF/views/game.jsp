<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Текстовый квест - Игра</title>
    <style> /* перенос текста */
        p {
            white-space: pre-wrap;
            word-wrap: break-word;
            max-width: 600px;
        }
    </style>
</head>
<body>
<h1>Игра</h1>
<p><c:out value="${sceneText}"/></p>
<form action="game" method="post">
    <c:forEach var="option" items="${options}">
        <input type="radio" name="choice" value="${option.id}" id="option${option.id}"/>
        <label for="option${option.id}">${option.text}</label><br/>
    </c:forEach>
    <br/>
    <input type="submit" value="Подтвердить"/>
</form>
</body>
</html>