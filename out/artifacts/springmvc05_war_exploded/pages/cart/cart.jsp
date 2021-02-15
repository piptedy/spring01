<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    
    <link rel="stylesheet" href="static/css/minireset.css" />
    <link rel="stylesheet" href="static/css/common.css" />
    <link rel="stylesheet" href="static/css/cart.css" />
  </head>
  <body>
    <div class="header">
      <div class="w">
        <div class="header-left">
          <a href="index.jsp">
            <img src="static/img/logo.gif" alt=""
          /></a>
          <h1>我的购物车</h1>
        </div>
<%@include file="/WEB-INF/include/welcome.jsp"%>
      </div>
    </div>
    <div class="list">
      <div class="w">
        <table>
          <thead>
            <tr>
              <th>图片</th>
              <th>商品名称</th>

              <th>数量</th>
              <th>单价</th>
              <th>金额</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${sessionScope.cart.getCartItems()}" var="cartItem">
            <tr>
              <td>
                <img src="${cartItem.book.imgPath}" alt="" />
              </td>
              <td>${cartItem.book.title}</td>
              <td>
                <span class="count">-</span>
                <input class="count-num" type="text" value="${cartItem.count}" />
                <span class="count">+</span>
              </td>
              <td>${cartItem.book.price}</td>
              <td>${cartItem.amount}</td>
              <td><a href="CartServlet?method=deleteItem&id=${cartItem.book.id}">删除</a></td>
            </tr>
          </c:forEach>


          </tbody>
        </table>
        <div class="footer">
          <div class="footer-left">
            <a href="CartServlet?method=clearCart" class="clear-cart">清空购物车</a>
            <a href="#">继续购物</a>
          </div>
          <div class="footer-right">
            <div>共<span>${sessionScope.cart.totalCount}</span>件商品</div>
            <div class="total-price">总金额<span>${sessionScope.cart.totalAmount}</span>元</div>
            <a class="pay" href="OrderServlet?method=order">去结账</a>
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
