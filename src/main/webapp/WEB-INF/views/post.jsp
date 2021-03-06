<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Форум</title>
    <style>
        <%@include file="/WEB-INF/views/css/posts.css" %>
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="wrapper wrapper-content animated fadeInRight">

                <div class="ibox-content m-b-sm border-bottom">
                    <div class="p-xs">
                        <div class="pull-left m-r-md">
                            <i class="fa fa-globe text-navy mid-icon"></i>
                        </div>
                        <h2>Форум</h2>
                        Здесь вы можете свободно общаться на интересные вам темы.
                        <a href="/index" class="link text-center"> Главная </a>
                        <div style="float:right; top:-20px;" class="alert alert-success">
                            Добро пожаловать, <b>${username}! </b>
                            <a href="/logout" class="link">Выйти</a>
                        </div>
                    </div>
                </div>

                <div class="ibox-content forum-container">

                    <div class="forum-title">
                        <h3>${topic.name} <span style="float:right"><button type="button" class="btn btn-primary" onclick="window.location.href='/edit?topic_id=${topic.id}'">Создать тему</button></span></h3>
                    </div>
                    <c:forEach var="post" items="${posts}">
                    <div class="forum-item active">
                        <div class="row">
                            <div class="col-md-9">
                                <div class="forum-icon">
                                    <i class="fa fa-shield"></i>
                                </div>
                                <a href="/message?id=${post.id}" class="forum-item-title">${post.name}</a>
                                Дата создания: ${post.created}
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
