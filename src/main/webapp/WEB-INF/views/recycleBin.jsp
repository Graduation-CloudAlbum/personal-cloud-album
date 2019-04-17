<%@ page import="cn.yznu.pca.model.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2018-11-28
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    User  user= (User) request.getSession().getAttribute("user");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>recycleBin</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=basePath%>/resource/css/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/recycleBin.css"/>
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
            <a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=user.getUserIcon()%>"><p><%=user.getNickName()%></p></a>
            <a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
            <a id="navMenu3" class="left-li" href="<%=basePath%>/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
            <a id="navMenu4" class="left-li" href="<%=basePath%>/recycleBin/myRecycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
            <div class="nav-button"></div>
        </div>
        <!-- right -->
        <div class="main-container">
            <div class="content-header">
                <i class="iconfont icon-huishouzhan1"></i> <span>回收站</span>
            </div>
            <ul class="content-menu">
                    <li id="deleteAll" class="content-menu-li"><a>清空回收站</a></li>
                    <li id="updateAll" class="content-menu-li"><a>还原所有项目</a></li>
                    <li id="table-header5"><button id="button1" class="btn btn-info">还原选中</button><button id="button2" class="btn btn-info">删除选中</button></li>
                </ul>
                <div class="content-about">
                    <table id="recycle-table" class="recycle-table">
                        <tr class="table-tr">
                            <th class="th1"><input id="all" name="photoTop" type="checkbox" value="" onchange="dianjigou()"/></th>
                            <th>照片</th>
                            <th>照片大小</th>
                            <th>删除时间</th>
                            <th>有效时间</th>
                            <th>操作</th>             
                        </tr>
                        <tbody>
                        <c:forEach items="${recycleBins}" var="recycleBins">
                            <tr>
                                <td class="th1"><input name="photo" type="checkbox" value="${recycleBins.imageId}" /></td>
                                <td><img class="pimg" src="${recycleBins.image.url}" /></td>
                                <td>${recycleBins.image.imageSize}</td>
                                <td><fmt:formatDate value="${recycleBins.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                <td>15天<input type="hidden" name="album_id" value="${recycleBins.albumId}" /></td>
                                <td><button class="btn btn-info pimg2">查看</button></td>
                            </tr>
                            <li  class="content-about-menu-li" onclick="selectOnde('${friendgroup.permissionType}','<%=path%>',this)">${friendgroup.permissionType}</li>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>

            </div>
        </div>
        <!-- ***************************************************弹窗 ***************************************************-->
        <!-- ***************************************************清空回收站 ***************************************************-->
        <div id="delete-recycle">
            <div class="popup-header"><h4>清空回收站</h4><i id="iconChacha1" class="iconfont icon-chacha1"></i></div>
            <input id="delete-recycle-input" type="text" placeholder="请输入登录密码继续清空操作"  name="">
            <div class="delete-recycle-button1" id="delete-recycle-button1"><p>取消</p></div><div id="delete-recycle-button5" class="delete-recycle-button2"><p>清空</p></div>
        </div>
        <!-- ***************************************************删除选中 ***************************************************-->
        <div id="delete-recycle2">
            <div class="popup-header"><h4>彻底删除选中照片</h4><i id="iconChacha3" class="iconfont icon-chacha1"></i></div>
            <input id="delete-recycle-input2" type="text" placeholder="请输入登录密码继续删除操作"  name="">
            <div class="delete-recycle-button1" id="delete-recycle-button3"><p>取消</p></div><div id="delete-recycle-button4" class="delete-recycle-button2"><p>清空</p></div>
        </div>
        <!-- ***************************************************还原回收站 ***************************************************-->
        <div id="update-recycle">
            <div class="popup-header"><h4>还原所有照片</h4><i id="iconChacha2" class="iconfont icon-chacha1"></i></div>
            <div style="margin-left: 20px"><h4>是否确认还原所有照片？</h4></div>
            <div class="update-recycle-button1" id="update-recycle-button1"><p>取消</p></div><div id="recover-recycle-button6" class="update-recycle-button2"><p>还原</p></div>
        </div>
        <!-- ***************************************************还原选中 ***************************************************-->
        <div id="update-recycle2">
                <div class="popup-header"><h4>还原选中照片</h4><i id="iconChacha4" class="iconfont icon-chacha1"></i></div>
                <div style="margin-left: 20px"><h4>是否确认还原选中照片？</h4></div>
                <div class="update-recycle-button1" id="update-recycle-button2"><p>取消</p></div><div id="update-recycle-button3" class="update-recycle-button2"><p>还原</p></div>
        </div>
        <!-- ***************************************************查看 ***************************************************-->
        <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
            <div id="innerdiv" style="position:absolute;">
                <img id="bigimg" style="border:5px solid #fff;" src="" />
            </div>
        </div> 
        <!-- ***************************************************删除 ***************************************************-->

        <!-- ***************************************************还原 ***************************************************-->
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
    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="popLayer" class="popLayer"></div>
    <div id="popLayer2" class="popLayer2"></div>
</div>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/recycleBin.js"></script>
<script src="<%=basePath%>/resource/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/friends-Verification.js"></script>
</body>
</html>