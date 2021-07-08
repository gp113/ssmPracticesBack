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
    <script type="text/javascript" src="<%=basePath%>/static/js/easyui/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
</head>
<body>
<div id="box1">{{num1}}</div>
<br>
<div id="box2">
    <input type="text" v-model="num2">
    <button @click="add">+</button>
</div>

<div id="box3">
    <div v-on:click="pushDiv" style="background-color: blue ; width: 100px; height: 100px">
        <button @click.stop="pushButton">push</button>
    </div>
    <a href="http://www.baidu.com" @click.prevent="pushA">点击</a>
</div>

<div id="box4">
    <div>{{num4}}</div>
    <input type="text" v-model="num4">
</div>


<script type="application/javascript">



    })

    var vue4 = new Vue({
        el:"#box4",
        data:{
            num4:'',
            dz:'http;//www.baidu.com'
        }
    })

</script>

</body>
</html>