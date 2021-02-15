<%--
  Created by IntelliJ IDEA.
  User: 杜从文
  Date: 2020/12/29
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加员工页面</title>
</head>
<body>
<h1>添加员工</h1>
    <form:form>
        员工姓名：<form:input path="lastName"></form:input><br>
        员工邮箱：<form:input path="email"></form:input><br>
        员工性别：<form:radiobutton path="gender" value="1" label="男"></form:radiobutton>
                    <form:radiobutton path="gender" value="0" label="女"></form:radiobutton><br>
        员工部门：<form:select path="department.id" items="${requestScope.depts}"
                          itemValue="id" itemLabel="departmentName"></form:select>
        <br><br>
        <input type="submit">

    </form:form>
        
</body>
</html>
