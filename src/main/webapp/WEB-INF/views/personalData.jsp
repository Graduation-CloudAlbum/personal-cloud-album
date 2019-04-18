<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2018-11-28
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cn.yznu.pca.model.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    User user= (User) request.getSession().getAttribute("user");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = formatter.format(user.getCreateTime());
    User user1= (User) request.getSession().getAttribute("user1");
    Object albumNum=request.getSession().getAttribute("albumNum");
    Object imageNum=request.getSession().getAttribute("imageNum");
    Object friendNum=request.getSession().getAttribute("friendNum");

%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>personalData</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/personalData.css"/>
    <title>1024Album - 个人中心</title>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <img src="<%=basePath%>/resource/images/logo.png">
        <div class="header-right">
            <div  id="friends-Verification" class="header-menu-li"><span class="icon iconfont my-xiaoxi">&#xe629;</span>我的消息</div>
            <div class="header-menu-li"><span class="icon iconfont my-xiaoxi">&#xe616;</span>我的积分</div>
            <!-- <span id="aa" class="aa">1732859702</span><i class="iconfont icon-iconfontjiantou jiantou"></i> -->
        </div>
        <div class="header-right2"><span class="icon iconfont" title="退出">&#xe64c;</span></div>
    </div>

    <div class="content">
        <div class="left">
            <a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=user1.getUserIcon()%>"><p><%=user1.getNickName()%></p></a>
            <a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
            <a id="navMenu3" class="left-li" href="<%=basePath%>/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
            <a id="navMenu4" class="left-li" href="<%=basePath%>/recycleBin/myRecycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
            <div class="nav-button"></div>
        </div>
        <!-- right -->
        <div class="main-container">
            <div class="content-header">
                <i class="iconfont icon-yonghu"></i> <span>个人资料</span>
            </div>
            <ul class="content-menu">
                <li id="ModifyingData" class="content-menu-li"><a>修改资料</a></li>
                <li id="ChangetheAvatar" class="content-menu-li"><a>更换头像</a></li>
                <li id="ChangePassword" class="content-menu-li"><a>修改密码</a></li>
                <%--<li class="content-menu-li"><a>邀请注册</a></li>--%>
                <li id="Expansion" class="content-menu-li"><a>扩充空间</a></li>
            </ul>
            <div class="content-wrap">
                <div class="content-about">
                    <div class="content-about-personal">
                        <input id="img2" class="inputfile" type="file"onchange="selectImage2(this);"/>
                        <label for="img2" class="img-lable">
                            <img id="image2" src="<%=user1.getUserIcon()%>">
                            <div class="update-img">更换头像</div>
                        </label>
                        <p class="content-about-personal-admin"><%=user1.getNickName()%></p>
                        <div class="content-about-personal-num1"><p class="content-about-personal-num-p1"><%=albumNum%></p><p class="content-about-personal-num-p2">相册数</p></div>
                        <div class="content-about-personal-num2"><p class="content-about-personal-num-p1"><%=imageNum%></p><p class="content-about-personal-num-p2">相片数</p></div>
                        <div class="content-about-personal-num3"><p class="content-about-personal-num-p1"><%=friendNum%></p><p class="content-about-personal-num-p2">好友数</p></div>

                        <%--<div class="content-about-personal-num"><p class="content-about-personal-num-p1">0</p><p class="content-about-personal-num-p2">分享辑</p></div>--%>
                    </div>
                    <div class="content-about-info">
                        <div id="content-about-info-no1" class="content-about-info-no1">
                            <i class="iconfont icon-baojiaquotation2"></i><span><%=user1.getSynopsis()%></span><i class="iconfont icon-baojiaquotation"></i>
                        </div>
                        <div id="content-about-info-no2" class="content-about-info-no2">
                            <p><span>登录账号：<span><%=user1.getUserName()%></span></span></p>
                            <p><span>注册时间：<span><%=formattedDate%></span></span></p>

                            <p><span>登录IP地址：<%=request.getRemoteAddr()%></span></p>
                        </div>
                        <div id="content-about-info-no3" class="content-about-info-no3">
                            <%--<p><span>全部空间：1Tb</span><span>(含扩充空间)</span></p>--%>
                            <%--<p><span>已用空间：1</span><span>Kb  468kb</span></p>--%>
                            <%--<p><span>剩余空间：1023GB1023MB1022KB556B</span></p>--%>
                            <%--<p><span>已用占比：0%</span></p>--%>
                        </div>
                        <ul id="content-about-info-menu" class="content-about-info-menu">
                            <li id="menuLi1"  class="menuLi menuLis">个人简介</li>
                            <li id="menuLi2"  class="menuLi">账户信息</li>
                            <li id="menuLi3"  class="menuLi">空间容量</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ***************************************************弹窗 修改资料***************************************************-->
    <div id="Modifying-data" class="Modifying-data">
        <div class="popup-header"><h4>修改资料</h4><i id="iconChacha4" class="iconfont icon-chacha1"></i></div>
        <input id="Modifying-data-input" type="text" maxlength="30" placeholder="请输入1-30位字符的昵称"  name="" value="<%=user1.getNickName()%>">
        <textarea id="Modifying-data-textarea" rows="4" cols="18" maxlength="70" placeholder="请输入个人简介（可为空，不超过70个字符)" name=""><%=user1.getSynopsis()%></textarea>
        <div id="Modifying-data-button1" class="Modifying-data-button1"><p>取消</p></div>
        <div class="Modifying-data-button2"><p>确定</p></div>
    </div>
    <!-- ***************************************************弹窗 修改头像***************************************************-->
    <div id="Change-the-Avatar" class="Change-the-Avatar">
        <h4>更换头像</h4>
        <img id="image" src="<%=user1.getUserIcon()%>">
        <input id="img0" class="inputfile" type="file"onchange="selectImage(this);"/>
        <label for="img0" id="Change-the-Avatar-button1" class="Change-the-Avatar-button1"><p>选择</p></label>
        <div id="Change-the-Avatar-button2" class="Change-the-Avatar-button2"><p>取消</p></div>
    </div>
    <!-- ***************************************************弹窗 修改密码***************************************************-->
    <div id="Change-Password" class="Change-Password">
        <div class="popup-header"><h4>修改密码</h4><i id="iconChacha5" class="iconfont icon-chacha1"></i></div>
        <input id="input1" class="Change-Password-input" type="text" maxlength="30" placeholder="请输入原登录密码"  name="">
        <input id="input2" class="Change-Password-input" type="text" maxlength="30" placeholder="请输入新的登录密码"  name="">
        <input id="input3" class="Change-Password-input" type="text" maxlength="30" placeholder="请重复输入新的登录密码"  name="">
        <div id="Change-Password-button1" class="Change-Password-button1"><p>取消</p></div><div class="Change-Password-button2"><p>确定</p></div>
    </div>
    <!-- ***************************************************弹窗 购买空间***************************************************-->
    <div class="father">
        <div id="Buy-Expansion" class="Buy-Expansion">
            <div class="popup-header"><h4>扩充空间</h4><i id="iconChacha6" class="iconfont icon-chacha1"></i></div>
            <div>
                <div class="Buy-type">黄金套餐<a style="font-size: 15px;">(内包含10个G的额外使用空间)</a><label class="radio-inline"><input style="margin-left: 62px;top: 0px;" type="radio" name="optionsRadiosinline" id="optionsRadios1" value="10" checked><a style="margin-left: 82px;font-size: 15px;">我要这个（10元）</a> </label></div>

                <div class="Buy-type">铂金套餐<a style="font-size: 15px;">(内包含50个G的额外使用空间)</a><label class="radio-inline"><input style="margin-left: 62px;top: 0px;" type="radio" name="optionsRadiosinline" id="optionsRadios2" value="35" checked><a style="margin-left: 82px;font-size: 15px;">我要这个（35元）</a> </label></div>

                <div class="Buy-type">钻石套餐<a style="font-size: 15px;">(内包含100个G的额外使用空间)</a><label class="radio-inline"><input style="margin-left: 54px;top: 0px;" type="radio" name="optionsRadiosinline" id="optionsRadios3" value="50" checked><a style="margin-left: 74px;font-size: 15px;">我要这个（50元）</a> </label></div>
				<div id="custom" class="buy-con">自定义购买</div>
            </div>
            
            <div id="Buy-Expansion-button2" class="Buy-Expansion-button2"><p>购买</p></div>
        </div>
        <div id="Buy-Expansion2" class="Buy-Expansion">
            <div class="popup-header"><h4>扩充空间</h4><i id="iconChacha7" class="iconfont icon-chacha1"></i></div>
            <div>
			    <p style="font-size: 20px;text-align: center;margin-bottom: 31px;">总容量：10G</p>
				<span style=" margin-left: 12%;font-size: 16px;">请输入您想购买的空间大小:</span>
				<input id="z" type="text" Max="999" onkeyup="sum(this);this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" style="margin-left: 33px;">G
			    <input type="text" id="all" style="border:0px solid white;width:25px;margin-left: 17px;">元			

				<div id="standard" class="buy-con" style="margin-top: 18px;">套餐购买</div>
			    <p style="margin-top: 32px;text-align: center;color: #777;">更多方式，敬请期待...</p>
			</div>
            
            <div id="Buy-Expansion-button" class="Buy-Expansion-button2" onclick=""><p>购买</p></div>
        </div>
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
<%--<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
<%--<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js"></script>--%>
<script type="text/javascript" src="<%=basePath%>/resource/js/personalData.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/friends-Verification.js"></script>
</body>
</html>