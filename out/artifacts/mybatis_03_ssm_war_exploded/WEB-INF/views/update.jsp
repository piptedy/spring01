<%--
  Created by IntelliJ IDEA.
  User: 杜从文
  Date: 2021/1/11
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>更新员工页面</title>
</head>
<body>
<h1>更新员工</h1>
<form:form action="${pageContext.request.contextPath}/update">
    <input type="hidden" name="_method" value="put"><br>
    员工id：<form:input path="id" readonly="true"></form:input><br>
    员工姓名：<form:input path="lastName" ></form:input><br>
    员工email:<form:input path="email"></form:input><br>
    员工性别：<form:radiobutton path="gender" label="male" value="1"></form:radiobutton>
    <form:radiobutton path="gender" label="female" value="0"></form:radiobutton><br>
    员工部门：<form:select path="dept.id" items="${requestScope.depts}" itemValue="id" itemLabel="name"></form:select><br>
    <input type="submit">

</form:form>
</body>
</html>
