<%--
  Created by IntelliJ IDEA.
  User: TAN00XU
  Date: 2022/4/11
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <style>
      a {
        text-decoration: none;
        color: black;
        font-size: 18px;
      }

      h3 {
        width: 180px;
        height: 30px;
        margin: 100px auto;
        text-align: center;
        line-height: 30px;
        background: deepskyblue;
        border-radius: 10px;
      }
    </style>
  </head>
  <body>
  <%--${pageContext.request.contextPath}是JSP取得绝对路径的方法，等价于<%=request.getContextPath()%> 。
也就是取出部署的应用程序名或者是当前的项目名称--%>
  <h3><a href="${pageContext.request.contextPath}/book/allBooks">进入书籍展示页面</a></h3>
  </body>
</html>
