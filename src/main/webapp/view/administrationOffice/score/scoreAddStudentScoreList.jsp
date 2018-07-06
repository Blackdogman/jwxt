<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <table class="col-md-12 col-sm-12 table">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>科目</th>
                    <th>考试年</th>
                    <th>学期</th>
                    <th>考试名称</th>
                    <th style="width:150px;">分数</th>
                </tr>
                </thead>
                <tbody id="list_tbody">
                <c:forEach var="score" items="${scoreList}">
                    <tr id="tr_${score.id}">
                        <td class="text-center">${score.scoreStudentId}</td>
                        <td class="text-center">${score.scoreSubjectId}</td>
                        <td class="text-center">${score.scoreYear}</td>
                        <td class="text-center">${score.scoreSemester}</td>
                        <td class="text-center">${score.scoreBathch}</td>
                        <td class="text-center">
                            <input type="input" name="achievement" class="form-control" id="achievement_${score.id}"
                                   value="${score.scoreAchievement}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button type="button" class="btn btn-success col-md-2 col-md-offset-10" onclick="submitThisPage();">
                提交成绩！
            </button>
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

    function submitThisPage() {
        var submitArray = new Array();
        $("input[name = 'achievement']").each(function () {
            var inputId = $(this).attr("id");
            inputId = inputId.replace("achievement_","");
            var itemStr = inputId + "&bdm&" + $(this).val();
            submitArray.push(itemStr);
        });
        $.ajax({
            url: "<%=basePath%>administrationOfficeController/submitScore.do",
            data: {
                "submitArray": submitArray
            },
            type: "post",
            success: function (req) {
                if(req == 1){
                    alert("提交成功");
                    window.location.href = "<%=basePath%>administrationOfficeController/scoreAddUi.do";
                }
            }
        });
    }
</script>
</body>
</html>