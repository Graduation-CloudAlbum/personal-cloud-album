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
    <title>确认购买空间</title>
    <script src="<%=basePath%>/resource/js/jquery-3.2.1.min.js"></script>

</head>
<body>
<form action="<%=request.getContextPath() %>/alipay/createOrder" method="post">
    <input type="hidden" id="productName" name="productId" value="${productName}" />
    <input type="hidden" id="payment" name="payment" value="${payment}" />
<table>
    <td>
        产品名称: ${productName}
    </td>
    <tr></tr>
    <td>
        产品价格: ${payment}
    </td>
    <tr>
        <td>
            <input type="submit" value="form提交，生成订单" />
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="ajax提交，生成订单" onclick="createOrder()" />
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script type="text/javascript">


    function createOrder() {
        $.ajax({
            url: "/pca/alipay/createOrder",
            type: "POST",
            data: {"productName": $("#productName").val(), "payment": $("#payment").val()},
            dataType: "json",
            success: function(data) {
                // 确认订单后, 进入创建订单页面
                window.location.href =  "/pca/alipay/goPay?orderId=" + data;
            }
        });
    }

</script>