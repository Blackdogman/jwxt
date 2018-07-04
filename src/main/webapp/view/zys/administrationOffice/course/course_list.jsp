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

<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/kkpager/jpager.css">
<title></title>
	<script type="text/javascript">
		function secondDrop(){
			var classGraduateYear = $('#selectYear').val();
			$.ajax({
				 dataType:"json",
		            type:"POST",
		            url:"<%=basePath%>courseController/classListUI.do",
		            data:{classGraduateYear:classGraduateYear},
		            success:function(data){
		                var arr=data.classInfo;
		                $('#selectClass').html("");
		                 for(var i=0;i<data.classInfo.length;i++){
		                    var className=arr[i].className;
		                    var classId=arr[i].id;
		                    if (i==0){
		                    	$('#selectClass').append("<option value=''>---请选择班级---</option>");
		                    }
		                    $('#selectClass').append("<option value="+classId+">"+className+"</option>");
		                }  
		            },error:function(data){
		                alert("rua");
		            }
			})
		};
		
		function setClassId(){
			var classId = $("#selectClass").val();
			var courseYear = $("#selectCourseYear").val();
			var courseSemester = $("#selectCourseSemester").val();
			
			if(classId!=null && classId!="" && courseYear!= null && courseYear!= "" && courseSemester!=null && courseSemester!=""){
				$("#addButton").attr("href","<%=basePath%>courseController/addUI.do?classId="+classId+"&courseYear="+courseYear+"&courseSemester="+courseSemester);
			}else{
				$("#addButton").attr("href","javascript:");
			}
		};
	</script>

</head>
<body >
	<form method="post" action="<%=basePath%>courseController/courseList.do">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 课程管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<select name="classGraduateYear" class="input w50" id="selectYear" onchange="secondDrop()">
							<option value="">---请选择年级---</option>
							<c:forEach items="${yearList }" var="year">
								<option value="${year }">${year }级</option>
							</c:forEach>
						</select>
						<select name="classId" class="input w50" id="selectClass" onchange="setClassId()">
							<option value="">---请选择班级---</option>
						</select>
						<select name="courseYear" class="input w50" id="selectCourseYear" onchange="setClassId()">
							<option value="">---请选择学年---</option>
							<c:forEach items="${yearList }" var="year">
								<option value="${year }">${year }学年</option>
							</c:forEach>
						</select>
						<select name="courseSemester" class="input w50" id="selectCourseSemester" onchange="setClassId()">
							<option value="">---请选择学期---</option>
							<option value="1">---第一学期---</option>
							<option value="2">---第二学期---</option>
						</select>
						
						<button type="submit" class="button border-green" id="search" >
							<span class="icon-check"></span> 查询
						</button>
						
						<a id="addButton" href="javascript:" class="button border-green"><span class="icon-check"></span>添加课程</a>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">星期一</th>
					<th>星期二</th>
					<th>星期三</th>
					<th>星期四</th>
					<th>星期五</th>
				</tr>
				<c:forEach begin="1" end="7" var="row">
					<tr>
						<c:forEach begin="1" end="5" var="column"> 
							<c:set value="${row }-${column }" var="position"></c:set>
							<td>
								<p>${courseMap[position].teacherName }</p>
								<p>${courseMap[position].subjectName }</p>
								<c:if test="${courseMap[position].id !=null}">
									<a href="<%=basePath%>courseController/updateUI.do?courseId=${courseMap[position].id }">修改</a>
									<a href="<%=basePath%>courseController/delete.do?courseId=${courseMap[position].id }">删除</a>
								</c:if>
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div align="center" id="jpager"></div>
	</form>

</body>
</html>