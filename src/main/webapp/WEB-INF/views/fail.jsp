<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.yznu.pca.model.User" %>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //request.getSession().getAttribute("user");
    request.setCharacterEncoding("UTF-8");
    User user= (User) request.getSession().getAttribute("user");
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>空间不足 - 1024Album</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/jquery-confirm.min.css"/>
</head>
<body>

<div class="wrapper">
    <div class="header">
        <img src="<%=basePath%>/resource/img/logo.png">
        <div class="header-right">
            <div id="friends-Verification" class="header-menu-li"><span class="icon iconfont my-xiaoxi">&#xe629;</span>我的消息
                <input type="text" id="friendNumber" class="friendNumber" value="${newFriendNumber }"></div>
        </div>
        <div class="header-right2"><span class="icon iconfont" title="退出" id="logout">&#xe64c;</span></div>
    </div>

    <div class="content">
        <div class="left">
            <a id="navMenu2" class="left-admin" href="/pca/user/personalData"><img src="<%=user.getUserIcon()%>"><p><%=user.getNickName()%></p></a>
            <a id="navMenu1" class="left-li" href="/pca/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
            <a id="navMenu3" class="left-li" href="/pca/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
            <a id="navMenu4" class="left-li" href="/pca/recycleBin/myRecycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
            <div class="nav-button"></div>
        </div>
        <!-- right -->
        <div class="main-container">
            <div class="content-wrap">
        <h2>
            抱歉，您的可用空间已不足，请选择<a href="/pca/user/personalData">扩容服务</a>或者<a href="/pca/album/albumInfo">删除已有照片</a>
        </h2>
            </div>

        </div>


    </div>
</div>
<!-- ***************************************************弹窗 ***************************************************-->
<!-- ***************************************************弹窗 好友验证***************************************************-->

<div id="Verification" class="Verification">
    <div class="Verification-header"><span>我的消息</span><i id="iconChacha10" class="iconfont icon-chacha1"></i></div>
    <ul id="Verification-menu" class="content-menu">
        <li id="accept" class="content-menu-li"><a>发出的请求</a></li>
        <li id="send" class="content-menu-li"><a>收到的验证</a></li>
    </ul>
    <div class="Verification-about">
        <table id="accept-Verification" class="Verification-table">
            <tr class="">
                <th class="col-md-2">好友名称</th>
                <th class="col-md-6">请求内容</th>
                <th class="col-md-2">状态</th>
                <th class="col-md-2">操作</th>
            </tr>
            <tbody id="sandFriendVerifications">
            </tbody>
        </table>
        <table id="send-Verification" class="Verification-table">
            <tr class="">
                <th class="col-md-2">好友名称</th>
                <th class="col-md-6">验证消息</th>
                <th class="col-md-2">操作</th>
            </tr>
            <tbody id="receiveFriendVerifications">
            </tbody>
        </table>
		<div class="content-about5 table1"><img src="<%=basePath%>/images/con-empty.png"><p>暂无记录</p></div>
        <div class="content-about5 table2"><img src="<%=basePath%>/images/con-empty.png"><p>暂无记录</p></div>
    </div>
</div>

<!-- ***************************************************添加好友-》选择好友分组 ***************************************************-->
<div id="accept-friends" class="accept-friends">
    <div class="popup-header"><h4>将好友添加至--</h4><i id="iconChacha30" class="iconfont icon-chacha1"></i></div>
    <div id="accept-friends-left" class="select-first1">我的好友分组</div>
    <div id="accept-friends-right" class="select-right1"><span><i class="iconfont icon-iconfontjiantou jiantou"></i></span></div>
    <ul id="accept-friends-group" class="menu-group1">
        <c:forEach items="${friendgroup}" var="friendgroup">
            <li class="menu-group-li1">${friendgroup.permissionType}</li>
        </c:forEach>
    </ul>
    <div id="accept-friends-button1" class="default-button1"><p>取消</p></div><div id="accept-friends-button2" class="default-button2"><p>确定</p></div>
</div>
<div id="popLayer" class="popLayer"></div>
<div id="popLayer2" class="popLayer2"></div>
</div>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-confirm.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/friends-Verification.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/logout.js"></script>
</body>
</html>
