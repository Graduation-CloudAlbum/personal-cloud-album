<%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2018-11-28
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="cn.yznu.pca.model.User" %>
<%@ page import="cn.yznu.pca.model.Album" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    User user= (User) request.getSession().getAttribute("user");

%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>myAlbum</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/myAlbum.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/zoom.css" media="all" />
</head>
<body>
<div class="wrapper">
    <div class="header">
        <img src="<%=basePath%>/resource/img/logo.png">
       <div class="header-right">
            <div  id="friends-Verification" class="header-menu-li">
            	<span class="icon iconfont my-xiaoxi">&#xe629;</span>
            	我的消息
            	<input type="text" id="friendNumber" class="friendNumber" value="${newFriendNumber }">
            </div>
            <div class="header-menu-li"><span class="icon iconfont my-xiaoxi">&#xe616;</span>我的积分</div>
            <!-- <span id="aa" class="aa">1732859702</span><i class="iconfont icon-iconfontjiantou jiantou"></i> -->
        </div>
        <div class="header-right2"><span class="icon iconfont" title="退出">&#xe64c;</span></div>
    </div>

    <div class="content">
        <div class="left">
            <a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=user.getUserIcon()%>"><p><%=user.getNickName()%></p></a>
            <a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
            <a id="navMenu3" class="left-li" href="<%=basePath%>friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
            <a id="navMenu4" class="left-li" href="<%=basePath%>/recycleBin/myRecycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
            <div class="nav-button"></div>
        </div>
        <!-- right -->

        <div class="main-container">
            <div class="content-header">
                <i class="iconfont icon-xiangce"></i><span>我的相册</span>
            </div>
            <ul id="myAlbum-menu1" class="content-menu">
                <li class="content-menu-li" id="uploadPhoto1"><a>上传照片</a></li>
                <li class="content-menu-li"  id="uploadPhoto2"><a>创建相册</a></li>
                <li class="content-menu-li uploadPhoto5">
                    <a>排序方式</a>
                    <ul id="album-sort" class="album-sort">
                        <li class="album-sort-li">按相册名称排序</li>
                        <li class="album-sort-li">按相册主题排序</li>
                        <li class="album-sort-li">按更新时间排序</li>
                    </ul>
                </li>
            </ul>
            <ul id="myAlbum-menu2" class="content-menu">
                <li class="content-menu-li"><a id="uploadPhoto3">上传照片</a></li>
                <li class="content-menu-li"><a id="uploadPhoto4">相册信息</a></li>
                <li id="uploadPhoto6" class="content-menu-li"><a>批量管理</a></li>
                <div id="admin-button" class="admin-button">
                    <button id="button3" class="btn admin-button-li" onclick="downLoadImg()">下载</button>
                    <div id="button1" class="btn admin-button-li uploadPhoto7">移动
                        <ul id="admin-button-menu" class="album-sort2">
                            <%--<li class="album-sort-li">我的家人</li>--%>
                            <%--<li class="album-sort-li">我的朋友</li>--%>
                            <%--<li class="album-sort-li">我的同学</li>--%>
                        </ul>
                    </div>

                    <button id="button2" class="btn admin-button-li">删除</button>
                </div>
            </ul>


            <div class="content-wrap">
                <ul id="myAlbum-content" class="content-about">


                </ul>
                <ul id="myAlbum-content2" class="content-about2 gallery">

                    <%--<div class="content-about2-li">--%>
                        <!-- <span class="icon iconfont photo-admin">&#xe627;</span> -->
                        <%--<a href="<%=basePath%>/resource/img/gallery/DSC_0008-660x441.jpg"><img src="<%=basePath%>/resource/img/gallery/DSC_0008-69x69.jpg" /></a>--%>
                    <%--</div>--%>
                    <%--<div class="content-about2-li">--%>
                        <!-- <span class="icon iconfont photo-admin">&#xe627;</span> -->
                        <%--<a href="<%=basePath%>/resource/img/gallery/DSC_0014-660x441.jpg"><img src="<%=basePath%>/resource/img/gallery/DSC_0014-69x69.jpg" /></a>--%>
                    <%--</div>--%>
                    <%--<div class="content-about2-li">--%>
                        <!-- <span class="icon iconfont photo-admin">&#xe627;</span> -->
                        <%--<a href="<%=basePath%>/resource/img/gallery/DSC_0019-660x441.jpg"><img src="<%=basePath%>/resource/img/gallery/DSC_0019-69x69.jpg" /></a>--%>
                    <%--</div>--%>
                    <%--<div class="content-about2-li">--%>
                        <!-- <span class="icon iconfont photo-admin">&#xe627;</span> -->
                        <%--<a href="<%=basePath%>/resource/img/gallery/DSC_0061-660x441.jpg"><img src="<%=basePath%>/resource/img/gallery/DSC_0061-69x69.jpg" /></a>--%>
                    <%--</div>--%>

                </ul>
                <div class="content-button">
                    <div class="content-button-fenge"></div>
                    <span id="open">(共0个相册)</span><span id="open2">(共0张照片)</span>
                </div>
                <div class="content-footer"></div>
            </div>
        </div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="upload-photos" class="upload-photos">
        <div class="upload-photos-pop">
            <div class="upload-photos-pop-header">
                <span id="upload-album-choose">上传照片至:</span><i id="icon-chacha1" class="iconfont icon-chacha1"></i>
            </div>
            <div class="upload-photos-pop-content">
                <form action="/pca/image/upload"  method='post' enctype='multipart/form-data' id="upload-form">
                    <ul  id="dd" class="upimgcontent"></ul>

                    <label id="upload-photos-pop-content-button" class="upload-photos-pop-content-button" for="doc0"><p>点击选择图片</p></label>

                    <div id="upload-photos-pop-content-footer" class="upload-photos-pop-content-footer">
                        <div class="content-button-fenge"></div><span>可将相片拖拽至以上选择框，每次最多上传500张相片</span>
                    </div>
                    <div id="upload-photos-pop-content-footer2" class="upload-photos-pop-content-footer2 fileinput-wrap">
                        <%--<span>共一张相片（4.31K）</span>--%>

                        <input  class="inputfile" type="file" name="files" multiple="multiple" id="doc0" imgid="img0" onchange="javascript:setImagePreviews()" />
                        <label for="doc0" class="btn btn-default footer-button1">继续添加</label>


                        
                        <div id="send-style" class="send-style">
                            <lable class="btn btn-info footer-button2">选择上传方式</lable>
                            <li id="send-style-li1" class="btn btn-default send-style-li1">定时上传</li>
                            <li id="send-style-li2" class="btn btn-default send-style-li2">实时上传</li>
                        </div>


                        <input type="datetime-local" id="logOutTime" name="logOutTime" />
                        <label id="nowTime" class="btn btn-info footer-button3" type="submit"><p>定时上传</p></label>

                        <button id="nextTime" class="btn btn-info footer-button3"  type="submit"><p>开始上传</p></button>
                    </div>                
                           
                </form>


            </div>
        </div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="upload-photos-choose" class="upload-photos-choose">
            <div class="popup-header"><h4>选择相册</h4><i id="iconChacha2" class="iconfont icon-chacha1"></i></div>
            <div id="upload-photos-left" class="select-first">请选择相册</div>
            <div id="upload-photos-right" class="select-right"><span><i class="iconfont icon-iconfontjiantou jiantou"></i></span></div>
            <ul id="upload-menu-group" class="upload-menu-group">
                <%--<li class="upload-menu-group-li">陌生人</li>--%>
                <%--<li class="upload-menu-group-li">家人</li>--%>
                <%--<li class="upload-menu-group-li">同事</li>--%>
            </ul>
            <div id="select-button" class="select-button"><p>下一步</p></div>
        </div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="Create-Album">
        <div class="popup-header"><h4>创建相册</h4><i id="iconChacha3" class="iconfont icon-chacha1"></i></div>
        <input id="Create-Album-input" type="text" placeholder="请输入相册名称"  name="">
        <input id="Create-Album-input2" type="text" placeholder="请输入相册主题"  name="">
        <div class="create-radio">
            <input type="radio" name="identity" value="公开" checked="checked" />公开
            <input type="radio" name="identity" value="私有" />私有
        </div>
        <div class="Create-Album-button1" id="Create-Album-button1"><p>取消</p></div><div id="Create-Album-button2" class="Create-Album-button2"><p>确定</p></div>
    </div>
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

    </div>
