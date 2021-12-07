<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <label for="title">Username:</label>
            <input type="text" class="form-control" placeholder="Enter title" id="title">
        </div>
        <div class="form-group">
            <label for="content">content:</label>
            <textarea class="form-control summernote" rows="5" id="content"></textarea>
        </div>

        <script>
            $('.summernote').summernote({
                tabsize: 2,
                height: 300
            });
        </script>
    </form>
    <button id="btn-save" class="btn btn-primary">글쓰기 완료</button>

</div>

<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>


