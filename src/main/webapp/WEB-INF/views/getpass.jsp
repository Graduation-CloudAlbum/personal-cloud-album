<%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2019-03-21
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>找回密码 - 1024Album </title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/index.css">
</head>

<body>
<div class="wrapper-bg"><img class="wrapper-bg-img" src="">
    <div class="wrapper-bg-drop"></div>
</div>
<div class="wrapper wrapper0">
    <div class="box box-getpass">
        <h1 class="logo logo-s"><a href="/pca/user/index" class="ico-logo icoIndex">找回密码</a></h1>
        <div class="form center">
            <div class="input-div"><input id="i-input-email" class="i-txt i-input" placeholder="请输入邮箱" name="email" data-vaild="email" value="" type="text"> <span class="i-warn i-warn-txt"></span> <span class="i-warn i-warn-ico"></span></div>
        </div>
        <div class="fns center">
            <a class="link-btn btn-sure" id="getPass">找回密码</a>
        </div>
        <div class="result"></div>
    </div>
</div>
<div class="wrapper-bar">
    <div class="inner-bg inner-gap"></div>
    <div class="inner-bg inner-drop"></div>
    <div class="wrapper-bar inner-left">©2019 1024album <a href="http://www.miitbeian.gov.cn" target="_blank">渝ICP备19003347号</a>
        <span style="padding-left:10px"></span>
    </div>
    <div class="inner-right">
        <a href="/pca/user/index"  class="link"><span class="link-drop"></span> <span class="link-txt">首页</span></a>
        <a href="/pca/user/login"  class="link"><span class="link-drop"></span> <span class="link-txt">登录</span></a>
        <a href="/pca/user/register"  class="link"><span class="link-drop"></span> <span class="link-txt">注册</span></a>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js" ></script>
</body>

</html>
