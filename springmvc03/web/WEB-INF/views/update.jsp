<%--
  Created by IntelliJ IDEA.
  User: 杜从文
  Date: 2020/12/29
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加员工页面</title>
</head>
<body>
<h1>修改员工</h1>
<%--    <form:form action="${pageContext.request.contextPath}/update">--%>
<%--        <input type="hidden" name="_method" value="put">--%>
<%--        员工id：<form:input path="id" readonly="true"></form:input><br>--%>
<%--        员工姓名：<form:input path="lastName"></form:input><br>--%>
<%--        员工邮箱：<form:input path="email"></form:input><br>--%>
<%--        员工性别：<form:radiobutton path="gender" value="1" label="男"></form:radiobutton>--%>
<%--                    <form:radiobutton path="gender" value="0" label="女"></form:radiobutton><br>--%>
<%--        员工部门：<form:select path="department.id" items="${requestScope.depts}"--%>
<%--                          itemValue="id" itemLabel="departmentName"></form:select>--%>
<%--        <br><br>--%>
<%--        <input type="submit">--%>

<%--    </form:form>--%>
    <form action="${pageContext.request.contextPath}/update" method="post">
        <input type="hidden" name="_method" value="put"><br>
        员工id：<input type="text" name="id" readonly="true" value="${requestScope.command.id}"><br>
        员工姓名：<input type="text" name="lastName" value="${requestScope.command.lastName}"><br>
        员工邮箱：<input type="text" name="email" value="${requestScope.command.email}"><br>
        员工性别：<input type="radio" name="gender" value="1" checked="checked">男
<%--        猜想：单选框的回显在传统form中：在jQuery代码中根据${requestScope.command.gender}来判断设置checked属性--%>
                <input type="radio" name="gender" value="0">女<br>
        员工部门：<select name="department.id" >
                    <c:forEach items="${requestScope.depts}" var="dept">
                        <option value="${dept.id}">${dept.departmentName}</option>
                    </c:forEach>

                </select>

    </form>
        
</body>
</html>
