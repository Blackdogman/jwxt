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
                <label for="input12335" class="col-sm-4 col-xs-4 control-label">考试年:</label>
                <div class="col-sm-8 col-xs-8">
                    <select class="form-control" id="input12335">
                        <%--时间选择下拉框--%>
                    </select>
                </div>
            </div>
            <div class="form-group col-sm-6">
                <label for="input123355" class="col-sm-4 col-xs-4 control-label">考试学期:</label>
                <div class="col-sm-8 col-xs-8">
                    <select class="form-control" id="input123355">
                        <option value="1">第一学期</option>
                        <option value="2">第二学期</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-sm-6">
                <label for="input1233555" class="col-sm-4 col-xs-4 control-label">考试名称:</label>
                <div class="col-sm-8 col-xs-8">
                    <select class="form-control" id="input1233555">
                        <c:forEach var="map" items="${kaoshiDictionary}">
                            <option value="${map.code}">${map.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group col-sm-6">
                <label for="input1233" class="col-sm-4 col-xs-4 control-label">毕业年:</label>
                <div class="col-sm-8 col-xs-8">
                    <select class="form-control" id="input1233">
                        <%--时间选择下拉框--%>
                    </select>
                </div>
            </div>
            <div class="form-group col-sm-6">
                <label for="input1234" class="col-sm-4 col-xs-4 control-label">班级名称:</label>
                <div class="col-sm-8 col-xs-8">
                    <input type="text" class="form-control" id="input1234" placeholder="班级名称"/>
                </div>
            </div>
            <div class="form-group col-sm-12">
                <button type="button" class="btn btn-success col-md-2" onclick="search();">搜索</button>
            </div>
            <div class="col-md-12 col-sm-12">
                <ul class="list-inline" id="classAddList">
                </ul>
            </div>
            <table class="col-md-12 col-sm-12 table">
                <thead>
                <tr>
                    <th>班级名称</th>
                    <th>毕业年</th>
                    <th>班主任</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="list_tbody">
                <%--ajax动态添加--%>
                </tbody>
            </table>
        </div>
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
        var examYear = $("#input12335").val();
        var semster = $("#input123355").val();
        var bathch = $("#input1233555").val();
        var stdYear = $("#input1233").val();
        var className = $("#input1234").val();
        $.ajax({
            url: "<%=basePath%>administrationOfficeController/scoreAddUiJson.do",
            data: {
                "examYear": examYear,
                "semster": semster,
                "bathch": bathch,
                "stdYear": stdYear,
                "className": className
            },
            type: "post",
            success: function (req) {
                $("#list_tbody").html("");
                for (var i in req) {
                    var id = req[i].id;
                    var className = req[i].className;
                    var year = req[i].classGraduateYear;
                    var teacherName = req[i].teacherName;
                    $("#list_tbody").append(
                        $('<tr id="tr_' + id + '">' +
                            '<td class="text-center">' + className + '</td>' +
                            '<td class="text-center">' + year + '</td>' +
                            '<td class="text-center">' + teacherName + '</td>' +
                            '<td class="text-center">' +
                            '<a href="<%=basePath%>/administrationOfficeController/scoreStudentUi.do?classId='+id+'">学生列表</a>' +
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