<%--
 *
 *@description
 *@author gp
 *@time 2020/3/12 15:00
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
</head>
<body>
<div class="easyui-layout" fit="true">
    <div id="tencentCloudDataGrid_toolbar" region="north" style="height: 28px">
        <%--添加按钮--%>
        <div style="float: left">
            <a id="addCloudButton" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-add',plain:'true'">添加</a>
        </div>
        <div class="datagrid-btn-separator"></div>
        <%--删除按钮--%>
        <div style="float: left">
            <a id="deleteCloudButton" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove',plain:'true'" onclick="deleteCloud()">删除</a>
        </div>
        <div class="datagrid-btn-separator"></div>
        <%--搜索框--%>
        <div id="search" style="float: right">
            <input id="ss" data-options="searcher:'doSearch(value,name)'">
            <div id="mm" style="width:120px">
                <div data-options="name:'name',iconCls:'icon-system'">服务器名称</div>
                <div data-options="name:'manager',iconCls:'icon-manager'">总负责人</div>
            </div>
        </div>
    </div>
    <div region="center">
        <table id="tencentCloudDataGrid"></table>
    </div>
</div>


<%--添加窗口--%>
<div id="addCloudWindow" class="easyui-window" title="添加" style="width:550px;height:240px"
     data-options="iconCls:'icon-add', modal:true, closed:true">
    <form method="post" action="javascript:void(0)">
        <center>
            <table>
                <tr>
                    <td>
                        行业所属：
                    </td>
                    <td>
                        <input type="radio" name="hangYeType" value="0" checked>平台研发与开源社区中心
                        <input type="radio" name="hangYeType" value="1">行业产品研发中心
                        <input type="radio" name="hangYeType" value="2">项目
                    </td>
                </tr>
                <tr>
                    <td>
                        服务器名称：
                    </td>
                    <td>
                        <input id="addCloud_CloudName" class="easyui-validatebox" name="cloudName">
                    </td>
                </tr>
                <tr>
                    <td>
                        负责人：
                    </td>
                    <td>
                        <input id="addCloud_Manager" class="easyui-validatebox" name="manager">
                    </td>
                </tr>
                <tr>
                    <td>
                        IP地址：
                    </td>
                    <td>
                        <input id="addCloud_IPAddress" class="easyui-validatebox" name="IPAddress">
                    </td>
                </tr>
                <tr>
                    <td>
                        到期日期：
                    </td>
                    <td>
                        <input id="addCloud_EndDate" type="text" class="easyui-datebox" name="endDate"
                               required="required" value="1">
                    </td>
                </tr>
                <tr id="addCloud_CloudType">
                    <td>
                        类型：
                    </td>
                    <td>
                        <input type="radio" name="cloudType" value="0" checked>云服务器
                        <input type="radio" name="cloudType" value="1">云硬盘
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <a href="javascript:void(0)" class="easyui-linkbutton" id="addCloud"
                           data-options="iconCls:'icon-ok'">添加</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" id="addCloudCancel"
                           data-options="iconCls:'icon-cancel'">重置</a>
                    </td>
                </tr>
            </table>
        </center>
    </form>
</div>

<%--修改窗口--%>
<div id="updateCloudWindow" class="easyui-window" title="修改" style="width:550px;height:240px"
     data-options="iconCls:'icon-pencil', modal:true, closed:true">
    <form method="post" action="javascript:void(0)">
        <center>
            <table>
                <tr>
                    <td>
                        行业所属：
                    </td>
                    <td>
                        <input type="radio" name="updateHangYeType" value="0" checked>平台研发与开源社区中心
                        <input type="radio" name="updateHangYeType" value="1">行业产品研发中心
                        <input type="radio" name="updateHangYeType" value="2">项目
                    </td>
                </tr>
                <tr>
                    <td>
                        服务器名称：
                    </td>
                    <td>
                        <input id="updateCloud_CloudName" class="easyui-validatebox" name="updateCloudName">
                    </td>
                </tr>
                <tr>
                    <td>
                        负责人：
                    </td>
                    <td>
                        <input id="updateCloud_Manager" class="easyui-validatebox" name="updateManager">
                    </td>
                </tr>
                <tr>
                    <td>
                        IP地址：
                    </td>
                    <td>
                        <input id="updateCloud_IPAddress" class="easyui-validatebox" name="updateIPAddress">
                    </td>
                </tr>
                <tr>
                    <td>
                        到期日期：
                    </td>
                    <td>
                        <input id="updateCloud_EndDate" type="text" class="easyui-datebox" name="updateEndDate"
                               required="required" value="1">
                    </td>
                </tr>
                <tr id="updateCloud_CloudType">
                    <td>
                        类型：
                    </td>
                    <td>
                        <input type="radio" name="updateCloudType" value="0" checked>云服务器
                        <input type="radio" name="updateCloudType" value="1">云硬盘
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <a href="javascript:void(0)" class="easyui-linkbutton" id="updateCloud"
                           data-options="iconCls:'icon-ok'" onclick="updateCloudInfo()">保存</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" id="closeUpdateWindow"
                           data-options="iconCls:'icon-cancel'">取消</a>
                    </td>
                </tr>
            </table>
        </center>
    </form>
