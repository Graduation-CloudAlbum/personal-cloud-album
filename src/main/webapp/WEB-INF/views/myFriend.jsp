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
        <img src="<%=basePath%>/resource/img/logo.png">
        <div class="header-right"><img src="<%=basePath%>/resource/img/default-c.png"><span id="aa">1732859702</span><i class="iconfont icon-iconfontjiantou jiantou"></i></div>
        <div class="header-right2"><i class="iconfont icon-guanbi1 guanbi"></i></div>
    </div>

    <div class="content">
        <div class="left">
            <a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="../img/default-c.png"><p>1732859702</p></a>
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
                <li class="content-menu-li"><a>创建分组</a></li>
                <li class="content-menu-li"><a>添加好友</a></li>
            </ul>
            <div class="content-wrap">
                <ul class="content-about">
                    <li class="friends-about-li">
                        <img src="<%=basePath%>/resource/img/1.jpg">
                        <p>江川	</p>
                    </li>
                    <li class="friends-about-li">
                        <img src="<%=basePath%>/resource/img/3.jpg">
                        <p>三生三世十里桃花啊</p>
                    </li>
                    <li class="friends-about-li">
                        <img src="<%=basePath%>/resource/img/2.jpg">
                        <p>吴磊	</p>
                    </li>
                    <li class="friends-about-li">
                        <img src="<%=basePath%>/resource/img/4.jpg">
                        <p>迪丽热巴</p>
                    </li>

                    <li class="friends-about-li">
                        <img src="<%=basePath%>/resource/img/5.jpg">
                        <p>胡歌</p>
                    </li>
                    <li class="friends-about-li">
                        <img src="<%=basePath%>/resource/img/6.jpg">
                        <p>西门吹雪</p>
                    </li>


                </ul>
                <div class="content-button">
                    <div class="content-button-fenge"></div>
                    <span>(共50个好友)</span>
                </div>
                <div class="content-footer2"></div>
            </div>


        </div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->











    <div id="popLayer" class="popLayer"></div>
    <div id="popLayer2" class="popLayer2"></div>




</div>

<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/addfriend.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/index.js"></script>
</body>
</html>
