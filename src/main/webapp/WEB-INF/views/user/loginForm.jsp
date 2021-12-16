<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ include file="../layout/header.jsp" %>--%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" text="text/css" />
    <title>로그인</title>
</head>
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
<%----%>
<div class="card align-middle" style="width:20rem; border-radius:20px;">
    <div class="card-title" style="margin-top:30px;">
        <h3 class="card-title text-center" style="color:#113366;">로그인이 필요합니다</h3>
    </div>
    <div class="card-body">
        <form class="form-signin" action="/auth/loginProc" method="post" style="margin-bottom: 7px">
            <h5 class="form-signin-heading">로그인 정보를 입력하세요</h5>
            <input type="text" name="username" class="form-control" placeholder="Your ID" required autofocus>
            <BR>
            <input type="password" name="password" style="margin-bottom: 10px" class="form-control" placeholder="Password" required>
            <p style="font-size: small; text-align: center">비밀번호는 Spring Security로 <br>암호화되어 안전하게 저장됩니다.</p>

            <button id="btn-login" class="btn btn-lg btn-primary btn-block">로 그 인</button>
        </form>

        <button id="btn-join" type="button" class="btn btn-lg btn-outline-primary btn-block" onclick="location.href='/auth/joinForm'">회 원 가 입</button>

    </div>
</div>
<div class="modal">
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
<%--
<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <label for="username">Username:</label>

            <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        &lt;%&ndash;<div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" name="remember" type="checkbox"> Remember me
            </label>
        </div>&ndash;%&gt;
&lt;%&ndash;        <button id="btn-login" class="btn btn-primary">로그인</button>&ndash;%&gt;
    </form>

</div>--%>
<%--<%@ include file="../layout/footer.jsp" %>--%>


