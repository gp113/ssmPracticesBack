<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/6
  Time: 16:13
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
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
</head>
<body>
<ul id="box1">
    <li v-for="menu in menuList"><a :href="menu.url" v-text="menu.title"></a></li>
</ul>

<script type="text/javascript">
    var vue1 = new Vue({
        el: "#box1",
        data: {
            menuList: []
        },
        mounted() {
            this.$http.post("<%=basePath%>/web/getHxMenus.do").then(
                function (result) {
                    this.menuList = result.body;
                    console.log(this.menuList);
                }
            );
        }
    })
</script>

</body>
</html>
