<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>1024Album - 记录生活 留住感动</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/index.css">
</head>
<body>
<div class="wrapper wrapper0 screen-wrap">
    <div class="screen-page screen-page-h">
        <div class="box"><h1 class="logo">
            <a href="/pca/user/index"  class="ico-logo icoIndex" ></a>
        </h1>
            <!--<h2 class="intro icoIndex">记录你一生的精彩时光</h2>-->
            <div class="fns">
                <a class="link-btn btn-register" href="/pca/user/register" >注册</a>
                <a class="link-btn btn-login" href="/pca/user/login">登录</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js" ></script>
</body>
</html>
