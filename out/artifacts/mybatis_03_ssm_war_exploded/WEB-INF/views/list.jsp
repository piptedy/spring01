<%--
  Created by IntelliJ IDEA.
  User: 杜从文
  Date: 2021/1/10
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有员工</title>
</head>
<body>
    <center>
        <c:if test="${empty requestScope.emps}">
            <h1>没有员工</h1>
        </c:if>
        <c:if test="${!empty requestScope.emps}">
            <table border="1" cellspacing="0" cellpadding="10">
                <tr>
                    <th>Id</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Department</th>
                    <th colspan="2">Operate</th>
                </tr>
                <c:forEach items="${requestScope.emps}" var="emp">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.lastName}</td>
                        <td>${emp.email}</td>
                        <td>
                            <c:if test="${emp.gender == 1}">male</c:if>
                            <c:if test="${emp.gender == 0}">female</c:if>
                        </td>
                        <td>${emp.dept.name}</td>
                        <td><a href="${pageContext.request.contextPath}/update/${emp.id}">Edit</a></td>
                        <td><a href="${pageContext.request.contextPath}/delete/${emp.id}">Delete</a></td>
                    </tr>
                </c:forEach>

            </table>
        </c:if>
        <hr>
        <br>
        <a href="${pageContext.request.contextPath}/addEmp">添加新员工</a>

    </center>
</body>
</html>
