<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <br>
    <form>
        <input type="hidden" id="socialId" value="${socialBoard.id}">
        <div class="form-group">
            <input value=${socialBoard.title} type="text" class="form-control" placeholder="Enter title" id="title">
        </div>
        <div class="form-group">
            <textarea class="form-control summernote" rows="5" id="content">${socialBoard.content}</textarea>
        </div>

        <script>
            $('.summernote').summernote({
                tabsize: 2,
                height: 300
            });
        </script>
    </form>
    <button id="btn-social-update" class="btn btn-primary">글수정 완료</button>

</div>

<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>


