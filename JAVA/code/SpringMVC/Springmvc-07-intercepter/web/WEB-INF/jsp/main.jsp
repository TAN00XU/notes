<%--
  Created by IntelliJ IDEA.
  User: TAN00XU
  Date: 2022/4/20
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<span>${username}</span>
<h1>首页</h1>
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
</body>
</html>
