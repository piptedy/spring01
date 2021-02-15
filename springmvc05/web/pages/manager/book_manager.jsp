<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <script type="text/javascript" >
      $(function () {
        $(".del").click(function () {
          var title1 = $(this).attr("name");
         var choice= confirm("你真想删除["+title1+"]该书吗？");
         if(choice==false){
           return false;
         }
        })

        $("#btnId").click(function () {
          var input_pageNo= $("#inputId").val();

          location = "BookServlet?method=getPageByNo&pageNo=" +input_pageNo;
        })
      })
    </script>

    <link rel="stylesheet" href="static/css/minireset.css" />
    <link rel="stylesheet" href="static/css/common.css" />
    <link rel="stylesheet" href="static/css/cart.css" />
    <link rel="stylesheet" href="static/css/bookManger.css" />
  </head>
  <body>

    <div class="header">
      <div class="w">
        <div class="header-left">
          <a href="index.jsp">
            <img src="static/img/logo.gif" alt=""
          /></a>
          <h1>图书管理系统</h1>
        </div>
        <%@ include file="/WEB-INF/include/header.jsp"%>
      </div>
    </div>
    <div class="list">
      <div class="w">
        <div class="add">
          <a href="pages/manager/book_edit.jsp">添加图书</a>
        </div>
        <table>
          <thead>
            <tr>
              <th>图片</th>
              <th>商品名称</th>
              <th>价格</th>
              <th>作者</th>
              <th>销量</th>
              <th>库存</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
<%--          <c:forEach items="${requestScope.page.list}" var="book">--%>
          <c:forEach items="${requestScope.list}" var="book">
            <tr>
              <td>
                <img src=${book.imgPath} alt="" />
              </td>
              <td>${book.title}</td>
              <td>
                ${book.price}
              </td>
              <td>${book.author}</td>
              <td>${book.sales}</td>
              <td>${book.stock}</td>

              <td>
                <a href="getBookById/${book.id}">修改</a><a name="${book.title}" href="delBook/${book.id}" class="del">删除</a>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        <div class="footer">
          <div class="footer-right">
            <a class="footer-right" href="BookServlet?method=getPageByNo&pageNo=1">首页</a>
            <c:if test="${requestScope.page.pageNo>1}">
              <a class="footer-right" href="BookServlet?method=getPageByNo&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            </c:if>
           <c:if test="${requestScope.page.pageNo<requestScope.page.totalPageNo}">
             <a class="footer-right" href="BookServlet?method=getPageByNo&pageNo=${requestScope.page.pageNo+1}">下一页</a>
           </c:if>


            <a class="footer-right" href="BookServlet?method=getPageByNo&pageNo=${requestScope.page.totalPageNo}">末页</a>
            <span>共${requestScope.page.pageNo}/${requestScope.page.totalPageNo}页</span>
<%--            <span>第${requestScope.page.pageNo}/${requestScope.pTage.otalPageNo}页</span>--%>
            <span>共${requestScope.page.totalRecord}条记录</span>
            <span>到第</span>
            <input id="inputId" value="${requestScope.page.pageNo}" type="text" />
            <span>页</span>t
            <button id="btnId">确定</button>
          </div>
        </div>
      </div>
    </div>
    <div class="bottom">
      <div class="w">
        <div class="top">
          <ul>
            <li>
              <a href="">
                <img src="static/img/bottom1.png" alt="" />
                <span>大咖级讲师亲自授课</span>
              </a>
            </li>
            <li>
              <a href="">
                <img src="static/img/bottom.png" alt="" />
                <span>课程为学员成长持续赋能</span>
              </a>
            </li>
            <li>
              <a href="">
                <img src="static/img/bottom2.png" alt="" />
                <span>学员真是情况大公开</span>
              </a>
            </li>
          </ul>
        </div>
        <div class="content">
          <dl>
            <dt>关于尚硅谷</dt>
            <dd>教育理念</dd>
            <!-- <dd>名师团队</dd>
            <dd>学员心声</dd> -->
          </dl>
          <dl>
            <dt>资源下载</dt>
            <dd>视频下载</dd>
            <!-- <dd>资料下载</dd>
            <dd>工具下载</dd> -->
          </dl>
          <dl>
            <dt>加入我们</dt>
            <dd>招聘岗位</dd>
            <!-- <dd>岗位介绍</dd>
            <dd>招贤纳师</dd> -->
          </dl>
          <dl>
            <dt>联系我们</dt>
            <dd>http://www.atguigu.com</dd>
            <dd></dd>
          </dl>
        </div>
      </div>
      <div class="down">
        尚硅谷书城.Copyright ©2015
      </div>
    </div>
  </body>
</html>
