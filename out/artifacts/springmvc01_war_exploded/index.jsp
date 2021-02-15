<%--
  Created by IntelliJ IDEA.
  User: 杜从文
  Date: 2020/12/26
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <a href="${pageContext.request.contextPath}/helloworld">Hello SpringMVC</a><br>
  <a href="${pageContext.request.contextPath}/dontStopMeNow">dontStopMeNow</a><br>
  <a href="${pageContext.request.contextPath}/dontStopMeNow/1000">rest风格的请求参数</a><br>

  <form action="${pageContext.request.contextPath}/dontStopMeNow" method="post">

    <input type="submit">
  </form>
  <form action="${pageContext.request.contextPath}/doGet" method="get">

    <input type="submit" value="doGet">
  </form>
  <form action="${pageContext.request.contextPath}/doPost" method="post">

    <input type="submit" value="doPost">
  </form>
  <form action="${pageContext.request.contextPath}/doPut" method="post">

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="doPut">
  </form>
  <form action="${pageContext.request.contextPath}/doDelete?username=sb&password=sb123" method="post">

  <input type="hidden" name="_method" value="delete">
  <input type="submit" value="doDelete">
  </form>

  </body>
</html>
