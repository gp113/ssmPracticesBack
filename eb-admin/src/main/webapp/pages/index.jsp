<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/10
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/easyui/themes/icon.css">
        <script type="text/javascript" src="<%=basePath%>/static/js/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/static/js/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>/static/js/easyui//locale/easyui-lang-zh_CN.js"></script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'north',title:'north title',split:true" style="height: 100px;"></div>
        <div data-options="region:'south',title:'south title',split:true" style="height: 100px;"></div>
        <div data-options="region:'west',title:'菜单栏',iconCls:'icon-house',split:true" style="width: 150px;">
            <%--左侧目录树--%>
            <ul id="menuTree"></ul>
        </div>
        <div data-options="region:'east',title:'east title',iconCls:'icon-reload',split:true"
             style="width: 100px;"></div>
        <%--中央展示区--%>
        <div id="centerTab" class="easyui-tabs" data-options="region:'center'">
            <div data-options="iconCls:'icon-house'" title="主页"></div>
        </div>

    </body>

    <script type="application/javascript">

        $("#menuTree").tree({
            url: "<%=basePath%>/admin/getMenu.do",
            lines: true,
            animate: true,

            //生成选项卡
            onClick: function (node) {
                console.log(node);
                var flag = $("#centerTab").tabs('exists', node.text);
                //选项卡不存在，生成选项卡，但一级目录除外
                if (!flag && node.url != null) {
                    $("#centerTab").tabs('add', {
                        title: node.text,
                        iconCls: node.iconCls,
                        closable: true,
                        href: node.url
                    })
                } else {
                    //选项卡存在，跳转到该选项卡
                    $("#centerTab").tabs('select', node.text);
                }
            }

        })


    </script>

</html>
