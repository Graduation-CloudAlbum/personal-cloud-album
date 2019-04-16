<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.yznu.pca.model.User" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.getSession().getAttribute("user");
    request.setCharacterEncoding("UTF-8");
    User user= (User) request.getSession().getAttribute("user");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>支付</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
    <script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js"></script>
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
				<a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=user.getUserIcon()%>"><p><%=user.getNickName()%></p></a>
				<a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
				<a id="navMenu3" class="left-li" href="<%=basePath%>/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
				<a id="navMenu4" class="left-li" href="<%=basePath%>/recycleBin/myRecycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
				<div class="nav-button"></div>
			</div>
			<!-- right -->
			<div class="main-container">
				
				<div class="content-header">
					<i class="icon iconfont">&#xe626;</i><a href="../html/friendAlbum.html"> <span >我的支付</span></a>
				</div>
				<div class="content-wrap">
					<form id="payForm" action="/pca/alipay/goAlipay/" method="post" style="width: 50%;height: 400px;padding: 10px;margin-left: 25%;">
					    <input type="hidden" id="orderId" name="orderId" value="${order.id }" />
					    
					    <div>
						    <div style="text-align: center;font-size: 20px;">订单编号: ${order.id}</div>
						    <div style="text-align: centet;text-align: center; margin-top: 54px;">产品名称: ${order.productName}</div>
						    <div style="text-align: centet;text-align: center; margin-top: 54px;">订单价格: ${order.payment}元</div>
						    <input type="submit" value="前往支付宝付款" style="background: #D84C31;color:#fff; border: 1px solid red;padding: 7px 20px;float: right;margin-right: 104px; margin-top: 30px;">
					    </div>
					    
					    <%--<script>--%>
					        <%--function pay() {--%>
					            <%--var orderId = $('input[name=orderId]').val();--%>
					            <%--window.location.href ="/pca/alipay/goAlipay/"+orderId;--%>
					        <%--}--%>
					    <%--</script>--%>
					</form>
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

 <!-- ***************************************************添加好友-》选择好友分组 ***************************************************-->
		<div id="accept-friends" class="accept-friends">
			<div class="popup-header"><h4>陌生人</h4><i id="iconChacha30" class="iconfont icon-chacha1"></i></div>
			<div id="accept-friends-left" class="select-first1">我的好友分组</div>
			<div id="accept-friends-right" class="select-right1"><span><i class="iconfont icon-iconfontjiantou jiantou"></i></span></div>
			<ul id="accept-friends-group" class="menu-group1">
				<li class="menu-group-li1">陌生人</li>
				<li class="menu-group-li1">家人</li> 
				<li class="menu-group-li1">同事</li>
			</ul>
			<div id="accept-friends-button1" class="default-button1"><p>取消</p></div><div class="default-button2"><p>确定</p></div>
		</div>
		<div id="popLayer" class="popLayer"></div>
		<div id="popLayer2" class="popLayer2"></div>




	</div>

	<script type="text/javascript" src="<%=basePath%>/resource/js/jquery.min.js" ></script>
<%--	<script src="<%=basePath%>/resource/js/jquery-2.0.3.min.js"></script>--%>
	<script type="text/javascript" src="<%=basePath%>/resource/js/friends-Verification.js"></script>
	
	
	
	
	

</body>
</html>