</div>


<script type="text/javascript">

    <%--表格请求后台java接口--%>
    $("#tencentCloudDataGrid").datagrid({
        url: "<%=basePath%>/tencent/getAllClouds.do",
        loadMsg: "请稍后",
        rownumbers: true,
        fit: true,
        fitColumns: true,//自动改变行列比例，把表格撑起来，显得好看点
        columns: [
            [
                {checkbox: true},
                {field: 'id', title: '主键', hidden: true},
                {
                    field: 'hangYeType',
                    title: '研发中心',
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "平台研发与开源社区中心";
                        } else if (value == 1) {
                            return "行业产品研发中心";
                        } else {
                            return "项目";
                        }
                    }
                },
                {field: 'name', title: '服务器名称'},
                {field: 'manager', title: '总负责人'},
                {field: 'IPAddress', title: 'ip地址'},
                {field: 'endTime', title: '到期日期'},
                {
                    field: 'type',
                    title: '类型',
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "云服务器";
                        } else {
                            return "云硬盘";
                        }
                    }
                },
                {
                    field: 'hasDate',
                    title: '到期剩余天数',
                    sortable: "true",
                    styler: function (value, row, index) {
                        if (value > 30) {
                            return 'color:#90EE90';
                        } else if (value > 7) {
                            return 'color:#F4A460';
                        } else {
                            return 'color:#FF0000';
                        }
                    }
                },
                {
                    field: 'operate',
                    title: '操作',
                    width: 50,
                    formatter: function (value, row, index) {
                        var str = '<a href="javascript:void(0)" class="easyui-linkbutton" name="updateCloudOne" onclick="openUpdateCloudWindow(' + row.id + ')"></a>' +
                            '<a href="javascript:void(0)" class="easyui-linkbutton" name="deleteCloudOne" onclick="deleteCloud(' + row.id + ')"></a>';
                        return str;
                    }
                }
            ]
        ],
        onLoadSuccess: function (data) {
            $("a[name='updateCloudOne']").linkbutton({
                text: '修改',
                iconCls: 'icon-edit'
            })
            $("a[name='deleteCloudOne']").linkbutton({
                text: '删除',
                iconCls: 'icon-remove'
            })
        },
        pagination: true,//显示分页工具栏
        pagePosition: 'bottom',//定义分页工具栏的位置
        pageSize: 10,//设置分页属性的时候初始化页面大小
        pageList: [10, 20, 50],//设置分页属性的时候 初始化页面大小选择列表
        // sortName: "hasDate",//指定排序的字段名称
        // sortOrder: "asc",//指定排列方式
        // remoteSort: false,//关闭服务器对数据排序
        toolbar: '#tencentCloudDataGrid_toolbar'
    })

    //    打开添加窗口
    $("#addCloudButton").click(function () {
        $("#addCloudWindow").window('open');
    })

    //    点击添加按钮
    $("#addCloud").click(function () {
        var hangYeType = $("input[name='hangYeType']:checked").val();
        var cloudName = $("#addCloud_CloudName").val();
        var manager = $("#addCloud_Manager").val();
        var IPAddress = $("#addCloud_IPAddress").val();
        var endDate = $("#addCloud_EndDate").datebox('getValue');
        var cloudType = $("input[name='cloudType']:checked").val();

        $.ajax({
            url: "<%=basePath%>/tencent/addCloud.do",
            type: "post",
            dataType: "json",
            data: {
                "hangYeType": hangYeType,
                "cloudName": cloudName,
                "manager": manager,
                "IPAddress": IPAddress,
                "endDate": endDate,
                "cloudType": cloudType
            },
            success: function (result) {
                if (result) {
                    $.messager.show({
                        title: "消息",
                        msg: "添加成功"
                    });

                    //清空窗口内容
                    $("input[name='hangYeType'][value='0']").prop('checked', true);
                    $("#addCloud_CloudName").val(null);
                    $("#addCloud_Manager").val(null);
                    $("#addCloud_IPAddress").val(null);
                    $("#addCloud_Manager").val(null);
                    $("#addCloud_EndDate").datebox('setValue', 'Today');
                    $("input[name='cloudType'][value='0']").prop('checked', true);

                    $("#addCloudWindow").window('close');
                    $("#tencentCloudDataGrid").datagrid('reload');
                } else {
                    $.messager.show({
                        title: "消息",
                        msg: "添加失败"
                    });
                }
            },
            error: function () {
                alert("cuowu");
            }
        })

    })

    //    点击重置按钮，清空文本框内容
    $("#addCloudCancel").click(function () {
        $("input[name='hangYeType'][value='0']").prop('checked', true);
        $("#addCloud_CloudName").val(null);
        $("#addCloud_Manager").val(null);
        $("#addCloud_IPAddress").val(null);
        $("#addCloud_Manager").val(null);
        $("#addCloud_EndDate").datebox('setValue', 'Today');
        $("input[name='cloudType'][value='0']").prop('checked', true);
    })

    //    修改窗口点击取消按钮，关闭窗口
    $("#closeUpdateWindow").click(function () {
        $("#updateCloudWindow").window('close');
    })

    //     打开修改窗口
    var couldMainID

    function openUpdateCloudWindow(id) {
        $("#updateCloudWindow").window('open');
        couldMainID = id;

        $.ajax({
            url: '<%=basePath%>/tencent/getCloudInfo.do',
            type: 'post',
            dataType: 'json',
            data: {'cloudID': id},
            success: function (map) {
                if (map) {
                    console.log('endTime = ' + map.endTime);
                    $("input[name='updateHangYeType'][value = '" + map.hangYeType + "']").prop('checked', true);
                    $("#updateCloud_CloudName").val(map.name);
                    $("#updateCloud_Manager").val(map.manager);
                    $("#updateCloud_IPAddress").val(map.IPAddress);
                    $("#updateCloud_EndDate").datebox('setValue', map.endTime);
                    $("input[name='updateCloudType'][value='" + map.type + "']").prop("checked", true);

                } else {
                    console.log("失败");
                }
            },
            error: function () {
                console.log("错误");
            }
        })
    }

    //    点击修改按钮调用方法
    function updateCloudInfo() {
        var updateID = couldMainID;
        var updateHangYeType = $("input[name='updateHangYeType']:checked").val();
        var updateCloud_CloudName = $("#updateCloud_CloudName").val();
        var updateCloud_Manager = $("#updateCloud_Manager").val();
        var updateCloud_IPAddress = $("#updateCloud_IPAddress").val();
        var updateCloud_EndDate = $("#updateCloud_EndDate").datebox('getValue');
        var updateCloudType = $("input[name='updateCloudType']:checked").val();

        $.ajax({
            url: "<%=basePath%>/tencent/updateCloudInfo.do",
            type: "post",
            dataType: "json",
            data: {
                "id": updateID,
                "hangYeType": updateHangYeType,
                "name": updateCloud_CloudName,
                "manager": updateCloud_Manager,
                "IPAddress": updateCloud_IPAddress,
                "endTime": updateCloud_EndDate,
                "type": updateCloudType,
            },
            success: function (result) {
                if (result) {
                    $.messager.show({
                        title: '提示',
                        msg: '修改成功。'
                    });
                    $("#updateCloudWindow").window('close');
                    $("#tencentCloudDataGrid").datagrid('reload');
                } else {
                    $.messager.show({
                        title: '提示',
                        msg: '修改失败。'
                    });
                }
            }
        })
    }

    //    点击删除按钮
    function deleteCloud(id) {
        var selections = $("#tencentCloudDataGrid").datagrid('getSelections');
        //判断至少选择一条数据
        if (selections.length > 0 || id != null) {
            $.messager.confirm("提示", "你确认要删除记录吗？", function (r) {
                if (r) {
                    //通过多选框选择
                    if (selections.length > 0) {
                        //获取id字符串："1,2,3,"等
                        var idStr = '';
                        for (var i = 0; i < selections.length; i++) {
                            idStr += selections[i].id + ',';
                        }
                    }
                    //通过单元格的按钮选择
                    else {
                        idStr = id + ',';
                    }
                    //点击确定按钮，执行删除
                    $.ajax({
                        url: "<%=basePath%>/tencent/deleteCloud.do",
                        type: "post",
                        dataType: "json",
                        data: {"idStr": idStr},
                        success: function (result) {
                            if (result) {
                                $.messager.show({
                                    title: '提示',
                                    msg: '删除成功。'
                                });
                                $("#tencentCloudDataGrid").datagrid('reload');
                            } else {
                                $.messager.show({
                                    title: '提示',
                                    msg: '删除失败。'
                                })
                            }
                        }
                    })
                }
            })
        } else {
            $.messager.alert("提示", "请至少选择一条数据。");
        }

    }

    //创建搜索框
    $("#ss").searchbox({
        menu: '#mm',
        prompt: '请输入',
        //searchType为查询类型,searchValue为输入的关键字
        searcher: doSearch
    });

    //点击查询按钮触发点击事件，执行查询并重新生成datagrid
    function doSearch(searchValue, searchType) {
        $("#tencentCloudDataGrid").datagrid({
            url: "<%=basePath%>/tencent/getCloudsBySearch.do?searchType=" + searchType + "&&searchValue=" + searchValue,
            loadMsg: "请稍后",
            rownumbers: true,
            fit: true,
            fitColumns: true,//自动改变行列比例，把表格撑起来，显得好看点
            columns: [
                [
                    {checkbox: true},
                    {field: 'id', title: '主键', hidden: true},
                    {
                        field: 'hangYeType',
                        title: '研发中心',
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "平台研发与开源社区中心";
                            } else if (value == 1) {
                                return "行业产品研发中心";
                            } else {
                                return "项目";
                            }
                        }
                    },
                    {field: 'name', title: '服务器名称'},
                    {field: 'manager', title: '总负责人'},
                    {field: 'IPAddress', title: 'ip地址'},
                    {field: 'endTime', title: '到期日期'},
                    {
                        field: 'type',
                        title: '类型',
                        formatter: function (value, row, index) {
                            if (value == 0) {
                                return "云服务器";
                            } else {
                                return "云硬盘";
                            }
                        }
                    },
                    {
                        field: 'hasDate',
                        title: '到期剩余天数',
                        sortable: "true",
                        styler: function (value, row, index) {
                            if (value > 30) {
                                return 'color:#90EE90';
                            } else if (value > 7) {
                                return 'color:#F4A460';
                            } else {
                                return 'color:#FF0000';
                            }
                        }
                    },
                    {
                        field: 'operate',
                        title: '操作',
                        width: 50,
                        formatter: function (value, row, index) {
                            var str = '<a href="javascript:void(0)" class="easyui-linkbutton" name="updateCloudOne" onclick="openUpdateCloudWindow(' + row.id + ')"></a>' +
                                '<a href="javascript:void(0)" class="easyui-linkbutton" name="deleteCloudOne" onclick="deleteCloud(' + row.id + ')"></a>';
                            return str;
                        }
                    }
                ]
            ],
            onLoadSuccess: function (data) {
                $("a[name='updateCloudOne']").linkbutton({
                    text: '修改',
                    iconCls: 'icon-edit'
                })
                $("a[name='deleteCloudOne']").linkbutton({
                    text: '删除',
                    iconCls: 'icon-remove'
                })
            },
            pagination: true,//显示分页工具栏
            pagePosition: 'bottom',//定义分页工具栏的位置
            pageSize: 10,//设置分页属性的时候初始化页面大小
            pageList: [10, 20, 50],//设置分页属性的时候 初始化页面大小选择列表
            // sortName: "hasDate",//指定排序的字段名称
            // sortOrder: "asc",//指定排列方式
            // remoteSort: false,//关闭服务器对数据排序
            toolbar: '#tencentCloudDataGrid_toolbar'
        })
    }

</script>


</body>

</html>
 