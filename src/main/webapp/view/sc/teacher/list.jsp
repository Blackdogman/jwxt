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
	<form method="post" action="">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 留言管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
						
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">ID</th>
					<th>工号</th>
					<th>性别</th>
					<th>家庭住址</th>
					<th>国籍</th>
					<th>状态</th>
					<th>身份证号码</th>
					<th>政治面貌</th>
					<th>电话号码</th>
					<th>生日</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${teacherList }" var="teacher">
					<tr>
						<td><input type="checkbox" name="id[]" value="1" /></td>
						<td>${teacher.teacherId }</td>
						<td>${teacher.teacherSex }</td>
						<td>${teacher.teacherAddress }</td>
						<td>${teacher.teacherNationality }</td>
						<td>${teacher.teacherStatus }</td>
						<td>${teacher.teacherCitizenId }</td>
						<td>${teacher.teacherPoliticalStatus }</td>
						<td>${teacher.teacherPhone }</td>
						<td><fmt:formatDate value="${teacher.teacherBirthday }"/>
						
					</td>
						<td><div class="button-group">
								 <a class="button border-blue"
									href="<%=basePath%>TeacherController/updateUI.do?teacherId=${teacher.teacherId}"><span
									class="icon-trash-o"></span> 修改密码</a>
							</div></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>