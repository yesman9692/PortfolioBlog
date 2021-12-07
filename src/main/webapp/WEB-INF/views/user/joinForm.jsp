<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" placeholder="Enter username" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <div class="form-group">
            <label for="email">E-mail:</label>
            <input type="text" class="form-control" placeholder="Enter E-mail" id="email">
        </div>
    </form>
    <button id="btn-join" class="btn btn-primary">회원가입</button> <%--user.js로 넘김--%>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>


