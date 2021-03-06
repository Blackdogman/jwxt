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
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <div class="col-md-12">

        </div>
        <div class="col-md-12">
            <div class="form-group col-sm-6">
                <label for="input12335" class="col-sm-3 col-xs-3 control-label">学生名字:</label>
                <div class="col-sm-9 col-xs-9">
                    <input type="input" class="form-control" id="input12335"/>
                </div>
            </div>
            <div class="form-group col-sm-6">
                <button type="button" class="btn btn-success col-md-2" onclick="search();">搜索</button>
            </div>
            <table class="col-md-12 col-sm-12 table">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>学生名称</th>
                    <th>民族</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="list_tbody">
                <c:forEach var="student" items="${studentList}">
                    <tr id="tr_${student.studentId}">
                        <td class="text-center">${student.studentId}</td>
                        <td class="text-center">${student.studentName}</td>
                        <td class="text-center">${student.studentNationality}</td>
                        <td class="text-center">
                            <a href="<%=basePath%>administrationOfficeController/studentExamUi.do?studentId=${student.studentId}">添加分数</a>
                        </td>
                    </tr>
                </c:forEach>
                <%--ajax动态添加--%>
                </tbody>
            </table>
        </div>
        <input type="hidden" value="${classId} " id="classId"/>
    </div>
</div>
<script>
    $(function () {
        var date = new Date();
        var year = date.getFullYear();
        for (var i = year; i > year - 30; i--) {
            //<option value="2018" selected="selected">2018</option>
            $("#input1233").append('<option value="' + i + '">' + i + '</option>');
            $("#input12335").append('<option value="' + i + '">' + i + '</option>');
        }
    });

    function search() {
        var studentName = $("#input12335").val();
        var classId = $("#classId").val();
        $.ajax({
            url: "<%=basePath%>administrationOfficeController/searchStudentFormClassByStudentName.do",
            data: {
                "studentName": studentName,
                "classId": classId
            },
            type: "post",
            success: function (req) {
                $("#list_tbody").html("");
                for (var i in req) {
                    var id = req[i].studentId;
                    var name = req[i].studentName;
                    var studentNationality = req[i].studentNationality;
                    $("#list_tbody").append(
                        $('<tr id="tr_' + id + '">' +
                                '<td class="text-center">' + id + '</td>' +
                                '<td class="text-center">' + name + '</td>' +
                                '<td class="text-center">' + studentNationality + '</td>' +
                                '<td class="text-center">' +
                                    '<a href="<%=basePath%>administrationOfficeController/studentExamUi.do?studentId='+id+'">添加分数</a>' +
                                '</td>' +
                            '</tr>'
                        )
                    );
                }
            }
        })
    }
</script>
</body>
</html>