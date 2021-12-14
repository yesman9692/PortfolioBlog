<%@ include file="layout/header.jsp" %>

<div class="container" style="border-right: solid 1px lightgray; border-left: solid 1px lightgray">
    <c:forEach var="board" items="${boards.content}">
        <div class="container-fluid">
            <h1>${board.title}</h1>
            <div class="row" style="margin-bottom: 10px; margin-top: 10px">
                <img class="col-sm-4" src="/assets/img/portfolio/1.png" style="height: 185px;"></img>
                <div class="col-sm-8" style="height: 185px; overflow: hidden; text-overflow: ellipsis;">
                    <h4 class="card-title">${board.title}</h4>
                    <p class="card-text">${board.content}</p>
                </div>
            </div>
            <hr>
        </div>
    </c:forEach>

    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link " href="?page=${boards.number-1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link " href="?page=${boards.number-1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <li class="page-item"><a class="page-link" href="?page=0">1</a></li>
        <li class="page-item"><a class="page-link" href="?page=1">2</a></li>
        <li class="page-item"><a class="page-link" href="?page=2">3</a></li>
        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul>

</div>

<%@ include file="layout/footer.jsp" %>


