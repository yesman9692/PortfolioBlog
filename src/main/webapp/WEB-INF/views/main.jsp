<%@ include file="layout/header.jsp" %>

<div class="container" style="border-right: solid 1px lightgray; border-left: solid 1px lightgray">
    <c:forEach var="board" items="${boards}">
    <div class="container-fluid">
        <h1>Two Unequal Responsive Columns</h1>
        <div class="row" style="margin-bottom: 10px; margin-top: 10px">
            <img class="col-sm-4" src="/assets/img/portfolio/1.png" style="height: 185px;"></img>
            <div class="col-sm-8" style="height: 185px; overflow: hidden; text-overflow: ellipsis;">
                <h4 class="card-title">What is Lorem Ipsum?</h4>
                <p class="card-text">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem
                    Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took
                    a galley of type and scrambled it to make a type specimen book. It has survived not only five
                    centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was
                    popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and
                    more recently with desktop publishing software like Aldus PageMaker including versions of Lorem
                    Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has
                    been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley
                    of type and scrambled it to make a type specimen book. It has survived not only five centuries, but
                    also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in
                    the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently
                    with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
            </div>
        </div>
        <hr>
        </c:forEach>

    </div>
</div>

<%@ include file="layout/footer.jsp" %>


