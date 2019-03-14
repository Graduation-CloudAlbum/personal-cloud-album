<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.getSession().getAttribute("user");
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>支付</title>
    <script type="text/javascript" src="<%=basePath%>/resource/js/jquery-3.2.1.min.js"></script>
</head>
<body>

<form id="payForm" action="/pca/alipay/goAlipay/" method="post">
    <input type="hidden" id="orderId" name="orderId" value="${order.id }" />
    <table>
        <tr>
            <td>
                订单编号: ${order.id}
            </td>
        </tr>
        <td>
            产品名称: ${order.productName}
        </td>
        <tr>
        </tr>
        <td>
            订单价格: ${order.payment}
        </td>
        <tr>
        </tr>
        <td>
            <input type="submit" value="前往支付宝付款">
        </td>
        </tr>
    </table>
    <%--<script>--%>
        <%--function pay() {--%>
            <%--var orderId = $('input[name=orderId]').val();--%>
            <%--window.location.href ="/pca/alipay/goAlipay/"+orderId;--%>
        <%--}--%>
    <%--</script>--%>
</form>
</body>
</html>
