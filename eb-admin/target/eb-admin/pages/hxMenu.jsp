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
<table id="dg"></table>

<%--添加横向菜单窗口--%>
<div id="addMenuWindow" class="easyui-window" title="添加菜单" style="width:300px;height:200px"
     data-options="iconCls:'icon-add',modal:true,closed:true">
    <center>
        <form method="post" action="javascript:void(0)">
            <table>
                <tr>
                    <td>菜单名</td>
                    <td><input type="text" id="hxMenuName" name="title"></td>
                </tr>
                <tr>
                    <td>跳转地址</td>
                    <td><input type="text" id="hxMenuUrl" name="url"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <a href="javascript:void(0)" id="addHxMenu">添加</a>
                        <a href="javascript:void(0)" id="addHxMenuReset">重置</a>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</div>

<%--修改横向菜单窗口--%>
<div id="updateMenuWindow" class="easyui-window" title="修改菜单" style="width:300px;height:200px"
     data-options="iconCls:'icon-edit',modal:true,closed:true">
    <center>
        <form method="post" action="javascript:void(0)">
            <table>
                <tr>
                    <td>菜单名</td>
                    <td><input type="text" id="updateHxMenuName" name="title"></td>
                </tr>
                <tr>
                    <td>跳转地址</td>
                    <td><input type="text" id="updateHxMenuUrl" name="url"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <a href="javascript:void(0)" id="updateHxMenu">修改</a>
                        <a href="javascript:void(0)" id="updateHxMenuCancel">取消</a>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</div>

