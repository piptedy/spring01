<%--
  Created by IntelliJ IDEA.
  User: 杜从文
  Date: 2020/12/28
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/helloWorld">开始吧</a>
  </body>
<form action="${pageContext.request.contextPath}/pojo" method="post">
  员工编号：<input type="text" name="id"><br>
  员工姓名：<input type="text" name="lastName"><br>
  员工邮箱：<input type="text" name="email"><br>
  员工部门编号：<input type="text" name="dept.id"><br>
  员工部门名称：<input type="text" name="dept.name">
  <input type="submit">
</form><br>
<%--<a href="${pageContext.request.contextPath}/testModelAndView">testModelAndView</a>--%>
<a href="${pageContext.request.contextPath}/testMap">testMap</a>
</html>
