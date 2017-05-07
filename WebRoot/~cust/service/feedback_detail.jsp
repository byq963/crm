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
	function reflectSuccess() {
		var servResult = document.getElementById("servResult").value;
		var servSatisfy = document.getElementById("servSatisfy").value;
		if (servResult == "") {
			alert("结果不能为空");
			return false;
		}
		if (servSatisfy == 0) {
			alert("请重新选择");
			return false;
		}
		form1.submit();
	}
</script>
</head>
<body>

	<div class="page_title">客户服务管理 &gt; 服务处理</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="reflectSuccess()">保存</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td>${serviceManager.servNo}</td>
			<th>服务类型</th>

			<s:iterator value="#request.serviceTypeList" var="serviceType1">
				<c:if test="${serviceType1.basiValue==serviceManager.servType}">
					<td class="list_data_text">${serviceType1.basiItem}</td>
				</c:if>
			</s:iterator>

		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3">${serviceManager.servTitle}</td>
		</tr>
		<tr>
			<th>客户</th>
			<td>${serviceManager.servCustName}</td>
			<th>状态</th>

			<s:iterator value="#request.serviceStatusList" var="serviceStatus1">
				<c:if test="${serviceStatus1.basiValue==serviceManager.servStatus}">
					<td class="list_data_text">${serviceStatus1.basiItem}</td>
				</c:if>
			</s:iterator>
		</tr>
		<tr>
			<th>服务请求</th>
			<td colspan="3">${serviceManager.servRequest}<br></td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${serviceManager.servCreateBy}</td>
			<th>创建时间</th>
			<td>${serviceManager.servCreateDate}</td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table3">
		<tr>
			<th>分配给</th>
			<td>${serviceManager.servDueTo}</td>
			<th>分配时间</th>
			<td>${serviceManager.servDueDate}</td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table1">
		<tr>
			<th>服务处理</th>
			<td colspan="3">${serviceManager.servDeal}</td>
		</tr>
		<tr>
			<th>处理人</th>
			<td>${serviceManager.servDealName}</td>
			<th>处理时间</th>
			<td>${serviceManager.servDealDate}</td>
		</tr>
	</table>
	<br />
	<form action="serviceManagerAction!reflectSuccess" method="post"
		name="form1">
		<table class="query_form_table" id="table2">
			<tr>
				<th>处理结果</th>
				<td><input name="servResult" size="20"
					value="${serviceManager.servResult}" id="servResult" /><span
					class="red_star">*</span>
				</td>
				<th>满意度</th>

				<td><select name="servSatisfy" id="servSatisfy">
						<option value="0">请选择...</option>
						<option value="5">☆☆☆☆☆</option>
						<option value="4">☆☆☆☆</option>
						<option value="3">☆☆☆</option>
						<option value="2">☆☆</option>
						<option value="1">☆</option>
				</select><span class="red_star">*</span>
				</td>


			</tr>
		</table>
	</form>
</body>
</html>