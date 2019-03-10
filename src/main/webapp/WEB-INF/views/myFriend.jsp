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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>myFriend</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/myFriend.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>

</head>
<body>
<div class="wrapper">
    <div class="header">
        <img src="<%=basePath%>/resource/img/logo.png">
        <div class="header-right"><img src="<%=basePath%>/resource/img/default-c.png"><span id="aa"><%=user.getNickName()%></span><i class="iconfont icon-iconfontjiantou jiantou"></i></div>
        <div class="header-right2"><i class="iconfont icon-guanbi1 guanbi"></i></div>
    </div>

    <div class="content">
        <div class="left">
            <a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=basePath%>/resource/img/4.jpg"><p><%=user.getNickName()%></p></a>
            <a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
            <a id="navMenu3" class="left-li" href="<%=basePath%>/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
            <a id="navMenu4" class="left-li" href="<%=basePath%>/recycleBin/myRecycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
            <div class="nav-button"></div>
        </div>
        <!-- right -->
        <div class="main-container">
            <div class="content-header">
                <i class="iconfont icon-weibiaoti--"></i> <span>我的好友</span>
            </div>
            <ul class="content-menu">
                <li id="menu-frends1" class="content-menu-li"><a>创建分组</a></li>
                <li id="menu-frends2" class="content-menu-li"><a>添加好友</a></li>
                <li id="menu-frends3" class="content-menu-li"><a>删除分组</a></li>
            </ul>
            <div class="content-wrap">
                <div class="content-about">
                    <ul class="friends-content">
                        <c:forEach items="${allfriend}" var="node">
                            <li class="friends-content-li"><img src="<%=basePath%>${node.friend.userIcon}"><p>${node.friend.nickName}</p></li>
                        </c:forEach>
                    </ul>


                    <div class="friends-header">我的好友列表</div>
                    <ul class="content-about-menu">
                        <c:forEach items="${friendgroup}" var="friendgroup">
                            <li  class="content-about-menu-li" onclick="selectOnde('${friendgroup.permissionType}','<%=path%>',this)">${friendgroup.permissionType}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->





    <!-- ***************************************************弹窗创建分组 ***************************************************-->
    <div id="Create-friends-group">
        <div class="popup-header"><h4>创建分组</h4><i id="iconChacha4" class="iconfont icon-chacha1"></i></div>
        <div class="qq">
            <div id="select-first" class="select-first"><p>选择分组</p></div>
            <div id="select-right" class="select-right">
                <span>
                    <i class="iconfont icon-iconfontjiantou jiantou"></i>
                </span>
            </div>
            <ul id="menu-group" class="menu-group">
                <li id="select-second" class="menu-group-li">我的家人</li>
                <li id="select-third" class="menu-group-li">我的同事</li>
                <li id="select-four" class="menu-group-li">我的同学</li>
            </ul>
        </div>
        <div class="Create-friends-button1" id="Create-friends-button1"><p>取消</p></div><div id="Create-friends-button2" class="Create-friends-button2"><p>确定</p></div>
    </div>
    <!-- ***************************************************弹窗添加搜索 ***************************************************-->
   <div id="create-friends" class="create-friends">
        <div class="create-friends-pop">
            <div class="create-friends-pop-header">
                <span>添加好友</span><i id="iconChacha5" class="iconfont icon-chacha1"></i>
            </div>
            <div class="create-friends-pop-content">
                <input id="Create-friends-input" type="text" placeholder="请输入好友名称"  name="Create-friends-input">
                <div id="search-i" class="search-i"><span class="icon iconfont">&#xe60b;</span></div>
                <ul id="search-content" class="search-content">

                </ul>
            </div>
        </div>
    </div>
  <!-- ***************************************************弹窗添加好友 ***************************************************-->
     <div id="friendVerification">
            <div class="popup-header"><h4 id="showNickname"></h4><i id="iconChacha6" class="iconfont icon-chacha1"></i></div>
            <div id="Verification-text" class="Verification-text">
                <p class="Verification-title">请输入验证消息：</p>
                <textarea id="Validationmessage" class="search-text" rows="3" >我是...</textarea>
                <div id="Verification-next" class="Create-friends-button2"><p>下一步</p></div>
            </div>
            <div id="Verification-group">
                <p class="Verification-title2">请选择列表：</p>
                <div id="friendVerification-left" class="select-first"><p>我的分组</p></div>
                <div id="friendVerification-right" class="select-right"><span><i class="iconfont icon-iconfontjiantou jiantou"></i></span></div>
                <ul id="friendVerification-group" class="menu-group friendVerification-group">
                    <c:forEach items="${friendgroup}" var="friendgroup">
                        <li  class="menu-group-li" >${friendgroup.permissionType}</li>
                    </c:forEach>
                </ul>
                <div class="Create-friends-button1" id="friendVerification-button1"><p>返回</p></div><div id="friendVerification_button2" class="Create-friends-button2"><p>确定</p></div>
            </div>
        </div>
    <div id="popLayer" class="popLayer"></div>
    <div id="popLayer2" class="popLayer2"></div>
    <!-- ***************************************************弹窗删除分组 ***************************************************-->
    <div id="Manage-friends-group">
        <div class="popup-header"><h4>删除分组</h4><i id="iconChacha7" class="iconfont icon-chacha1"></i></div>
        <div class="qq">
            <div id="select-manage-first" class="select-manage-first"><p>选择分组</p></div>
            <div id="select-manage-right" class="select-manage-right">
                <span>
                    <i class="iconfont icon-iconfontjiantou jiantou"></i>
                </span>
            </div>
            <ul id="menu-manage-group" class="menu-manage-group">
                <c:forEach items="${friendgroup}" var="friendgroup">
                    <li  class="menu-group-li" >${friendgroup.permissionType}</li>
                </c:forEach>
            </ul>
        </div>
        <div class="Create-friends-button2" id="Manage-group-button1"><p>取消</p></div><div id="Manage-group-button2" class="Create-friends-button2"><p>确定</p></div>
    </div>



</div>

<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/addfriend.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/myFriend.js"></script>
</body>
</html>
