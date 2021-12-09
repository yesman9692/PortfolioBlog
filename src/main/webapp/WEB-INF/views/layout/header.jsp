<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>양원석의 포트폴리오</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%--    summer note--%>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="/">HOME</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <c:choose><%--JSTL 조건문--%>
        <c:when test="${empty principal}"> <%--만약 세션이 없다면--%>
            <ul class="navbar-nav"><%--네비게이션 바에서 로그인, 회원가입만 보여줌--%>
                <li class="nav-item">
                    <a class="nav-link" href="/auth/loginForm">로그인</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/auth/joinForm">회원가입</a>
                </li>
            </ul>
        </c:when>
        <c:otherwise><%--세션이 있다면--%>
            <ul class="navbar-nav">
                <li class="nav-item"><%--네비게이션 바에서 글쓰기, 회원정보, 로그아웃 보여줌--%>
                    <a class="nav-link" href="/board/saveForm">글쓰기</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/updateForm">회원정보</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">로그아웃</a>
                </li>
            </ul>
        </c:otherwise>
        </c:choose>
    </div>
</nav>