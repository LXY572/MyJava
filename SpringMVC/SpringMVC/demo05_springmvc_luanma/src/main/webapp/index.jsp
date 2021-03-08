<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>乱码问题</title>
</head>
<body>

<%--导包jsp的包--%>
<form action="${pageContext.request.contextPath}/h1" method="post">
    用户名： <input type="text" name="name">
    <input type="submit">
</form>

</body>
</html>