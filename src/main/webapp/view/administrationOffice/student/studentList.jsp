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
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/kkpager/jpager.css">
    <script type="text/javascript" src="<%=basePath%>view/administrationOffice/student/listPage.js"></script>
</head>
<body onload="load()">
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 学生管理</strong></div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                    <a href="<%=basePath%>view/administrationOffice/student/studentAdd.jsp" class="button border-blue"
                       id=""><span
                            class="icon-plus"></span> 添加
                    </a>
                </li>
                <li>
                    <form action="<%=basePath%>administrationOfficeController/studentListUi.do" method="post"
                          class="pull-right navbar-form navbar-right" role="search">
                        <div class="form-group pull-left">
                            <input type="text" name="studentName" class="form-control" placeholder="Search">
                        </div>
                        <div style="width:10px;" class="pull-left"></div>
                        <button type="submit" class="pull-right btn btn-default">搜索</button>
                    </form>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">学号</th>
                <th>姓名</th>
                <th>生日</th>
                <th>性别</th>
                <th>住址</th>
                <th>民族</th>
            </tr>
            <c:forEach var="student" items="${pageResult.dataList}">
                <tr>
                    <td><input type="checkbox" name="id[]" value="${student.studentId}"/>
                            ${student.studentId}
                    </td>
                    <td>${student.studentName}</td>
                    <td><fmt:formatDate value="${student.studentBirthday}" type="date"></fmt:formatDate></td>
                    <td>${student.studentSex}</td>
                    <td>${student.studentAddress}</td>
                    <td>${student.studentNationality}</td>
                    <td>
                        <div class="button-group">
                            <a class="button border-red"
                               href="<%=basePath%>administrationOfficeController/deleteStudent.do?studentId=${student.studentId}"><span
                                    class="icon-trash-o"></span> 删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<div align="center" id="jpager"></div>
<script type="text/javascript">
    function load() {
        arrayPage(${pageResult.pages}, ${pageResult.total});
    }

    function del(id) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect() {
        var Checkbox = false;
        var idList = new Array();
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
                idList.push(this.value);
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            console.log(idList);
            if (t == false) {
                return false;
            } else {
                $.ajax({
                    url: "<%=basePath%>userController/deleteUserList.do",
                    data: {
                        idList: idList
                    },
                    type: "post",
                    success: function () {
                        alert("成功");
                        location.reload(true);
                    }
                });
            }
        }
        else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body>
</html>
