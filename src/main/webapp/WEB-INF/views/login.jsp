<%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2018-09-28
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    String username=request.getParameter("username");
    session.setAttribute("username", username);
    String password=request.getParameter("password");
    session.setAttribute("password", password);

%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录 - 1024Album </title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/index.css">
</head>

<body>

<div class="wrapper wrapper0">
    <div class="box box-login">
        <h1 class="logo logo-s"><a href="/pca/user/index"  class="ico-logo icoIndex">登录1024Album</a></h1>
        <div class="form center">
            <div class="input-div"><input id="i-input-email" class="i-txt i-input" placeholder="请输入邮箱" name="email" data-vaild="email" value="" type="text"> <span class="i-warn i-warn-txt"></span> <span class="i-warn i-warn-ico"></span></div>
            <div class="input-div"><input id="i-input-password" class="i-txt i-input" placeholder="请输入密码" name="password" data-vaild="spwd" value="" type="password"> <span class="i-warn i-warn-txt"></span> <span class="i-warn i-warn-ico"></span></div>
        </div>
        <div class="fns center">
            <a class="link-btn btn-sure" onclick="login()">登录</a>
        </div>
        <div class="tip center">
            <div class="txt txt-right">
                <a href="/pca/user/register" >立即注册</a><span>或</span>
                <a href="/pca/user/getpass" >找回密码</a>
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
        <a href="/pca/user/register" class="link"><span class="link-drop"></span> <span class="link-txt">注册</span></a>
        <a href="/pca/user/getpass"  class="link"><span class="link-drop"></span> <span class="link-txt">找回密码</span></a>
    </div>
</div>

<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/login.js" ></script>
</body>

</html>
