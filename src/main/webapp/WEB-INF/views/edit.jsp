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
                        <h3>Создать тему</h3>
                    </div>
                    <form class="form-horizontal" action="<c:url value='/edit?topic_id=${topicid}'/>"
                          method="post">
                        <fieldset>

                            <div class="form-group">
                                <div class="col-md-4">
                                    <input id="name" type="text" name="name" placeholder="Заголовок темы"
                                           class="form-control input-md">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-4">
                                    <textarea class="form-control" name="text"
                                              placeholder="Текст сообщения"></textarea>
                                </div>
                            </div>

                            <div hidden class="form-group">
                                <div class="col-md-4">
                                    <textarea class="form-control" name="username"
                                    >${username}</textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-4 control-label" for="singlebutton"></label>
                                <div class="col-md-4">
                                    <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-primary">
                                        Создать тему
                                    </button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
