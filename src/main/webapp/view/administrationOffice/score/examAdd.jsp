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
        <div class="col-md-4 col-sm-4">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="input1" class="col-sm-4 col-xs-4 control-label">学科</label>
                    <div class="col-sm-8 col-xs-8">
                        <select class="form-control" id="input1">
                            <c:forEach var="map" items="${xuekeDictionary}">
                                <option value="${map.code}">${map.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input2" class="col-sm-4 col-xs-4 control-label">学年:</label>
                    <div class="col-sm-8 col-xs-8">
                        <select class="form-control" id="input2">
                            <%--时间选择下拉框--%>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input3" class="col-sm-4 col-xs-4 control-label">学期:</label>
                    <div class="col-sm-8 col-xs-8">
                        <select class="form-control" id="input3">
                            <option value="1">第一学期</option>
                            <option value="2">第二学期</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input4" class="col-sm-4 col-xs-4 control-label">考试名称:</label>
                    <div class="col-sm-8 col-xs-8">
                        <select class="form-control" id="input4">
                            <c:forEach var="map" items="${kaoshiDictionary}">
                                <option value="${map.code}">${map.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8 col-xs-offset-4 col-xs-8">
                        <button type="button" class="btn btn-info btn-block" onclick="submitThisPage();">提交</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-8 col-sm-8">
            <div class="form-group col-sm-5">
                <label for="input1233" class="col-sm-4 col-xs-4 control-label">毕业年:</label>
                <div class="col-sm-8 col-xs-8">
                    <select class="form-control" id="input1233">
                        <%--时间选择下拉框--%>
                    </select>
                </div>
            </div>
            <div class="form-group col-sm-5">
                <div>
                    <input type="text" class="form-control" id="input1234" placeholder="班级名称"/>
                </div>
            </div>
            <div class="form-group col-sm-2">
                <button type="button" class="btn btn-success" onclick="search();">搜索</button>
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
                <c:forEach var="classInfoVo" items="${classList}">
                    <tr id="tr_${classInfoVo.id}">
                        <td>${classInfoVo.className}</td>
                        <td>${classInfoVo.classGraduateYear}</td>
                        <td>${classInfoVo.teacherName}</td>
                        <td class="text-center">
                            <a href="javascript:;"
                               onclick="addClassToList('${classInfoVo.id}','${classInfoVo.className}','${classInfoVo.classGraduateYear}','${classInfoVo.teacherName}');">添加</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    var classInfoList = new Array();

    $(function () {
        var date = new Date();
        var year = date.getFullYear();
        for (var i = year; i > year - 30; i--) {
            //<option value="2018" selected="selected">2018</option>
            $("#input1233").append('<option value="' + i + '">' + i + '</option>');
            $("#input2").append('<option value="' + i + '">' + i + '</option>');
        }
    });

    //把班级添加到list中
    function addClassToList(id, className, year, teacherName) {
        var subject_id = $("#input1").val();
        var year = $("#input2").val();
        var semester = $("#input3").val();
        var examName = $("#input4").val();
        $.ajax({
            url: "<%=basePath%>administrationOfficeController/examExist.do",
            data: {
                "subjectId": subject_id,
                "year": year,
                "semester": semester,
                "examName": examName,
                "classId": id
            },
            type: "post",
            success: function (req) {
                if(req > 0){
                    alert("该班级已经有相同时间段的相同考试了，请检查");
                }else{
                    $("#tr_" + id).remove();
                    classInfoList.push({'id': id, 'className': className, 'year': year, 'teacherName': teacherName});
                    $("#classAddList").append(
                        $('<li id="addLi_' + id + '">' +
                            '<input type="hidden" value="' + id + '"/>' +
                            '<span>' + className + '-' + year + '</span>' +
                            '<a href="javascript:;" onclick="removeClassToList(\'' + id + '\');"> x</a>' +
                            '</li>'
                        )
                    );
                }
            }
        });
    }

    //把班级移除预备list
    function removeClassToList(id) {
        var tempArray = new Array();
        var className;
        var year;
        var teacherName;
        for (var i in classInfoList) {
            var item = classInfoList[i];
            if (item.id == id) {
                className = item.className;
                year = item.year;
                teacherName = item.teacherName;
            } else {
                tempArray.push(item);
            }
        }
        $("#list_tbody").append(
            $('<tr id="tr_' + id + '">' +
                '<td>' + className + '</td>' +
                '<td>' + year + '</td>' +
                '<td>' + teacherName + '</td>' +
                '<td class="text-center">' +
                '<a href="javascript:;" onclick="addClassToList(\'' + id + '\',\'' + className + '\',\'' + year + '\',\'' + teacherName + '\');">添加</a>' +
                '</td>' +
                '</tr>'
            )
        );
        $("#addLi_" + id).remove();
        classInfoList = tempArray;
    }

    //搜索
    function search() {
        var year = $("#input1233").val();
        var className = $("#input1234").val();
        $.ajax({
            url: "<%=basePath%>administrationOfficeController/examAddUiJson.do",
            data: {
                "year": year,
                "className": className
            },
            dataType: 'json',
            type: "post",
            success: function (req) {
                // console.log(req);
                $("#list_tbody").html("");
                for (var i in req) {
                    var id = req[i].id;
                    var className = req[i].className;
                    var year = req[i].classGraduateYear;
                    var teacherName = req[i].teacherName;
                    var flag = false;
                    for (var index in classInfoList) {
                        //如果搜索结果中存在已经添加的，就忽略掉
                        if (classInfoList[index].id == id) {
                            flag = true;
                        }
                    }
                    if (flag != true) {
                        $("#list_tbody").append(
                            $('<tr id="tr_' + id + '">' +
                                '<td>' + className + '</td>' +
                                '<td>' + year + '</td>' +
                                '<td>' + teacherName + '</td>' +
                                '<td class="text-center">' +
                                '<a href="javascript:;" onclick="addClassToList(\'' + id + '\',\'' + className + '\',\'' + year + '\',\'' + teacherName + '\');">添加</a>' +
                                '</td>' +
                                '</tr>'
                            )
                        );
                    }
                }
            }
        });
    }

    //提交
    function submitThisPage() {
        var subject_id = $("#input1").val();
        var year = $("#input2").val();
        var semester = $("#input3").val();
        var examName = $("#input4").val();
        var idList = new Array();
        for (var i in classInfoList) {
            idList.push(classInfoList[i].id);
        }
        $.ajax({
            url: "<%=basePath%>administrationOfficeController/examAdd.do",
            data: {
                "subject_id": subject_id,
                "year": year,
                "semester": semester,
                "examName": examName,
                "idList": idList
            },
            dataType: 'json',
            type: "post",
            success: function (req) {
                if (req == 1) {
                    alert("添加成功");
                    window.location.href = "<%=basePath%>administrationOfficeController/examAddUi.do";
                }
            }
        });
    }
</script>
</body>
</html>