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

</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改课程</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="<%=basePath%>courseController/update.do">
				<input type="hidden" value="${course.id }" name="id"
							id="id" /> 
				<div class="form-group">
					<div class="label">
						<label>科目：</label>
					</div>
					<div class="field">
						<input type="hidden" value="${course.courseSubjectId }" name="SelectCourseSubjectId"
							id="SelectCourseSubjectId" /> 
						<select name="courseSubjectId" class="input" id="courseSubjectId" onchange="validate()">
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
						<input type="hidden" value="${course.courseTeacherId }" name="SelectCourseTeacherId"
							id="SelectCourseTeacherId" /> 
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
						<input type="hidden" value="${classInfo.id }" name="courseClassId"
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
						<input type="hidden" value="${course.courseYear }" name="courseYear"
							id="courseYear" /> 
						<input type="text" value="${course.courseYear }年" class="input"
							name="ShowCourseYear" id="ShowCourseYear" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>学期：</label>
					</div>
					<div class="field">
						<input type="hidden" value="${course.courseSemester }" name="courseSemester"
								id="courseSemester" /> 
						<input type="text" value="第${course.courseSemester }学期" class="input"
							name="ShowCourseSemester" id="ShowCourseSemester" readonly="readonly"/> 
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>日期：</label>
					</div>
					<div class="field">
						<input type="hidden" value="${course.courseWeekday }" name="courseWeekday"
									id="courseWeekday" /> 
						<input type="text" value="星期${course.courseWeekday }" class="input"
							name="ShowCourseWeekday" id="ShowCourseWeekday" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>课时：</label>
					</div>
					<div class="field">
						<input type="hidden" value="${course.coursePeriod }" name="coursePeriod"
									id="coursePeriod" />
						<input type="text" value="第${course.coursePeriod }节课" class="input"
							name="ShowCoursePeriod" id="ShowCoursePeriod" readonly="readonly"/>
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
</body>
<script type="text/javascript">
$(function(){
    var courseSubjectId = $("#SelectCourseSubjectId").val();
    var courseTeacherId = $("#SelectCourseTeacherId").val();
    
    //根据值让option选中 
    $("#courseSubjectId option[value='"+courseSubjectId+"']").attr("selected","selected");
    $("#courseTeacherId option[value='"+courseTeacherId+"']").attr("selected","selected");
    fuckJSTL();
});

function validate() {
	var subject = $("#courseSubjectId").val();
	var courseTeacherId = $("#courseTeacherId").val();

	if (subject != "" && courseTeacherId != "") {
		$("#submitBttn").removeAttr("disabled");
	} else {
		$("#submitBttn").attr("disabled", "disabled");
	}
}
</script>
</html>