</div>

<!-- ***************************************************确认移动分组***************************************************-->
        <div id="choose-group" >
            <div class="popup-header"><h4>移动分组</h4><i id="iconChacha9" class="iconfont icon-chacha1"></i></div>
            <div class="choose-group-ok">将照片移动至相册<span id="choose-group-span">我的朋友</span></div>
            <div class="Create-Album-button1" id="choose-group-button1"><p>取消</p></div><div class="Create-Album-button2"><p id="move">确定</p></div>
        </div>
        <!-- ***************************************************删除选中***************************************************-->
        <div id="delete-group" >
            <div class="popup-header"><h4>删除照片</h4><i id="iconChacha11" class="iconfont icon-chacha1"></i></div>
            <div class="choose-group-ok"><span>将照片移至回收站</span></div>
            <div class="Create-Album-button1" id="delete-group-button1"><p>取消</p></div><div class="Create-Album-button2" onclick="deleteImg()"><p>确定</p></div>
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

		<!-- ***************************************************相册信息***************************************************-->
		<div id="mod-album" class="mod-album bdR3" style="margin-top: -150px; opacity: 1;">
			<div class="cover">
				<a class="cover-link mod-click">
					<img class="pic" src="../img/Album-cover1.jpg">
					<span class="num-bg op30 bdRc"></span>
					<span class="num-bg-txt f16">0</span>
					<span class="cover-bg op60"></span>
					<span class="cover-bg-txt f16">更换封面</span>
				</a>
			</div>
			<div class="info">
				<div class="text">
					<p class="title">gjhj</p>
					<p class="intro clrB6 lh24">暂无相册简介</p>
					<p class="time">2019-03-08 12:00:00</p>
				</div>
				<div class="fns clearFix">				 
					<a id="close-mod" class="btn-cancel icoMod fR" title="关闭" ><i class="icon iconfont icon-chacha"></i></a>
					<a class="btn-sure icoMod fR mod-click"  title="修改相册信息"><i class="icon iconfont icon-bianji"></i></a>
				</div>
			</div>
		</div>
<!--/******************************************************************************删除相册**********************************************/-->
		<div id="delete-album" class="accept-friends">
			<div class="popup-header"><h4>删除相册</h4><i id="iconChacha12" class="iconfont icon-chacha1"></i></div>
			<div id="delete-album-content" class="select-first1-ok">确认删除相册<span id="delete-album-group">家人</span>?</div>		
			<div id="delete-album-button1" class="default-button1"><p>取消</p></div><div id="delete-album-button2" class="default-button2"><p>确定</p></div>
		</div>




<!-- ***************************************************遮罩层***************************************************-->
    <div id="popLayer" class="popLayer"></div>
    <div id="popLayer2" class="popLayer2"></div>




</div>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/myAlbum.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/friends-Verification.js"></script>
</body>
</html>