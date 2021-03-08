<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<a href="${pageContext.request.contextPath}/test1">测试拦截器</a>

<p>
    <a href="${pageContext.request.contextPath}/user/toLogin">登录</a>
    <a href="${pageContext.request.contextPath}/user/toSuccess">强制成功</a>
</p>

</body>
</html>
