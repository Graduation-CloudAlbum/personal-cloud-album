<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.getSession().getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>myFriend</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/myFriend.css"/>
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
				<a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=basePath%>/resource/img/default-c.png"><p>1732859702</p></a>
				<a id="navMenu1" class="left-li" href="<%=basePath%>/album/albumInfo"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
				<a id="navMenu3" class="left-li" href="<%=basePath%>/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
				<a id="navMenu4" class="left-li" href="<%=basePath%>/recycleBin/myRecycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
				<div class="nav-button"></div>
			</div>
			<!-- right -->
			<div class="main-container">		
				<div class="content-header">
					<i class="iconfont icon-weibiaoti--"></i> <span>江川</span><span>的相册空间</span>
				</div>
				<ul class="content-menu">
					<li class="content-menu-li"><a>返回</a></li>
				</ul>
				<div class="content-wrap">
					<ul class="content-about">
						<li class="friends-about-li">
							<img src="<%=basePath%>/resource/img/1.jpg">
							<p>小明</p>
						</li>
						
					</ul>
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
