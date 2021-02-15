<%--
  Created by IntelliJ IDEA.
  User: 杜从文
  Date: 2020/12/29
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>显示所有员工</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.9.1.min.js"></script>
    <script>
        $(function () {
            $(".del").click(function () {
                var name = $(this).attr("id");
                flag = confirm("你真的删除【"+name+"】的记录吗？");
                if(flag){
                    var herf = $(this).attr("href");
                    $("#deleteForm").attr("action",herf);
                    $("#deleteForm").submit();
                }

                return false;
            });
        })
    </script>
</head>
<body>
    <form action="" method="post" id="deleteForm">
        <input type="hidden" name="_method" value="delete">
    </form>


    <center>
        <c:if test="${empty requestScope.emps}">
            <h1>没有员工</h1>
        </c:if>
        <c:if test="${not empty requestScope.emps}">
            <h1>员工信息</h1>
            <table border="1" cellpadding="10" cellspacing="0">
                <tr>
                    <th>Id</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Department</th>
                    <th colspan="2">Operate</th>
                </tr>
                <c:forEach var="emp" items="${requestScope.emps}">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.lastName}</td>
                        <td>${emp.email}</td>
                        <td>
                            <c:if test="${emp.gender==1}">男</c:if>
                            <c:if test="${emp.gender==0}">女</c:if>
                        </td>
                        <td>${emp.department.departmentName}</td>
                        <td><a href="${pageContext.request.contextPath}/update/${emp.id}">Edit</a></td>
                        <td><a id="${emp.lastName}" class="del" href="${pageContext.request.contextPath}/delete/${emp.id}">Delete</a></td>
                    </tr>
                </c:forEach>


            </table>
            <hr>
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/addEmployee">addEmployee</a>
        </c:if>
    </center>

</body>
</html>
