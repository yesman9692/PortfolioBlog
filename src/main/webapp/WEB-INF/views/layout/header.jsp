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
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
          type="text/css"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" text="text/css"/>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-nav text-uppercase fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="/main">HOME</a>
        <ul class="navbar-nav">
            <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/">처음으로</a></li>
            <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/board/jobBoard">직무활동</a></li>
            <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/board/socialBoard">사회활동</a></li>
            <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/board/visitBoard">방명록</a></li>
        </ul>
        <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
                aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
            <c:choose>
            <c:when test="${empty principal}">
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/auth/loginForm">로그인</a></li>
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/auth/joinForm">회원가입</a></li>
            </c:when>
            <c:otherwise>
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#portfolio">내 정보</a></li>
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/logout">로그아웃</a></li>
            </c:otherwise>
            </c:choose>
            </ul>
        </div>
    </div>
</nav>


<div class="collapse navbar-collapse" id="collapsibleNavbar">
    <c:choose>
        <c:when test="${empty principal}">
            <ul class="navbar-nav" style="float: right">
                <li class="nav-item">
                    <a class="nav-link" href="/auth/loginForm">로그인</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/auth/joinForm">회원가입</a>
                </li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul class="navbar-nav" style="float: right">
                <li class="nav-item">
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
