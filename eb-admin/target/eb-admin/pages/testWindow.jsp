<%--
 *
 *@description
 *@author gp
 *@time 2020/3/23 14:19
 *
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath %>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>new jsp</title>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/easyui/themes/icon.css">
        <script type="text/javascript" src="<%=basePath%>/static/js/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/static/js/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/static/js/easyui//locale/easyui-lang-zh_CN.js"></script>
    </head>
    <body>
        hhh
        <div id="win">
            hhh
        </div>


        <script type="application/javascript">

            $("#win").window({
                width:600,
                height:600,
                modal:true
            })

        </script>

    </body>
</html>