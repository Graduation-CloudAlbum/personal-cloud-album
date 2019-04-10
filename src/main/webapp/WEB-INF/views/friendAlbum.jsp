<%@ page import="cn.yznu.pca.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	User user= (User) request.getSession().getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>myFriend</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/personalData.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/myAlbum.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/friendAlbum.css"/>
	<link rel="stylesheet"  href="<%=basePath%>/resource/css/zoom.css" media="all" />
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<img src="<%=basePath%>/resource/img/logo.png">
			<div class="header-right">
				<div id="friends-Verification" class="header-menu-li"><span class="icon iconfont my-xiaoxi">&#xe629;</span>我的消息</div>
				<div class="header-menu-li"><span class="icon iconfont my-xiaoxi">&#xe616;</span>我的积分</div>
				<!-- <span id="aa" class="aa">1732859702</span><i class="iconfont icon-iconfontjiantou jiantou"></i> -->
			</div>
			<div class="header-right2"><span class="icon iconfont" title="退出">&#xe64c;</span></div>
		</div>

		<div class="content">
			<div class="left">	
				<a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=user.getUserIcon()%>"><p>1732859702</p></a>
				<a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
				<a id="navMenu3" class="left-li" href="<%=basePath%>/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
				<a id="navMenu4" class="left-li" href="<%=basePath%>/recycleBin/myRecycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
				<div class="nav-button"></div>
			</div>
			<!-- right -->
			<div class="main-container">
				
				<div class="content-header">
					<i class="iconfont icon-weibiaoti--"></i><a href="../html/friendAlbum.html"> <span >江川的相册空间</span></a>
				</div>
				<ul class="content-menu" >

					<%--<div class="content-about-personal" style="width: 100%;height: 100px" >--%>


						<%--&lt;%&ndash;<div class="content-about-personal-num1"><p style="text-align: center" class="content-about-personal-num-p1">个人签名</p></div>&ndash;%&gt;--%>
						<%--&lt;%&ndash;<div class="content-about-personal-num2"><p style="text-align: center" class="content-about-personal-num-p1">撒旦发射点</p></div>&ndash;%&gt;--%>
					<%--</div>--%>
						<li class="content-menu-li" href="<%=basePath%>/friend/myFriend"><a>删除好友</a></li>
						<li class="content-menu-li" href="<%=basePath%>/friend/myFriend"><a>移动好友</a></li>
						<li class="content-menu-li" href="<%=basePath%>/friend/myFriend"><a>返回</a></li>
				</ul>

				<div class="content-wrap">
					<div class="content-about">
						<div class="content-about-personal">
							
							<label for="img2" class="img-lable">
								<img id="image2" src="<%=basePath%>/img/default-c.png">
								
							</label>
							<p class="content-about-personal-admin">1732859703</p>
							<p class="content-about-personal-desc">“床前明月光，疑是地上霜，举头望明月，低头思故乡。”</p>
							<div class="content-about-personal-num1"><p class="content-about-personal-num-p1">4</p><p class="content-about-personal-num-p2">相册数</p></div>
							<div class="content-about-personal-num2"><p class="content-about-personal-num-p1">26</p><p class="content-about-personal-num-p2">相片数</p></div>
							<div class="content-about-personal-num3"><p class="content-about-personal-num-p1">0</p><p class="content-about-personal-num-p2">相同好友数</p></div>	
						</div>
						
					</div>
					<div>
						<ul id="myAlbum-content" class="content-about-friendAlbum" >
						</ul>
					</div>
					<ul id="myAlbum-content2" class="content-about2 gallery">
					</ul>
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
				
			</div>
		</div>	










		<div id="popLayer" class="popLayer"></div>
		<div id="popLayer2" class="popLayer2"></div>




	</div>




	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/resource/js/friendAlbum.js"></script>
	<script src="<%=basePath%>/resource/js/jquery-2.0.3.min.js"></script>
	<script src="<%=basePath%>/resource/js/zoom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/resource/js/friends-Verification.js"></script>
</body>
</html>
