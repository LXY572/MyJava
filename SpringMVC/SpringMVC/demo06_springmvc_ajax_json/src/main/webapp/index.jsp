<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>ajax</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <script>

        /*
       jQuery.post(...)
       所有参数：
              url: 待载入页面的URL地址 (必填)
             data: 待发送 Key/value 参数
          success: 载入成功时回调函数
            data:请求返回的数据
            status：请求返回的状态
         */
        function a1(){
            //ajax默认是get请求
            $.post({
                url:"${pageContext.request.contextPath}/ajax/a1",
                data:{'name':$("#txtName").val()},
                success:function (data,status) {
                    console.log(data);
                    console.log(status);
                }
            });
        }

    </script>
</head>
<body>
<%--onblur：失去焦点触发事件--%>
用户名:<input type="text" id="txtName" onblur="a1()"/>
</body>