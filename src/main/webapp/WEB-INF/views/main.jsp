<%@ include file="layout/header.jsp" %>

<div class="container" style="border-right: solid 1px lightgray; border-left: solid 1px lightgray">
    <c:forEach var="board" items="${boards}">
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


</div>

<%@ include file="layout/footer.jsp" %>


