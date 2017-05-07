<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	function saveResult(planNo){
		var planResult=document.getElementById(planNo).value;
		if(planResult==""){
			alert("结果不能为空!");
			return false;
		}
		window.location.href="saleChanceAction!saveResult?planNo="+planNo+"&planResult="+planResult;
	}
</script>
</head>
<body>

<div class="page_title">客户开发计划 &gt; 执行计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="alert('开发失败，已归档。');window.location.href='saleChanceAction!stopSaleChance?chanNo=${saleChance.chanNo}&chanStatus=2';">终止开发</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="window.location.href='saleChanceAction!makePlanInput?chanNo=${saleChance.chanNo}'">制定计划</button>
	<button class="common_button" onclick="alert('用户开发成功，已添加新客户记录。');window.location.href='saleChanceAction!sucSaleChance?chanNo=${saleChance.chanNo}&chanStatus=3';">开发成功</button>

	</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${saleChance.chanNo}</td>
		<th>机会来源</th>
		<td>${saleChance.chanSource}
			　</td>
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
		<td>
			${saleChance.chanDueTo}</td>
		<th>指派时间</th>
		<td>
			${saleChance.chanDueDate}</td>
	</tr>
</table>
<br />
<table class="data_list_table" id="table1">
	<tr>
		<th>日期</th>
		<th>计划</th>
		<th>执行效果</th>
	</tr>
	<s:iterator value="#request.saleChance.salePlans" var="salePlan1">
	<c:if test="${salePlan1.planFlag==1}">
	<tr>
		<c:if test="${salePlan1.planResult==null}">
		<td class="list_data_text">${salePlan1.planDate}</td>
		<td class="list_data_ltext">${salePlan1.planItem}</td>
		<td class="list_data_ltext"><input id="${salePlan1.planNo}" />　
	<button class="common_button" onclick="saveResult('${salePlan1.planNo}');">保存</button>
		</td>
		</c:if>
	</tr>
	</c:if>
	</s:iterator>
	</table>
	
</body>
</html>