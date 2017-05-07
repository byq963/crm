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
	function saveRecord() {
		var commDate = document.getElementById("commDate").value;
		var commAddress = document.getElementById("commAddress").value;
		var commTitle = document.getElementById("commTitle").value;
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
		form1.submit();
	}
</script>
</head>
<body>

	<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录 &gt; 编辑交往记录</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="saveRecord()">保存</button>
	</div>
	<form action="custAction!saveRecord" method="post" name="form1">
		<input type="hidden" value="${record.commNo}" name="record.commNo" />
		<input type="hidden" value="${custNo}" name="custNo" />
		<table class="query_form_table" id="table1">
			<tr>
				<th>时间</th>
				<td><input name="record.commDate" value="${record.commDate}"
					size="20" id="commDate" /><span class="red_star">*</span>
				</td>
				<th>地点</th>
				<td><input name="record.commAddress"
					value="${record.commAddress}" size="20" id="commAddress" /><span
					class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>概要</th>
				<td><input name="record.commTitle" value="${record.commTitle}"
					size="20" id="commTitle" /><span class="red_star">*</span>
				</td>
				<th>备注</th>
				<td><input name="record.commRemark" size="20"
					value="${record.commRemark}" />
				</td>
			</tr>
			<tr>
				<th>详细信息</th>
				<td colspan="3"><textarea cols="50" rows="6"
						name="record.commDetail">${record.commDetail}</textarea></td>
			</tr>
		</table>
	</form>
</body>
</html>