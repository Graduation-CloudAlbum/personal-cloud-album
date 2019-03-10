<%@ page import="cn.yznu.pca.model.User" %><%--
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
        <div class="header-right"><img src="<%=basePath%>/resource/images/default-c.png"><span id="aa"><%=user.getNickName()%></span><i class="iconfont icon-iconfontjiantou jiantou"></i></div>
        <div class="header-right2"><i class="iconfont icon-guanbi1 guanbi"></i></div>
    </div>

    <div class="content">
        <div class="left">
            <a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=basePath%>/resource/images/default-c.png"><p><%=user.getNickName()%></p></a>
            <a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
            <a id="navMenu3" class="left-li" href="<%=basePath%>/friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
            <a id="navMenu4" class="left-li" href="<%=basePath%>/user/recycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
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
                            <th class="th1"><input id="all" name="photo" type="checkbox" value="" onchange="dianjigou()"/></th>
                            <th>相片</th>
                            <th>相片大小</th>
                            <th>删除时间</th>
                            <th>有效时间</th>
                            <th>操作</th>             
                        </tr>
                        <tbody>
                            <tr>
                                <td class="th1"><input name="photo" type="checkbox" value="" /></td>
                                <td><img src="../img/gallery/DSC_0061-69x69.jpg" /></td>
                                <td>4KB</td>
                                <td>1019-03-09 15:00</td>
                                <td>15天</td>
                                <td><button class="btn btn-info">查看</button><button class="btn btn-info">还原</button><button class="btn btn-info">删除</button></td>
                            </tr>
                            <tr>
                                <td class="th1"><input name="photo" type="checkbox" value="" /></span></td>
                                <td><img src="../img/gallery/DSC_0061-69x69.jpg" /></td>
                                <td>4KB</td>
                                <td>1019-03-09 15:00</td>
                                <td>15天</td>
                                <td><button class="btn btn-info">查看</button><button class="btn btn-info">还原</button><button class="btn btn-info">删除</button></td>
                            </tr>
                            <tr>
                                <td class="th1"><input name="photo" type="checkbox" value="" /></td>
                                <td><img src="../img/gallery/DSC_0061-69x69.jpg" /></td>
                                <td>4KB</td>
                                <td>1019-03-09 15:00</td>
                                <td>15天</td>
                                <td><button class="btn btn-info">查看</button><button class="btn btn-info">还原</button><button class="btn btn-info">删除</button></td>
                            </tr>

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
            <div class="delete-recycle-button1" id="delete-recycle-button1"><p>取消</p></div><div class="delete-recycle-button2"><p>清空</p></div>
        </div>
        <!-- ***************************************************删除选中 ***************************************************-->
        <div id="delete-recycle2">
            <div class="popup-header"><h4>彻底删除选中相片</h4><i id="iconChacha3" class="iconfont icon-chacha1"></i></div>
            <input id="delete-recycle-input2" type="text" placeholder="请输入登录密码继续删除操作"  name="">
            <div class="delete-recycle-button1" id="delete-recycle-button3"><p>取消</p></div><div class="delete-recycle-button2"><p>清空</p></div>
        </div>
        <!-- ***************************************************还原回收站 ***************************************************-->
        <div id="update-recycle">
            <div class="popup-header"><h4>还原所有相片至</h4><i id="iconChacha2" class="iconfont icon-chacha1"></i></div>
            <div id="update-recycle-left" class="select-first">陌生人</div>
            <div id="update-recycle-right" class="select-right"><span><i id="select-jiantou" class="iconfont icon-iconfontjiantou jiantou select-jiantou"></i></span></div>
            <ul id="update-recycle-group" class="menu-group">
                <li class="menu-group-li">陌生人</li>
                <li class="menu-group-li">家人</li>
                <li class="menu-group-li">同事</li>
            </ul>
            <div class="update-recycle-button1" id="update-recycle-button1"><p>取消</p></div><div class="update-recycle-button2"><p>还原</p></div>
        </div>
        <!-- ***************************************************还原选中 ***************************************************-->
        <div id="update-recycle2">
                <div class="popup-header"><h4>还原选中相片至</h4><i id="iconChacha4" class="iconfont icon-chacha1"></i></div>
                <div id="update-recycle-left2" class="select-first">陌生人</div>
                <div id="update-recycle-right2" class="select-right"><span><i id="select-jiantou2" class="iconfont icon-iconfontjiantou jiantou select-jiantou"></i></span></div>
                <ul id="update-recycle-group2" class="menu-group">
                    <li class="menu-group-li">陌生人</li>
                    <li class="menu-group-li">家人</li>
                    <li class="menu-group-li">同事</li>
                </ul>
                <div class="update-recycle-button1" id="update-recycle-button2"><p>取消</p></div><div class="update-recycle-button2"><p>还原</p></div>
            </div>
        <!-- ***************************************************查看 ***************************************************-->
        <!-- <div id="see-photo">
            <div class="popup-header"><i id="iconChacha3" class="iconfont icon-chacha1"></i></div>
            <img src="../img/1.jpg">
        </div> -->
        <!-- ***************************************************删除 ***************************************************-->

        <!-- ***************************************************还原 ***************************************************-->



    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="popLayer" class="popLayer"></div>
    <div id="popLayer2" class="popLayer2"></div>
</div>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/recycleBin.js"></script>
</body>
</html>