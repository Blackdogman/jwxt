<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt=""/>后台管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span>
        前台首页</a>
        &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span>
            清除缓存</a>
        &nbsp;&nbsp;<a class="button button-little bg-red" href="login.html"><span
                class="icon-power-off"></span> 退出登录</a>
        <div style="color: white;">欢迎您：${sessionScope.loginUser.userLoginName}</div>

    </div>
</div>
<div class="leftnav" style="overflow: auto; height: 90%;">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>管理员</h2>
    <ul style="display:block">
        <li><a href="<%=basePath%>MenuController/list.do" target="right"><span
                class="icon-caret-right"></span>菜单管理</a></li>
        <li><a href="<%=basePath%>RoleController/list.do" target="right"><span
                class="icon-caret-right"></span>分配角色</a></li>
    </ul>

    <h2><span class="icon-user"></span>教务处</h2>
    <ul style="display:block">
        <li><a href="<%=basePath%>administrationOfficeController/studentListUi.do" target="right"><span
                class="icon-caret-right"></span>学生管理</a></li>
        <li><a href="<%=basePath%>administrationOfficeController/teacherListUi.do" target="right"><span
                class="icon-caret-right"></span>老师管理</a></li>
        <li><a href="<%=basePath%>administrationOfficeController/examAddUi.do" target="right"><span
                class="icon-caret-right"></span>考试添加</a></li>
        <li><a href="<%=basePath%>administrationOfficeController/scoreAddUi.do" target="right"><span
                class="icon-caret-right"></span>分数添加</a></li>
        <li><a href="<%=basePath%>classInfoController/listPage.do" target="right"><span
                class="icon-caret-right"></span>班级查询</a></li>
        <li><a href="<%=basePath%>courseController/courseList.do" target="right"><span
                class="icon-caret-right"></span>课程查询</a></li>
    </ul>

    <h2><span class="icon-user"></span>学生</h2>
    <ul style="display:block">
        <li><a href="<%=basePath%>#" target="right"><span
                class="icon-caret-right"></span>制作中....</a></li>
    </ul>

    <h2><span class="icon-user"></span>老师</h2>
    <ul style="display:block">
        <li><a href="<%=basePath%>TeacherController/list.do" target="right"><span
                class="icon-caret-right"></span>个人基本信息</a></li>
        <li><a href="<%=basePath%>TeacherController/lesson.do" target="right"><span
                class="icon-caret-right"></span>课表查询</a></li>
        <li><a href="<%=basePath%>TeacherController/score.do" target="right"><span
                class="icon-caret-right"></span>成绩查询</a></li>
    </ul>

    <h2><span class="icon-user"></span>邮件</h2>
    <ul style="display:block">
        <li><a href="<%=basePath%>mailController/mailSendUi.do" target="right"><span
                class="icon-caret-right"></span>发送邮件</a></li>
        <li><a href="<%=basePath%>mailController/mailMyBox.do" target="right"><span
                class="icon-caret-right"></span>收件箱</a></li>
        <li><a href="<%=basePath%>mailController/mailSendHistoryUi.do" target="right"><span
                class="icon-caret-right"></span>发件箱</a></li>
        <li><a href="<%=basePath%>mailController/mailDraftBox.do" target="right"><span
                class="icon-caret-right"></span>草稿箱</a></li>
        <li><a href="<%=basePath%>mailController/mailDeleteBox.do" target="right"><span
                class="icon-caret-right"></span>垃圾箱</a></li>
    </ul>
</div>
<script type="text/javascript">
    function menuClick(menuId) {
        if ($("#ul_" + menuId + "").html() == '') {
            $.ajax({
                url: "<%=basePath%>menuController/getKidMenuList.do",
                data: {
                    menuId: menuId
                },
                type: "post",
                async: false,
                success: function (req) {
                    $("#ul_" + menuId + "").html(req);
                }
            });
        } else {
            $("#ul_" + menuId + " li").toggle();
        }
    }
</script>
<ul class="bread">
    <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="<%=basePath%>view/frame/info.jsp" name="right" width="100%"
            height="100%"></iframe>
</div>
<div style="text-align:center;">
    <p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>
