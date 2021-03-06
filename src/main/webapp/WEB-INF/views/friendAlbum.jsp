<%@ page import="cn.yznu.pca.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	User user= (User) request.getSession().getAttribute("user");
	User user1= (User) request.getSession().getAttribute("user1");
	Object friend_albumNum=request.getSession().getAttribute("friend_albumNum");
	Object friend_imageNum2=request.getSession().getAttribute("friend_imageNum2");
	Object friend_friendNum=request.getSession().getAttribute("friend_friendNum");
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>好友相册 - 1024Album</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
	<link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/personalData.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/myAlbum.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/friendAlbum.css"/>
	<link rel="stylesheet"  href="<%=basePath%>/resource/css/zoom.css" media="all" />
	<link rel="stylesheet" href="<%=basePath%>/resource/css/jquery-confirm.min.css"/>
</head>
<body>
<div class="wrapper">
	<div class="header">
		<img src="<%=basePath%>/resource/img/logo.png">
		<div class="header-right">
			<div id="friends-Verification" class="header-menu-li"><span class="icon iconfont my-xiaoxi">&#xe629;</span>我的消息				<input type="text" id="friendNumber" class="friendNumber" value="${newFriendNumber }">
			</div>
<%--			<div class="header-menu-li"><span class="icon iconfont my-xiaoxi">&#xe616;</span>我的积分--%>
<%--			</div>--%>
			<!-- <span id="aa" class="aa">1732859702</span><i class="iconfont icon-iconfontjiantou jiantou"></i> -->
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

			<div class="content-header">
				<i class="iconfont icon-weibiaoti--"></i><a> <span ><%=user1.getNickName()%>的相册空间</span></a>
			</div>
			<ul class="content-menu" >
				<li class="content-menu-li group-menu" href="<%=basePath%>/friend/myFriend">
					<a>移动好友</a>
					<ul id="friend-group" class="friend-group">
						<c:forEach items="${friendgroup}" var="friendgroup">
							<li class="friend-group-li">${friendgroup.permissionType}</li>
						</c:forEach>
					</ul>
				</li>
				<li id="delete-friends" class="content-menu-li" href="<%=basePath%>/friend/myFriend"><a>删除好友</a></li>
				<li class="content-menu-li" ><a href="/pca/friend/myFriend">返回好友</a></li>
				<li id="photo-header" class="table-header5">
					<div id="photo-header1" class="table-header5-li">相册:江川</div>
					<div id="photo-header2" class="table-header5-li">返回相册</div>
				</li>
				
			</ul>

			<div class="content-wrap">
				<div class="content-about">
					<div class="content-about-personal">

						<label  class="img-lable">
							<img id="image2" src="<%=user1.getUserIcon()%>">

						</label>
						<p class="content-about-personal-admin"><%=user1.getUserName()%></p>
						<p class="content-about-personal-desc"><%=user1.getSynopsis()%></p>
						<div class="content-about-personal-num1"><p class="content-about-personal-num-p1"><%=friend_albumNum%></p><p class="content-about-personal-num-p2">相册数</p></div>
						<div class="content-about-personal-num2"><p class="content-about-personal-num-p1"><%=friend_imageNum2%></p><p class="content-about-personal-num-p2">相片数</p></div>
						<div class="content-about-personal-num3"><p class="content-about-personal-num-p1"><%=friend_friendNum%></p><p class="content-about-personal-num-p2">好友数</p></div>
					</div>

				</div>
				<div>
					<ul id="myAlbum-content" class="content-about-friendAlbum" >
					</ul>
				</div>
				<ul id="myAlbum-content2" class="content-about2 gallery">
				</ul>
				<div class="content-about5 photo1"><img src="<%=basePath%>/images/con-empty.png"><p>暂无记录</p></div>
				<div class="content-button">
					<div class="content-button-fenge"></div>
					<span id="open">(共0个相册)</span><span id="open2">(共0张照片)</span>
				</div>

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
<!--/******************************************************************************移动好友**********************************************/-->
<div id="move-friends" class="accept-friends">
	<div class="popup-header"><h4>移动好友</h4><i id="iconChacha11" class="iconfont icon-chacha1"></i></div>
	<div id="move-friends-content" class="select-first1-ok">确认移动好友至<span id="moveFriends-group">陌生人</span>?</div>
	<div id="move-friends-button1" class="default-button1"><p>取消</p></div><div id="move-friends-button2" class="default-button2"><p>确定</p></div>
</div>
<!--/******************************************************************************删除好友**********************************************/-->
<div id="delete-friends-pop" class="accept-friends">
	<div class="popup-header"><h4>删除好友</h4><i id="iconChacha12" class="iconfont icon-chacha1"></i></div>
	<div id="delete-friends-content" class="select-first1-ok">确认删除好友?</div>
	<div id="delete-friends-button1" class="default-button1"><p>取消</p></div><div id="delete-friends-button2" class="default-button2"><p>确定</p></div>
</div>
<div id="popLayer" class="popLayer"></div>
<div id="popLayer2" class="popLayer2"></div>
</div>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-confirm.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/friendAlbum.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/logout.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/friends-Verification.js"></script>
</body>
</html>
