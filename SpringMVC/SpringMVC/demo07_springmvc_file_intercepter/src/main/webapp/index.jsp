<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/upload2">
    <input type="file" name="file">
    <<input type="submit">
</form>

<p><a href="${pageContext.request.contextPath}/download">下载图片</a></p>


</body>
</html>
