<%--
  Created by IntelliJ IDEA.
  User: jc568947953
  Date: 2019-01-28
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>666666</p>
<c:forEach items="${jsonArray2}" var="node">
<tr>
    <td>${node.note}</td>
    <td>${node.friend.nickName}</td>
    <td>${node.id}</td>
    </c:forEach>

</body>
</html>
