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
<script>
	$(function() {
		var array = new Array();
		<c:forEach items="${ids}" var="item" >
		array.push("${item}"); //对象，加引号       
		</c:forEach>

		for (var i = 0; i < array.length; i++) {
			$("#"+array[i] ).attr("checked", "checked");
		}
	})
</script>

</head>
<body>
	<form action="<%=basePath%>classInfoController/distributeStudent.do" method="post">
		<input type="hidden" name="id" value="${classInfo.id }">
		<div class="panel admin-panel">
			<div class="panel-head" id="add">
				<strong><span class="icon-pencil-square-o"></span>分配学生&nbsp;&nbsp;班级：<font
					color="red">${classInfo.className }</font></strong>
			</div>
			<div class="body-content">
				<c:forEach items="${studentList }" var="student">
					<div class="field">
						<input type="checkbox" name="studentIds" value="${student.studentId }"
							style="width: auto;" id="${student.studentId }">学号：${student.studentId }&nbsp;&nbsp;&nbsp;&nbsp;姓名：${student.studentName }
						<div class="tips"></div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label></label>
			</div>
			<div class="field">
				<input type="submit" value="提交"
					class="button bg-main icon-check-square-o">
			</div>
		</div>	
	</form>
</body>
</html>