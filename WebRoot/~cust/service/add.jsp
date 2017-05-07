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
	function addService() {
		var serviceType = document.getElementById("type").value;
		var servNo = document.getElementById("servNo").value;
		var servTitle = document.getElementById("servTitle").value;
		var servRequest = document.getElementById("servRequest").value;
		if (serviceType == 3) {
			alert("请选择正确的类型");
			return false;
		}
		if (servNo == "") {
			alert("编号不能为空");
			return false;
		}
		if (servTitle == "") {
			alert("概要不能为空");
			return false;
		}
		if (servRequest == "") {
			alert("请求不能为空");
			return false;
		}
		alert("保存成功");
		form1.submit();
	}
</script>
</head>
<body>

	<div class="page_title">客户服务管理 > 服务创建</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="addService()">保存</button>
	</div>
	<form action="serviceManagerAction!addService" method="post"
		name="form1">
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input name="serviceManager.servNo" id="servNo" value="${requestScope.myid}"/>
				</td>
				<th>服务类型</th>
				<td><s:select list="#request.serviceTypeList"
						name="serviceManager.servType" listKey="basiValue"
						listValue="basiItem" headerKey="3" headerValue="请选择" id="type"></s:select>
					<span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>概要</th>
				<td colspan="3"><input size="53"
					name="serviceManager.servTitle" id="servTitle" /><span
					class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>客户</th>
				<td><input name="servCustName" size="20" /><span
					class="red_star">*</span>
				</td>
				<th>状态</th>

				<td><input type="hidden" name="serviceManager.servStatus"
					value="1" />新创建</td>
			</tr>
			<tr>
				<th>服务请求</th>
				<td colspan="3"><textarea rows="6" cols="50"
						name="serviceManager.servRequest" id="servRequest"></textarea><span
					class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>创建人</th>
				<td><input name="serviceManager.servCreateBy"
					value="${sessionScope.sysUser.userName}" readonly size="20" /><span
					class="red_star">*</span>
				</td>
				<th>创建时间</th>
				<td><input id="t1" name="serviceManager.servCreateDate"
					readonly size="20" /><span class="red_star">*</span>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table disabled class="query_form_table" id="table3">
		<tr>
			<th>分配给</th>
			<td><select>
					<option>请选择...</option>
					<option>小明</option>
					<option>旺财</option>
					<option>球球</option>
					<option>孙小美</option>
					<option>周洁轮</option>
			</select> <span class="red_star">*</span>
			</td>
			<th>分配时间</th>
			<td><input id="t2" name="T18" readonly size="20" /><span
				class="red_star">*</span>
			</td>
		</tr>
	</table>
	<br />
	<table disabled class="query_form_table" id="table1">
		<tr>
			<th>服务处理</th>
			<td colspan="3"><textarea rows="6" cols="50"></textarea><span
				class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>处理人</th>
			<td><input name="T17" value="刘颖" readonly size="20" /><span
				class="red_star">*</span>
			</td>
			<th>处理时间</th>
			<td><input id="t3" name="T16" readonly size="20" /><span
				class="red_star">*</span>
			</td>
		</tr>
	</table>
	<br />
	<table disabled class="query_form_table" id="table2">
		<tr>
			<th>处理结果</th>
			<td><input name="T10" size="20" /><span class="red_star">*</span>
			</td>
			<th>满意度</th>
			<td><select name="D1">
					<option>请选择...</option>
					<option>☆☆☆☆☆</option>
					<option>☆☆☆☆</option>
					<option>☆☆☆</option>
					<option>☆☆</option>
					<option>☆</option>
			</select><span class="red_star">*</span>
			</td>
		</tr>
	</table>
	<script>
	setCurTime('t1');
	setCurTime('t2');
	setCurTime('t3');
</script>
</body>
</html>