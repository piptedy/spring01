<%--
  Created by IntelliJ IDEA.
  User: 杜从文
  Date: 2020/12/30
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.9.1.min.js"></script>
    <script>
      alert($);
     $(function () {
       $("#postBtn").click(function () {
          $.ajax({
            url:"${pageContext.request.contextPath}/dojson",
            error:function () {
              alert("请求失败");
            },
            success:function (data) {
              alert(data.lastName)
            },
            type:"POST",
            dataType:"json"
          })
       });
     });
    </script>
  </head>
  <body>

    <button id="postBtn">$.post请求</button>
  </body>
</html>
