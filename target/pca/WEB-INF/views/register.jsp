<%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2018-09-28
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/register.css">
</head>
<body>
<div class="bg1"></div>
<div class="gyl">
    个人云相册

    <div class="gy2" >分享生活 留住感动 </div>
</div>
<div class="bg">
    <div class="wel">用户注册</div>
    <div class="user">
        <div  style="">用&nbsp;&nbsp;户&nbsp;&nbsp;名</div>
        <input  id="username" type="text" name="用户"  placeholder="4-8为小写字母+数字组合" />
        <span id="user_hint"></span>
    </div>
    <div class="password" >
        <div  >密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</div>
        <input id="password" class="" type="password" name="密码" placeholder="6-16位小写字母+数字组合" />
        <span id="password_hint"></span>
    </div>
     <div class="password_2" >
         <div  >确认密码</div>
         <input id="password_2" class="" type="password" name="确认密码" placeholder="确认密码" />
         <span id="confirm_hint"></span>
</div>
    <div class="fg" >
        <div style="font-size: 11px;margin-top: 11px;">
            <a style="font-size: 11px;" href="<%=basePath%>/user/login">已有账号？登录</a>
        </div>
    </div>
    <div class="alert alert-danger hide" id="alertMessage">
        <strong style="font-size: 15px">注册失败 请重试</strong>
    </div>

    <input id="reg" class="btn" type="button" name="注册" value="注册"/>
</div>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/register.js" ></script>
</body>

</html>
