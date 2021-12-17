<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container" style="border-right: solid 1px lightgray; border-left: solid 1px lightgray">
    <br>
    <h2 class="boardTitle">방명록</h2>
    <hr>
    <c:forEach var="visitBoard" items="${visitBoard.content}">
        <div class="container-fluid">
            <div class="col-sm-8" style="height: 100px; overflow: hidden; text-overflow: ellipsis;">
                <h4 class="card-title">
                    <a href="/visitBoard/${visitBoard.id}">${visitBoard.title}</a>
                </h4>
                <p class="card-text">${visitBoard.content}</p>
            </div>
            <hr>
        </div>
    </c:forEach>

    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${visitBoard.first}">
                <li class="page-item disabled"><a class="page-link " href="?page=${visitBoard.number-1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link " href="?page=${visitBoard.number-1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <li class="page-item"><a class="page-link" href="?page=0">1</a></li>
        <li class="page-item"><a class="page-link" href="?page=1">2</a></li>
        <li class="page-item"><a class="page-link" href="?page=2">3</a></li>
        <c:choose>
            <c:when test="${visitBoard.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${visitBoard.number+1}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${visitBoard.number+1}">Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
    <button type="button" class="btn btn-outline-primary" onclick="location.href='/board/visitBoardWriteForm'" style="float: right">글 쓰기</button>
    <br>
    <br>


</div>

<%@ include file="../layout/footer.jsp" %>


