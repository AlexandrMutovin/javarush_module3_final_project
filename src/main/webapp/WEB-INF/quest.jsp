<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link type="image/x-icon" href="${pageContext.request.contextPath}/img/favicon.ico" rel="shortcut icon">
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <title>Итоговый проект третьего модуля. Прохождение квеста</title>
</head>
<body>

<div class="container h-100 gradient-form .bg-body" style="background-color: #fff;">
    <div class="row justify-content-md-center"><img src="${pageContext.request.contextPath}/img/lotus.webp"
                                                    style="width: 185px;" alt="logo"></div>
    <div class="list-group">
        <span class="list-group-item list-group-item-action active">${user.question.text}</span>
    </div>
    <c:forEach items="#{user.question.answerList}" var="answer">
        <div class="list-group">
            <a href="${pageContext.request.contextPath}/quest?nextQuestion=${answer.nextQuestionId}&endQuest=${answer.trueAnswer}"
               class="list-group-item list-group-item-action">${answer.text}</a>
        </div>
    </c:forEach>
    <div class="list-group">
        <span class="list-group-item list-group-item-action">
             <p>Статистика:</p>

            <p>Имя пользователя: ${user.userName}</p>
            <p>Количество записей на курс: ${user.successfulQuest}</p>
            <p>ip адрес пользователя: ${user.ipAddress}</p>

</span>


    </div>
</div>

</body>
</html>

</body>
</html>
