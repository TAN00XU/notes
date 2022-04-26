<%--
  Created by IntelliJ IDEA.
  User: TAN00XU
  Date: 2022/4/15
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>

    <script>
      function loseFocus() {
        $("#input").blur();
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{
            "name":$("username").val()
          },
        success: function (data) {
            alert(data);
        }
      })
      }

    </script>
  </head>
  <body>
  <%--失去焦点就向后台发起请求--%>
  <input type="text" id="username" onblur="loseFocus()">

  </body>
</html>
