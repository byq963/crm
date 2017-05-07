<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function addRecord() {
		var commDate = document.getElementById("commDate").value;
		var commAddress = document.getElementById("commAddress").value;
		var commTitle = document.getElementById("commTitle").value;
		var commNo = document.getElementById("commNo").value;
		if (commDate == "") {
			alert("时间不能为空");
			return false;
		}
		if (commAddress == "") {
			alert("地址不能为空");
			return false;
		}
		if (commTitle == "") {
			alert("概要不能为空");
			return false;
		}
		if (commNo == "") {
			alert("编号不能为空");
			return false;
		}
		form1.submit();
	}
</script>
</head>
<body>

	<div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="addRecord();">保存</button>
	</div>
	<form action="custAction!addRecord" method="post" name="form1">
		<input type="hidden" name="custNo" value="${custNo}" />
		<table class="query_form_table">
			<tr>
				<th>时间</th>
				<td><input name="record.commDate" id="commDate" /><span
					class="red_star">*</span>
				</td>
				<th>地点</th>
				<td><input name="record.commAddress" size="20" id="commAddress" /><span
					class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>概要</th>
				<td><input name="record.commTitle" id="commTitle" /><span
					class="red_star">*</span>
				</td>
				<th>备注</th>
				<td><input name="record.commRemark" />
				</td>
			</tr>
			<tr>
				<th>详细信息</th>
				<td colspan="3"><textarea cols="50" rows="6"
						name="record.commDetail"> </textarea></td>
			</tr>
			<tr>
				<th>编号</th>
				<td><input name="record.commNo" size="20" id="commNo" value="${requestScope.myid}"/>
				</td>
				<th></th>
				<td></td>
			</tr>
		</table>
	</form>
	<script>
	setCurTime('commDate');
</script>
</body>
</html>