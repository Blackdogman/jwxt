<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">

<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/bootstrap.js"></script>



</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="panel admin-panel">
					<div class="panel-head" id="add">
						<strong><span class="icon-pencil-square-o"></span>新增课程</strong>
					</div>
					<div class="body-content">
						<form method="post" class="form-x"
							action="<%=basePath%>courseController/add.do">
							<div class="form-group">
								<div class="label">
									<label>科目：</label>
								</div>
								<div class="field">
									<select name="subject" class="input" id="subject" onchange="validate()">
										<option value="">---请选择科目---</option>
										<c:forEach items="${subjectList }" var="subject">
											<option value="${subject.code }">${subject.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<label>任课老师姓名：</label>
								</div>
								<div class="field">
									<select name="courseTeacherId" class="input" id="courseTeacherId" onchange="validate()">
										<option value="">---请选择教师---</option>
										<c:forEach items="${teacherList }" var="teacher">
											<option value="${teacher.teacherId }">${teacher.teacherName }</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<label>班级：</label>
								</div>
								<div class="field">
									<input type="hidden" value="${classInfo.id }" name="classId"
										id="selectClassId" /> <input type="text" class="input w50"
										value="${classInfo.className }" name="className"
										readonly="readonly" />
									<div class="tips"></div>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<label>学年：</label>
								</div>
								<div class="field">
									<input type="hidden" value="${courseYear }"
										name="selectCourseYear" id="selectCourseYear" /> <select
										name="courseYear" class="input" id="courseYear" onchange="validate()">
										<option value="">---请选择年份---</option>
										<c:forEach items="${yearList }" var="year">
											<option value="${year }">${year }</option>
										</c:forEach>
									</select>
									<div class="tips"></div>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<label>学期：</label>
								</div>
								<div class="field">
									<input type="hidden" value="${courseSemester }"
										name="selectCourseSemester" id="selectCourseSemester" /> <select
										name="courseSemester" class="input" id="courseSemester" onchange="validate()">
										<option value="">---请选择学期---</option>
										<option value="1">---第一学期---</option>
										<option value="2">---第二学期---</option>
									</select>
									<div class="tips"></div>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<label>日期：</label>
								</div>
								<div class="field">
									<select name="courseWeekday" class="input" id="courseWeekday" onchange="validate()">
										<option value="">---请选择日期---</option>
										<option value="1">---星期一---</option>
										<option value="2">---星期二---</option>
										<option value="3">---星期三---</option>
										<option value="4">---星期四---</option>
										<option value="5">---星期五---</option>
									</select>
									<div class="tips"></div>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<label>课时：</label>
								</div>
								<div class="field">
									<select name="coursePeriod" class="input" id="coursePeriod" onchange="validate()">
										<option value="">---请选择课时---</option>
										<option value="1">---第一节---</option>
										<option value="2">---第二节---</option>
										<option value="3">---第三节---</option>
										<option value="4">---第四节---</option>
										<option value="5">---第五节---</option>
										<option value="6">---第六节---</option>
										<option value="7">---第七节---</option>
									</select>
									<div class="tips"></div>
								</div>
							</div>

							<div class="form-group">
								<div class="label">
									<label></label>
								</div>
								<div class="field">
									<input type="submit" value="提交"
										class="button bg-main icon-check-square-o" id="submitBttn"
										disabled="disabled"/>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-8">
				<table class="table table-hover" border=1 id="table1">
					<tr>
						<th>星期一</th>
						<th>星期二</th>
						<th>星期三</th>
						<th>星期四</th>
						<th>星期五</th>
					</tr>
				</table>
			</div>
		</div>
	</div>



</body>
<script>
	$(function(){
	    var courseYear = $("#selectCourseYear").val();
	    var courseSemester = $("#selectCourseSemester").val();
	    
	    //根据值让option选中 
	    $("#courseYear option[value='"+courseYear+"']").attr("selected","selected");
	    $("#courseSemester option[value='"+courseSemester+"']").attr("selected","selected");
	    fuckJSTL();
	});


	function fuckJSTL(){
		$("#table1").html("<tr><th>星期一</th><th>星期二</th><th>星期三</th><th>星期四</th><th>星期五</th></tr>");
		var classId = $("#selectClassId").val();
		var courseYear = $("#selectCourseYear").val();
		var courseSemester = $("#selectCourseSemester").val();
		var temp = "";
		
		$.ajax({
			dataType:"json",
            type:"POST",
            async:false, 
            url:"<%=basePath%>courseController/addCourseList.do",
			data : {
				classId : classId,
				courseYear : courseYear,
				courseSemester : courseSemester
			},
			success : function(data) {
				for (i = 1; i <= 7; i++) {
					temp = "";
					temp += "<tr>";
					for (j = 1; j <= 5; j++) {
						var position = i + "-" + j;
						temp += "<td>";
						temp += "<p class='text-center'>";
						if (data[position] != null) {
							temp += data[position].teacherName;
						}
						temp += "</p>";
						temp += "<p class='text-center'>";
						if (data[position] != null) {
							temp += data[position].subjectName;
						}
						temp += "</p>";
						temp += "</td>";
					}
					temp += "</tr>";
					$("#table1").append(temp);
				}
			},
			error : function(data) {
				alert("rua");
			}
		});
	}

	function validate() {
		var subject = $("#subject").val();
		var courseTeacherId = $("#courseTeacherId").val();
		var courseYear = $("#courseYear").val();
		var courseSemester = $("#courseSemester").val();
		var courseWeekday = $("#courseWeekday").val();
		var coursePeriod = $("#coursePeriod").val();

		if (subject != "" && courseTeacherId != "" && courseYear != "" && courseSemester != "" && courseWeekday != "" && coursePeriod != "") {
			$("#submitBttn").removeAttr("disabled");
		} else {
			$("#submitBttn").attr("disabled", "disabled");
		}
	}
</script>
</html>