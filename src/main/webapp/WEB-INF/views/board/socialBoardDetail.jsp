<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">


    <br>
    <br>
    <div class="form-group">
        <h3>${socialBoard.title}</h3>
    </div>
    <hr/>
    <div class="form-group">
        <div style= "word-break:break-all" >
            ${socialBoard.content}
        </div>
    </div>
    <hr/>
    <button id="btn-return" type="button" class="btn btn-outline-primary" onclick="location.href='/board/socialBoard'" style="float: left">목록</button>
    <button id="btn-delete" type="button" class="btn btn-primary" onclick="location.href='/board/saveForm'" style="float: right">삭제</button>
    <button id="btn-update" type="button" class="btn btn-outline-primary" onclick="location.href='/board/saveForm'" style="float: right; margin-right: 3px">수정</button>
    <br>
    <br>


</div>

<script src="/js/board.js"></script>


<%@ include file="../layout/footer.jsp" %>