<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2021/3/1
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="anno/testRequestparam?username=haha">Requestparam</a>

    <br>
    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <br>
    <a href="anno/testPathVariable/10">testPathVariable</a>

    <br>
    <a href="anno/testRequestHeader">RequestHeader</a>

    <br>
    <a href="anno/testCookieValue">CookieValue</a>

    <br>
    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <br>
    <a href="anno/testSessionAttributes">testSessionAttributes</a>
    <br>
    <a href="anno/getSessionAttributes">getSessionAttributes..</a>
    <br>
    <a href="anno/delSessionAttributes">delSessionAttributes</a>



</body>
</html>
