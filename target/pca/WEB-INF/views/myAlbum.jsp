<%@ page import="cn.yznu.pca.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2018-11-28
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
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
        <div class="header-right"><img src="<%=basePath%>/resource/img/default-c.png"><span id="aa">1732859702</span><i class="iconfont icon-iconfontjiantou jiantou"></i></div>
        <div class="header-right2"><i class="iconfont icon-guanbi1 guanbi"></i></div>
    </div>

    <div class="content">
        <div class="left">
            <a id="navMenu2" class="left-admin" href="<%=basePath%>/user/personalData"><img src="<%=basePath%>/resource/img/default-c.png"><p>1732859702</p></a>
            <a id="navMenu1" class="left-li" href="<%=basePath%>/user/myAlbum"><i class="iconfont icon-xiangce"></i><span>我的相册</span></a>
            <a id="navMenu3" class="left-li" href="<%=basePath%>friend/myFriend"><i class="iconfont icon-weibiaoti--"></i><span>我的好友</span></a>
            <a id="navMenu4" class="left-li" href="<%=basePath%>/user/recycleBin"><i class="iconfont icon-huishouzhan1"></i><span>回收站</span></a>
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
                <li class="content-menu-li"><a>排序方式</a></li>
            </ul>
            <ul id="myAlbum-menu2" class="content-menu">
                <li class="content-menu-li"><a id="uploadPhoto3">上传照片</a></li>
                <li class="content-menu-li"><a id="uploadPhoto4">相册信息</a></li>
                <li class="content-menu-li"><a>批量管理</a></li>
            </ul>


            <div class="content-wrap">
                <ul id="myAlbum-content" class="content-about">
                    <li class="content-about-li">
                        <img src="<%=basePath%>/resource/img/Album-cover1.jpg">
                        <div class="content-about-li-top">
                            <div class="content-about-li-top-a">
                                <a class="iconfont icon-huishouzhan1 icon1" title="删除相册"></a>
                                <a class="iconfont icon-fenxiang1 icon2" title="分享相册"></a>
                                <a class="iconfont iconfont icon-point icon1" title="相册信息"></a><!-- data-event="albumdel" -->
                            </div>
                            <div class="bottun-title">
                                <p class="bottun-title-p1">心情</p>
                                <p class="bottun-title-p2">2018-2-1<i class="iconfont icon-vertical_line"></i>23图</p>
                            </div>
                        </div>
                    </li>
                    <li class="content-about-li">
                        <img src="<%=basePath%>/resource/img/Album-cover2.jpg">
                        <div class="content-about-li-top">
                            <div class="content-about-li-top-a">
                                <a class="iconfont icon-huishouzhan1 icon1" title="删除相册"></a>
                                <a class="iconfont icon-fenxiang1 icon2" title="分享相册"></a>
                                <a class="iconfont iconfont icon-point icon1" title="相册信息"></a><!-- data-event="albumdel" -->
                            </div>
                            <div class="bottun-title">
                                <p class="bottun-title-p1">心情</p>
                                <p class="bottun-title-p2">2018-2-1<i class="iconfont icon-vertical_line"></i>23图</p>
                            </div>
                        </div>
                    </li>
                    <li class="content-about-li">
                        <img src="<%=basePath%>/resource/img/Album-cover3.jpg">
                        <div class="content-about-li-top">
                            <div class="content-about-li-top-a">
                                <a class="iconfont icon-huishouzhan1 icon1" title="删除相册"></a>
                                <a class="iconfont icon-fenxiang1 icon2" title="分享相册"></a>
                                <a class="iconfont iconfont icon-point icon1" title="相册信息"></a><!-- data-event="albumdel" -->
                            </div>
                            <div class="bottun-title">
                                <p class="bottun-title-p1">我的青春我做主</p>
                                <p class="bottun-title-p2">2018-2-1<i class="iconfont icon-vertical_line"></i>5图</p></div>
                        </div>
                    </li>


                </ul>
                <ul id="myAlbum-content2" class="content-about2 gallery">
                    <div class="content-about2-li">
                        <a href="<%=basePath%>/resource/img/gallery/DSC_0008-660x441.jpg"><img src="<%=basePath%>/resource/img/gallery/DSC_0008-69x69.jpg" /></a>
                    </div>
                    <div class="content-about2-li">
                        <a href="<%=basePath%>/resource/img/gallery/DSC_0014-660x441.jpg"><img src="<%=basePath%>/resource/img/gallery/DSC_0014-69x69.jpg" /></a>
                    </div>
                    <div class="content-about2-li">
                        <a href="<%=basePath%>/resource/img/gallery/DSC_0019-660x441.jpg"><img src="<%=basePath%>/resource/img/gallery/DSC_0019-69x69.jpg" /></a>
                    </div>
                    <div class="content-about2-li">
                        <a href="<%=basePath%>/resource/img/gallery/DSC_0061-660x441.jpg"><img src="<%=basePath%>/resource/img/gallery/DSC_0061-69x69.jpg" /></a>
                    </div>

                </ul>
                <div class="content-button">
                    <div class="content-button-fenge"></div>
                    <span id="open">(共3个相册)</span><span id="open2">(共7张照片)</span>
                </div>
                <div class="content-footer"></div>


            </div>
        </div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="upload-photos" class="upload-photos">
        <div class="upload-photos-pop">
            <div class="upload-photos-pop-header">
                <span>上传照片至：心情</span><i id="icon-chacha1" class="iconfont icon-chacha1"></i>
            </div>
            <div class="upload-photos-pop-content">
                <form action="/***/correct"  method='post' enctype='multipart/form-data' >
                    <ul  id="dd" class="upimgcontent"></ul>

                    <label id="upload-photos-pop-content-button" class="upload-photos-pop-content-button" for="doc0"><p>点击选择图片</p></label>

                    <div id="upload-photos-pop-content-footer" class="upload-photos-pop-content-footer">
                        <div class="content-button-fenge"></div><span>可将相片拖拽至以上选择框，每次最多上传500张相片</span>
                    </div>
                    <div id="upload-photos-pop-content-footer2" class="upload-photos-pop-content-footer2 fileinput-wrap">
                        <span>共一张相片（4.31K）</span>

                        <input  class="inputfile" type="file" name="files" id="doc0" imgid="img0" onchange="javascript:setImagePreviews()" />
                        <label for="doc0" class="btn btn-default footer-button1">继续添加</label>
                        <button class="btn btn-info footer-button2"  type="submit"><p>开始上传</p></button>
                    </div>
                </form>


            </div>
        </div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="upload-photos-choose" class="upload-photos-choose">
        <div class="popup-header"><h4>选择相册</h4><i id="iconChacha2" class="iconfont icon-chacha1"></i></div>
        <div class="select-first"><p>心情</p></div>
        <div class="select-right"><span><i class="iconfont icon-iconfontjiantou jiantou"></i></span></div>
        <div id="select-button" class="select-button"><p>下一步</p></div>
    </div>
    <!-- ***************************************************弹窗 ***************************************************-->
    <div id="Create-Album">
        <div class="popup-header"><h4>创建相册</h4><i id="iconChacha3" class="iconfont icon-chacha1"></i></div>
        <input id="Create-Album-input" type="text" placeholder="请输入1-30位字符名称的相册"  name="">
        <div class="Create-Album-button1" id="Create-Album-button1"><p>取消</p></div><div class="Create-Album-button2"><p>确定</p></div>
    </div>










    <!-- ***************************************************遮罩层***************************************************-->
    <div id="popLayer" class="popLayer"></div>
    <div id="popLayer2" class="popLayer2"></div>




</div>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/myAlbum.js"></script>
<script src="<%=basePath%>/resource/js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath%>/resource/js/zoom.min.js"></script>
</body>
</html>