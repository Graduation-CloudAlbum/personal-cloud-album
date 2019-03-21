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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册 - 1024Album </title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/index.css">
</head>

<body>
<div class="wrapper-bg"><img class="wrapper-bg-img" src="">
    <div class="wrapper-bg-drop"></div>
</div>
<div class="wrapper wrapper0">
    <div class="box box-register">
        <h1 class="logo logo-s"><a href="/pca/user/index"  class="ico-logo icoIndex">注册1024Album</a></h1>
        <div class="form center">
            <div class="input-div">
                <input id="i-input-email" class="i-txt i-input" placeholder="请输入邮箱，用于登录和找回密码" name="email" data-vaild="email" value="" type="text">
            </div>
                <div class="input-div">
                    <input id="i-input-password" class="i-txt i-input" placeholder="请输入密码,6-12位字母加数字组合" name="password" data-vaild="spwd" value="" type="password">
            </div>
        </div>
        <div class="fns center">
            <a class="link-btn btn-sure" onclick="register();">立即注册</a>
            <%--<input type="button" value="验证" onclick="YanZhen()" />--%>
        </div>
        <div class="tip center">
            <div class="txt txt-left invitation-tips"></div>
            <div class="txt txt-right">已有账号，
                <a href="/pca/user/login">立即登录</a>
            </div>
        </div>
        <div class="result"></div>
    </div>
</div>
<div class="wrapper-bar">
    <div class="inner-bg inner-gap"></div>
    <div class="inner-bg inner-drop"></div>
    <div class="inner-right">
        <a href="/pca/user/index"  class="link"><span class="link-drop"></span> <span class="link-txt">首页</span></a>
        <a href="/pca/user/login"  class="link"><span class="link-drop"></span> <span class="link-txt">登录</span></a>
        <a href="/pca/user/getpass" class="link"><span class="link-drop"></span> <span class="link-txt">找回密码</span></a>
    </div>
</div>
</div>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/register.js" ></script>
</body>

</html>