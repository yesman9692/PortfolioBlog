<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <br>
    <br>
    <div class="form-group">
        <h3>${jobBoard.title}</h3>
    </div>
    <small>
        글 번호:<span id="id"><i>${jobBoard.id} </i></span>
        작성자:<span><i>${jobBoard.user.username} </i></span>
    </small>
    <hr/>
    <div class="form-group">
        <div style= "word-break:break-all" >
            ${jobBoard.content}
        </div>
    </div>
    <hr/>
    <button id="job-btn-return" type="button" class="btn btn-outline-primary" onclick="location.href='/board/jobBoard'" style="float: left">목록</button>
    <c:if test="${jobBoard.user.id == principal.user.id}">
        <button id="job-btn-delete" type="button" class="btn btn-primary" style=" float: right">삭제</button>
        <button id="job-btn-update" type="button" class="btn btn-outline-primary" onclick="location.href='/jobBoard/updateForm/' + ${jobBoard.id}" style="float: right; margin-right: 3px">수정</button>
    </c:if>
    <c:if test="${jobBoard.user.id != principal.user.id}">
        <button type="button" class="btn btn-primary" style=" float: right" disabled>삭제</button>
        <button type="button" class="btn btn-outline-primary" style="float: right; margin-right: 3px" disabled>수정</button>
    </c:if>

    <br>
    <br>
</div>

<script src="/js/board.js"></script>


<%@ include file="../layout/footer.jsp" %>