<script type="text/javascript">
    <%--表格请求后台java接口--%>
    $("#dg").datagrid({
        url: "<%=basePath%>/admin/getWebMenu.do",
        fit: true,//横线自适应到底部
        rownumbers: true,//显示行号列
        loadMsg: "请稍后",//设置等候信息
        pagination: true,//显示分页工具栏
        pageList: [5, 10, 20, 50],//设置分页大小选择表
        pageSize: 5,//设置默认分页大小
        sortName: "菜单名",//设置哪个字段可以排序
        checkOnSelect: false,//当用户仅在点击该复选框的时候才会被选中或取消
        columns: [
            [
                {checkbox: true},
                {field: 'title', title: '菜单名', width: 150, sortable: true, editor: {type: 'text'}},
                {field: 'url', title: '跳转地址', width: 150, editor: {type: 'text'}},
                {
                    field: 'menuType', title: '菜单类型', width: 150, editor: {type: 'numberbox'},
                    formatter: function (value, row, index) {
                        if (value == 1) {
                            return '横向菜单';
                        } else {
                            return '纵向菜单';
                        }
                    }
                }
            ]
        ],
        toolbar: [
            {
                iconCls: 'icon-add',
                text: "添加",
                handler: function () {
                    $("#addHxMenu").linkbutton({
                        iconCls: 'icon-ok'
                    });
                    $("#addHxMenuReset").linkbutton({
                        iconCls: 'icon-cancel'
                    });
                    $("#hxMenuName").validatebox({
                        required: true,
                        validType: 'length[0,100]'
                    });
                    $("#hxMenuUrl").validatebox({
                        required: true,
                        validType: ['url', 'length[0,255]']
                    })

                    $("#addMenuWindow").window('open');
                }
            }, '-',
            {
                iconCls: 'icon-edit',
                text: "修改",
                handler: function () {
                    //判断复选框中是否选择了一条记录
                    var selections = $("#dg").datagrid('getSelections');
                    var length = selections.length;
                    //只有一条数据时回显数据，否则提示
                    if (length == 1) {
                        //窗口定义
                        $("#updateHxMenu").linkbutton({
                            iconCls: "icon-ok"
                        });
                        $("#updateHxMenuCancel").linkbutton({
                            iconCls: "icon-cancel"
                        });
                        $("#updateHxMenuName").validatebox({
                            required: true
                        });
                        $("#updateHxMenuUrl").validatebox({
                            required: true
                        });
                        //回显数据
                        var row = $("#dg").datagrid('getSelected');
                        $("#updateHxMenuName").val(row.title);
                        $("#updateHxMenuUrl").val(row.url);
                        $("#updateMenuWindow").window('open');
                    } else {
                        $.messager.alert('提示', '请选择一条数据', function () {
                        })
                    }
                }
            }, '-', {
                iconCls: 'icon-remove',
                text: "删除",
                handler: function () {
                    //判断是否选中
                    var selections = $("#dg").datagrid('getSelections');
                    var length = selections.length;
                    //获取批量id
                    var idStr = "";
                    for (var i = 0; i < length; i++) {
                        idStr = idStr + selections[i].id + ",";
                    }
                    console.log(idStr);

                    if (length > 0) {
                        //确认是否删除
                        $.messager.confirm('提示', '您确认要删除所选记录吗？', function (result) {
                            if (result) {
                                $.ajax({
                                    url: "<%=basePath%>/admin/deleteHxMenu.do",
                                    type: "post",
                                    dataType: "json",
                                    data: {
                                        "idStr": idStr
                                    },
                                    success: function (result) {
                                        if (result) {
                                            $.messager.show({
                                                title: '消息',
                                                msg: '删除成功'
                                            });
                                            $("#dg").datagrid('reload');
                                        } else {
                                            $.messager.show({
                                                title: '消息',
                                                msg: '删除失败'
                                            });
                                        }
                                    },
                                    error: function () {
                                        $.messager.show({
                                            title: '消息',
                                            msg: '系统错误'
                                        });
                                    }

                                })
                            }
                        })
                    } else {
                        $.messager.alert('提示', '请至少选择一条数据', function () {
                        })
                    }

                }
            }
        ],
        // 在双击一个单元格的时候开始编辑并生成编辑器，然后定位到编辑器的输入框上
        // 需要在columns中指定editor的type属性，不然ed会获取不到对象
        onDblClickCell: function (index, field, value) {
            if (endEditing()) {
                $(this).datagrid('beginEdit', index);
                var ed = $(this).datagrid('getEditor', {index: index, field: field});
                $(ed.target).focus();
                editIndex = index;
            }
        }
    })

    var editIndex = undefined;

    //结束编辑
    function endEditing() {
        if (editIndex == undefined) {
            return true
        }
        if ($('#dg').datagrid('validateRow', editIndex)) {// 验证指定的行，当验证有效的时候返回true
            $('#dg').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }

    //添加横向菜单触发ajax
    $("#addHxMenu").click(function () {
        var hxMenuName = $("#hxMenuName").val();
        var hxMenuUrl = $("#hxMenuUrl").val();

        $.ajax({
            url: "<%=basePath%>/admin/addHxMenu.do",
            type: "post",
            dataType: "json",
            data: {
                "hxMenuName": hxMenuName,
                "hxMenuUrl": hxMenuUrl
            },
            success: function (result) {
                if (result) {
                    $.messager.show({
                        title: '消息',
                        msg: '添加成功'
                    });
                    $("#addMenuWindow").window('close');
                    $("#dg").datagrid('reload');
                } else {
                    alert("添加失败");
                }
            },
            error: function () {
                $.messager.alert('提示', '系统错误', function () {
                })
            }
        })
    })

    //重置横向菜单按钮
    $("#addHxMenuReset").click(function () {
        $("#hxMenuName").val(null);
        $("#hxMenuUrl").val(null);
    })

    //点击修改按钮触发ajax
    $("#updateHxMenu").click(function () {
        var title = $("#updateHxMenuName").val();
        var url = $("#updateHxMenuUrl").val();
        var id = $("#dg").datagrid('getSelected').id;

        $.ajax({
            url: "<%=basePath%>/admin/updateHxMenu.do",
            type: "post",
            dataType: "json",
            data: {
                "hxMenuName": title,
                "hxMenuUrl": url,
                "id": id
            },
            success: function (resutle) {
                if (resutle) {
                    $.messager.show({
                        title: '消息',
                        msg: '修改成功',
                    });
                    $("#updateMenuWindow").window('close');
                    $("#dg").datagrid("reload");
                } else {
                    $.messager.show({
                        title: '消息',
                        msg: '修改失败',
                    });
                    $("#updateMenuWindow").window('close');
                }
            },
            error: function () {
                $.messager.show({
                    title: '消息',
                    msg: '系统错误',
                });
                $("#updateMenuWindow").window('close');
            }
        })
    })

</script>

</body>

</html>
 