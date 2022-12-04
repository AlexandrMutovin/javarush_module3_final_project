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
<section class="h-100 gradient-form" style="background-color: #eee;">

    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-10">
                <div class="card rounded-3 text-black">
                    <div class="row g-0">
                        <div class="col-lg-6">
                            <div class="card-body p-md-5 mx-md-4">
                                <div class="text-center">
                                    <img src="${pageContext.request.contextPath}/img/lotus.webp"
                                         style="width: 185px;" alt="logo">
                                    <h4 class="mt-1 mb-5 pb-1">Страница авторизации</h4>
                                </div>

                                <form th:action="${pageContext.request.contextPath}" method="post">

                                    <p>Пожалуйста, авторизуйтесь в системе</p>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="form2Example11" class="form-control"
                                               placeholder="Введите логин" name="username"/>
                                    </div>

                                    <div class="text-center pt-1 mb-5 pb-1">
                                        <input type="submit"
                                               class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3"
                                               value="Войти"></input>

                                    </div>


                                </form>

                            </div>
                        </div>
                        <div class="col-lg-6 d-flex align-items-center  bg-warning bg-success p-2 bg-opacity-50">
                            <div class="text-  px-3 py-4 p-md-5 mx-md-4">

                                <h5 class="mb-5">Итоговый проект третьего модуля</h5>

                                <p class="small mb-0">Данное приложение разработано как итоговый проект третьего модуля
                                    по изучению языка программирования Java на
                                    <a target="_blank" href="https://javarush.com.ua" style="color: coral"><b>JAVARUSH.COM.UA</b>
                                    </a>.
                                </p>

                                <p class="small mb-0">Участнику квеста необходимо ввести свой логин. Если логин будет найден в системе и
                                    ранее участкник остановился на каком-то
                                    из этапов, он будет перенаправлен на место останова. Если же квест начинается
                                    впервые или ранее был пройден, он начнется сначала.
                                </p>

                                <p class="small m-0"> Результатом квеста будет успешное его прохождение или нет.</p>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
