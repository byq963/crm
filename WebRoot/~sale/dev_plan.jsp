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
	function savePlan(chanNo, planNo) {
		var planItem = document.getElementById(planNo).value;
		if (planItem == "") {
			alert("不能为空!");
			return false;
		}
		window.location.href = "saleChanceAction!updatePlan?chanNo=" + chanNo
				+ "&planNo=" + planNo + "&planItem=" + planItem;
	}
	function addPlan() {
		var planDate = document.getElementById("planDate").value;
		var planItem = document.getElementById("planItem").value;
		if (planDate == "") {
			alert("不能为空!");
			return false;
		}
		if (planItem == "") {
			alert("不能为空!");
			return false;
		}
		form2.submit();
	}
</script>
</head>
<body>

	<div class="page_title">客户开发计划 &gt; 制定计划</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button"
			onclick="window.location.href='saleChanceAction!doPlan?chanNo=${saleChance1.chanNo}'">执行计划</button>
		<button class="common_button" onclick="back();">返回</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td>${saleChance.chanNo}</td>
			<th>机会来源</th>
			<td>${saleChance.chanSource}</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td>${saleChance.chanCustName}</td>
			<th>成功机率（%）</th>
			<td>&nbsp;${saleChance.chanRate}</td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3">${saleChance.chanTitle}</td>
		</tr>
		<tr>
			<th>联系人</th>
			<td>${saleChance.chanLinkman}</td>
			<th>联系人电话</th>
			<td>${saleChance.chanMoblie}</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3">${saleChance.chanDescription}</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${saleChance.chanCreateBy}</td>
			<th>创建时间</th>
			<td>${saleChance.chanCreateDate}</td>
		</tr>
		<tr>
			<th>指派给</th>
			<td>${saleChance.chanDueTo}</td>
			<th>指派时间</th>
			<td>${saleChance.chanDueDate}</td>
		</tr>
	</table>
	<br />

	<table class="data_list_table" id="table1">
		<tr>
			<th width="150px">日期</th>
			<th height="31">计划项</th>
		</tr>
		<s:iterator value="#request.saleChance.salePlans" var="salePlan1">
			<c:if test="${salePlan1.planFlag==1}">
				<tr>
					<td class="list_data_text" height="24">${salePlan1.planDate}</td>
					<td class="list_data_ltext" height="24"><input type="hidden"
						id="chanNo" value="${saleChance1.chanNo}" maxlength="50" /> <input
						type="hidden" id="planNo" value="${salePlan1.planNo}" /> <input
						size="50" value="${salePlan1.planItem}" id="${salePlan1.planNo}"
						maxlength="50" />
						<button class="common_button"
							onclick="savePlan('${saleChance1.chanNo}','${salePlan1.planNo}');">保存</button>
						<button class="common_button"
							onclick="window.location.href='saleChanceAction!deletePlan?chanNo=${saleChance1.chanNo}&planNo=${salePlan1.planNo}'">删除</button>
					</td>
				</tr>
			</c:if>
		</s:iterator>
	</table>

	<div class="button_bar">
		<button class="common_button" onclick="addPlan()">保存</button>
	</div>
	<form action="saleChanceAction!savePlan" method="post" name="form2">
		<input type="hidden" name="chanNo" value="${saleChance.chanNo}" />
		<table class="query_form_table" id="table2">

			<tr>
				<th>日期</th>
				<td><input id="t1" name="planDate" id="planDate" maxlength="20" readonly="readonly"/><span
					class="red_star">*</span>
				</td>
				<th>计划项</th>
				<td><input size="50" name="planItem" id="planItem"
					maxlength="50" /><span class="red_star">*</span></td>
			</tr>
		</table>
	</form>
	<script>
	setCurTime('t1');
</script>
</body>
</html>