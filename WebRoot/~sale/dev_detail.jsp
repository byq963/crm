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
</head>
<body>

<div class="page_title">客户开发计划 &gt; 查看</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
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
		<td>${saleChance.chanTitle}</td>
		<th>状态</th>
		<c:if test="${saleChance.chanStatus==2}">
		<td style="color:red;">开发失败</td>	
		</c:if>
		<c:if test="${saleChance.chanStatus==3}">
		<td style="color:red;">开发成功</td>	
		</c:if>
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
		<c:forEach items="${sessionScope.sysRole.sysUsers}" var="sysUser1">
		<c:if test="${sysUser1.userId==saleChance.chanDueTo}">
		<td>
			${sysUser1.userName}</td>
			</c:if>
		</c:forEach>
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
		<td class="list_data_text">${salePlan1.planDate}</td>
		<td class="list_data_ltext">${salePlan1.planItem}</td>
		<td class="list_data_ltext">${salePlan1.planResult}
		</td>
	</tr>
	</c:if>
	</s:iterator>
	
	</table>
</body>
</html>