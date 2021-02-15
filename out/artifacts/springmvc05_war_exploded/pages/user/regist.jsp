<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>尚硅谷会员注册页面</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" />
    <link rel="stylesheet" href="static/css/register.css" />
    <style type="text/css">
      .login_form {
        height: 420px;
        margin-top: 25px;
      }
    </style>
<%--    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>--%>
    <script type="text/javascript" >
        /*
            jQuery操作DOM【】
            visibility: hidden;  隐藏
            visibility: visible  显示
         */
        $(function () {


            //恢复提示框默认情况
            $(".errMess").css("visibility","hidden");

            //用ajax验证用户名已存在
            // $("#username").change(function () {
            //     //获取用户名
            //    var username =  $(this).val();
                //发送请求
                // $.ajax({
                //     type:"post",
                //     data:{"username":username},
                //     dataType:"text",
                //     url:"UserServlet?method=checkUsername",
                //     success:function (rc) {
                //         //回显数据
                //         if(rc=="true"){
                //             $("#unMsg").html("用户名可用").css("visibility","visible");;
                //         }else {
                //             $("#unMsg").html("用户名已存在，请重新输入").css("visibility","visible");;
                //         }
                //     },
                //     error:function () {
                //         alert("请求失败");
                //     }
                // });
            // });


            //用户名已存在提示
            var msg = "${requestScope.msg}";
            <%--var msg = "<%=request.getAttribute("msg")%>";--%>
            // alert(msg+"!"+typeof(msg));
            if(msg == ""){
              $("#unMsg").css("visibility","hidden");
            }else{
              $("#unMsg").css("visibility","visible");
            }

            //验证码错误提示
            var msg2 = "${requestScope.codeMsg}";

            <%--alert(msg2+"!"+typeof(msg2));--%>
            <%--var zz= ${empty msg2};--%>
            <%--alert(zz);--%>
            <%--if(zz){--%>
            <%--   alert("hidden");--%>
            if (msg2 == ""){
                $("#codeMsg").css("visibility","hidden");
            }else{
                $("#codeMsg").css("visibility","visible");
            }

            //定义用户名&密码正则规则
            var regUap = /^\w{6,18}$/;
            /*
              验证用户名
             */
            function checkUserName(){
                $("#unMsg").css("color","#ff0000");
                //获取用户名
                var username = $("#username").val();

                //验证用户名是否合法
                if(regUap.test(username) == false){
                   $("#unMsg").html("用户名只能是字母（大小写）、数字、_。6-18位").css("visibility","visible");
                   return false;
                }else{
                   // $("#unMsg").css("visibility","hidden");
                    $.ajax({
                        type:"post",
                        data:{"username":username},
                        dataType:"text",
                        url:"checkUsername",
                        success:function (rc) {
                            //回显数据
                            if(rc=="true"){
                                $("#unMsg").html("用户名可用").css({"visibility":"visible",color:"#00ff00"});
                            }else {
                                $("#unMsg").html("用户名已存在，请重新输入").css("visibility","visible");
                            }
                        },
                        error:function () {
                            alert("请求失败");
                        }
                    });
                }
            }
            /*
              验证密码
             */
            function checkPwd(){
                //获取密码
                var pwdValue = $("#pwd").val();
                if(!regUap.test(pwdValue)){
                  $("#pwdMsg").css("visibility","visible");
                  return false;
                }else{
                  $("#pwdMsg").css("visibility","hidden");
                }
            }

            /*
              验证确认密码
             */
            function checkPwdRep(){
                //获取密码
                var pwd = $("#pwd").val();
                //获取确认密码
                var pwdRep = $("#pwdRep").val();
                if(pwd != pwdRep){
                  $("#pwdRepMsg").css("visibility","visible");
                  return false;
                }else{
                  $("#pwdRepMsg").css("visibility","hidden");
                }

            }

            /*
            验证邮箱
             */
            function checkEmail(){
                //获取邮箱
                var email = $("#email").val();
                //定义邮箱正则规则
                var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if(!emailReg.test(email)){
                  $("#emailMsg").css("visibility","visible");
                  return false;
                }else{
                  $("#emailMsg").css("visibility","hidden");
                }

            }


            //用户名change事件
            $("#username").change(checkUserName);
            //密码change事件
            $("#pwd").change(checkPwd);
            //确认密码change事件
            $("#pwdRep").change(checkPwdRep);
            //邮箱change事件
            $("#email").change(checkEmail);


            //注册单击事件
            $("#btnSub").click(checkUserName);
            $("#btnSub").click(checkPwd);
            $("#btnSub").click(checkPwdRep);
            $("#btnSub").click(checkEmail);

        });

    </script>

  </head>
  <body>
    <div id="login_header">
      <a href="index.jsp">
        <img class="logo_img" alt="" src="static/img/logo.gif" />
      </a>
    </div>

    <div class="login_banner">
      <div class="register_form">
        <h1>注册尚硅谷会员</h1>
        <form action="regist" method="post">
<%--          <input type="hidden" name="method" value="regist">--%>
          <div class="form-item">
            <div>
              <label>用户名称:</label>
              <input value="${param.username}" id="username" name="username" type="text" placeholder="请输入用户名" />
<%--                <input value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>" id="username" name="username" type="text" placeholder="请输入用户名" />--%>

            </div>
            <span id="unMsg" class="errMess">${requestScope.msg==null?"用户名只能是字母（大小写）、数字、_。6-18位":requestScope.msg}</span>
<%--              <span id="unMsg" class="errMess"><%=request.getAttribute("msg")==null?"用户名只能是字母（大小写）、数字、_。6-18位":request.getAttribute("msg")%></span>--%>
          </div>
          <div class="form-item">
            <div>
              <label>用户密码:</label>
              <input id="pwd" name="pwd" type="password" placeholder="请输入密码" />
            </div>
            <span id="pwdMsg" class="errMess">密码只能是字母（大小写）、数字、_。6-18位</span>
          </div>
          <div class="form-item">
            <div>
              <label>确认密码:</label>
              <input id="pwdRep" type="password" placeholder="请输入确认密码" />
            </div>
            <span id="pwdRepMsg" class="errMess">密码两次输入不一致</span>
          </div>
          <div class="form-item">
            <div>
              <label>用户邮箱:</label>
              <input value="${param.email}" id="email" name="email" type="text" placeholder="请输入邮箱" />
            </div>
            <span id="emailMsg" class="errMess">请输入正确的邮箱格式</span>
          </div>
          <div class="form-item">
            <div>
              <label>验证码:</label>
              <div class="verify">
                <input name="verifyCode" type="text" placeholder="" />
                <img src="KaptchaServlet" alt="" height="40px" width="100px" />
              </div>
            </div>
            <span id="codeMsg" class="errMess">请输入正确的验证码</span>
          </div>
          <button id="btnSub" class="btn">注册</button>
        </form>
      </div>
    </div>
    <div id="bottom">
      <span>
        尚硅谷书城.Copyright &copy;2015
      </span>
    </div>
  </body>
</html>
