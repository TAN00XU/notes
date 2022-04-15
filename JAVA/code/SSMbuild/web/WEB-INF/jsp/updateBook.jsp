<%--
  Created by IntelliJ IDEA.
  User: TAN00XU
  Date: 2022/4/13
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <script	src="/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/book/updateBook" method="post">

            <input type="hidden" name="bookID" value="${book.bookID}">

            <div class="form-group">
                <label for="bookName">书籍名称：</label>
                <input type="text" name="bookName" class="form-control" id="bookName" value="${book.bookName}" required>
            </div>
            <div class="form-group">
                <label for="cookCounts">书籍数量：</label>
                <input type="text" name="bookCounts" class="form-control" id="cookCounts" value="${book.bookCounts}" required>
            </div>
            <div class="form-group">
                <label for="detail">书籍详情：</label>
                <input type="text" name="detail" class="form-control" id="detail" value="${book.detail}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改" >
            </div>

        </form>


    </div>


</div>

</body>
</html>
