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
<%-- 分页相关 --%>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript" src="<%=basePath%>view/user/listPage.js"></script>
<script type="text/javascript">
        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>
</head>
<body onload="load()">
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
						<button type="submit" class="button border-red">
							<span class="icon-trash-o"></span> 批量删除
						</button> <a href="<%=basePath%>view/user/user_add.jsp"
						class="button border-red"><span class="icon-trash-o"></span>增加</a>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>

					<th width="120">姓名</th>
					<th>学号</th>
					<th>地址</th>
					<th>班级</th>
					<th>性别</th>
					<th>状态</th>
					<th>籍贯</th>
					<th>政治面貌</th>
					<th>生日</th>
					<th colspan="3">操作</th>
				</tr>
				<c:forEach items="${studentMessage}" var="score">
					<tr>
						<td>${score.studentName }</td>
						<td>${score.studentId }</td>
						<td>${score.studentAddress }</td>
						<td>${score.className }</td>
						<td>${score.studentSex }</td>
						<td>${score.studentStatus }</td>
						<td>${score.studentNationality }</td>
						<td>${score.studentPoliticalStatus }</td>
						<td><fmt:formatDate value="${score.studentBirthday }"
								pattern="yyyy年MM月dd日 HH:mm:ss" /></td>
						<td><div class="button-group">
								<a class="button border-red"
									href="<%=basePath%>view/ydj/keyword_update.jsp"><span
									class="icon-trash-o"></span>修改密码</a>  <a class="button border-red"
									href="javascript:void(0)" onclick="return del(1)"><span
									class="icon-trash-o"></span> 删除</a>
							</div></td>
					</tr>
					</c:forEach>
			</table>
		</div>
		<div align="center" id="jpager"></div>
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