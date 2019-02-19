<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.getSession().getAttribute("user");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>upload选择上传的文件</title>
    <script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>${user.nickName}</h1>
<form id="uploadForm" enctype="multipart/form-data" action="<%=basePath%>/image/upload" method="post">
    <input id="file" type="file" name="file" />
    <input type="submit" value="submit">
</form>
</body>
</html>
