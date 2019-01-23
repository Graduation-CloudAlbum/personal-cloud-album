<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.getSession().getAttribute("user");
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>图片浏览演示</title>
    <script src="<%=basePath%>/resource/js/layer/jquery.js"></script>
    <script src="<%=basePath%>/resource/js/layer/layer.min.js"></script>
    <style>
        html{background-color:#E3E3E3; font-size:14px; color:#000; font-family:'微软雅黑'}
        a,a:hover{ text-decoration:none;}
        pre{font-family:'微软雅黑'}
        .box{padding:20px; background-color:#fff; margin:20px 100px; border-radius:5px;}
        .box a{padding-right:15px;}
        #about_hide{display:none}
        .layer_text{background-color:#fff; padding:20px;}
        .layer_text p{margin-bottom: 10px; text-indent: 2em; line-height: 23px;}
        .button{display:inline-block; *display:inline; *zoom:1; line-height:30px; padding:0 20px; background-color:#56B4DC; color:#fff; font-size:14px; border-radius:3px; cursor:pointer; font-weight:normal;}
        .imgs img{width:200px;padding:0 10px 10px;}
    </style>
</head>
<body>
<div class="box">
    <h2 style="padding-bottom:20px;">测试</h2>
    <div id="imgs" class="imgs">
        <c:forEach var="b" items="${imageList}">
            <img src="${b.url}">
        </c:forEach>

    </div>

</div>
<script>
    ;!function(){
        layer.use('extend/layer.ext.js', function(){
            //初始加载即调用，所以需放在ext回调里
            layer.ext = function(){
                layer.photosPage({
                    html:'<div style="padding:20px;">${user.nickName}<p></p>${user.nickName}</div>',
                    title: '${imageList}',
                    id: 100, //相册id
                    parent:'#imgs'
                });
            };
        });
    }();
</script>


</body>
</html>