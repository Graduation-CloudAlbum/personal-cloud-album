<%@ page import="cn.yznu.pca.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2018-11-28
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    User  user= (User) request.getSession().getAttribute("user");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>myFriend</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/personalData.css"/>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <img src="<%=basePath%>/resource/images/logo.png">
        <div class="header-right"><img src="<%=basePath%>/resource/images/default-c.png"><span id="aa"><%=user.getNickName()%></span><i class="iconfont icon-iconfontjiantou jiantou"></i></div>
        <div class="header-right2"><i class="iconfont icon-guanbi1 guanbi"></i></div>
    </div>

    <div class="content">
        <div class="left">
            <a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=basePath%>/resource/images/default-c.png"><p><%=user.getNickName()%></p></a>
            <a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
            <a id="navMenu3" class="left-li" href="<%=basePath%>/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
            <a id="navMenu4" class="left-li" href="<%=basePath%>/user/recycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
            <div class="nav-button"></div>
        </div>
        <!-- right -->
        <div class="main-container">
            <div class="content-header">
                <i class="iconfont icon-weibiaoti--"></i> <span>我的好友</span>
            </div>
            <ul class="content-menu">
                <li class="content-menu-li"><a>添加好友</a></li>
                <li class="content-menu-li"><a>创建分组</a></li>
            </ul>
            <div class="content-about">
            </div>
        </div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="popLayer" class="popLayer"></div>
    <div id="popLayer2" class="popLayer2"></div>
</div>

<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/index.js"></script>
</body>
</html>
