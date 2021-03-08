<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <%--引用BootStarp--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


<%--显示要增加的书籍信息--%>
<h1>增加书籍</h1>

<form method="post" action="${pageContext.request.contextPath}/book/addBook">
    书籍名称：<input type="text" name="bookName"> <br/><br/>
    书籍数量：<input type="text" name="bookCounts"> <br/><br/>
    书籍描述：<input type="text" name="detail"> <br/><br/>
    <input type="submit"/>
</form>



</body>
</html>
