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
<script type="text/javascript">
$(document).ready(function(){  
     var key=$("#selectedYear").val();
     //根据值让option选中 
     $("#classGraduateYear option[value='"+key+"']").attr("selected","selected"); 
     
     var key=$("#selectedTeacherId").val();
     //根据值让option选中 
     $("#classTeacherId option[value='"+key+"']").attr("selected","selected"); 
}); 
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改班级信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="<%=basePath%>classInfoController/update.do">
				<input type="hidden" name="id" value="${clssInf.id }">
				
				<div class="form-group">
					<div class="label">
						<label>班级名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${clssInf.className }" name="className"
							data-validate="required:请输入班级名称" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>毕业年：</label>
					</div>
					<div class="field">
						<input type="hidden" id="selectedYear" value="${clssInf.classGraduateYear }"/>
						<select name="classGraduateYear" id="classGraduateYear" class="input w50">
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
						<label>班主任姓名：</label>
					</div>
					<div class="field">
						<input type="hidden" id="selectedTeacherId" value="${clssInf.classTeacherId }"/>
						<select name="classTeacherId" id="classTeacherId" class="input w50">
							<option value="">---请选择教师---</option>
							<c:forEach items="${teacherList }" var="teacher">
								<option value="${teacher.teacherId }">${teacher.teacherName }</option>
							</c:forEach>
						</select>
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
		</div>
	</div>

</body>
</html>