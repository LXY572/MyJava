
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
</head>
<body>

<%--书籍原来的信息，修改按钮--%>
<h1>修改书籍信息</h1>
<hr>

<form action="${pageContext.request.contextPath}/book/updateBook" method="post">
    <%--id--%>
    <input type="hidden" name="bookID" value="${book.getBookID()}"/>
    书籍名称：<input type="text" name="bookName" value="${book.getBookName()}"> <br/><br/>
    书籍数量：<input type="text" name="bookCounts" value="${book.getBookCounts()}"> <br/><br/>
    书籍描述：<input type="text" name="detail" value="${book.getDetail()}"> <br/><br/>
    <input type="submit" value="提交"/>
</form>



</body>
</html>
