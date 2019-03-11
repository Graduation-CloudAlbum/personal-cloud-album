<%--
  Created by IntelliJ IDEA.
  User: ybw
  Date: 2018-09-28
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    String username=request.getParameter("username");
    session.setAttribute("username", username);
    String password=request.getParameter("password");
    session.setAttribute("password", password);

%>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/resource/css/login.css"/>

</head>
<body>
<div class="bg1"></div>
<div class="gyl">
    1024云相册

    <div class="gy2" >记录生活 留住感动 </div>
</div>
<div class="bg">
    <div class="wel">用户登录</div>
    <div class="user">
        <div style="">用户名</div>
        <input  type="text" id="username" placeholder="" />
    </div>
    <div class="password" >
        <div >密&nbsp;&nbsp;&nbsp;码</div>
        <input class="" id="password" type="password" placeholder="" />
    </div>
    <div class="rem" >
        <input type="checkbox" name="" id="checkbox" value="" />
        <div id="reb">记住用户名</div>
    </div>
    <div class="fg" >
        <div style="font-size: 11px;margin-top: 11px;">
            <a style="font-size: 11px;" href="<%=basePath%>/user/register">没有账号？注册</a>
        </div>
    </div>
    <input class="btn" id="login_btn" type="button" name="登录" value="登录" onclick="fn()"/>
</div>
<script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript" src="<%=basePath%>/resource/js/login.js" ></script>
</body>
<script>
    var user = document.getElementById("username"),
        check = document.getElementById("checkbox"),
        loUser = localStorage.getItem("user") || "";
    user.value = loUser;
    if(loUser !== ""){
        check.setAttribute("checked","");
    }
    function fn(){
        if(check.checked){
            localStorage.setItem("user",user.value);
        }else{
            localStorage.setItem("user","");
        }
    }
</script>
</html>
