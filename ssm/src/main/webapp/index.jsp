<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2021/3/6
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--account表示类的注解，findAll表示方法的注解--%>
    <a href="account/findAll">测试查询</a>

    <h3>测试包</h3>

    <form action="account/save" method="post">
        姓名:<input type="text" name="name"/><br/>
        金额:<input type="text" name="money"/><br/>
        <input type="submit" value="保存"/><<br/>
    </form>
</body>
</html>














