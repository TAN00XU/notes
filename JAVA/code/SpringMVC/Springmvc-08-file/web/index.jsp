<%--
  Created by IntelliJ IDEA.
  User: TAN00XU
  Date: 2022/4/26
  Time: 11:19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit">
  </form>
  <a href="/download">点击下载</a>
  </body>
</html>
