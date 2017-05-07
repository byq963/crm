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

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 &gt; 订单明细 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table" height="59">
	<tr>
		<th>订单编号</th>
		<td>${order.ordeNo}</td>
		<th>日期</th>
		<td>${order.ordeDate}</td>
	</tr>
	<tr>
		<th height="28">送货地址</th>
		<td>${order.ordeAddress}　</td>
		<th height="28">总金额（元）</th>
		<td>${allMoney}</td>
	</tr>
	<tr>
		<th height="28">状态</th>
		<c:if test="${order.ordeStatus==1}">
		<td>已回款</td>
		</c:if>
		<c:if test="${order.ordeStatus==0}">
		<td>未回款</td>
		</c:if>
		<th height="28">&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>商品</th>
		<th>数量</th>
		<th>单位</th>
		<th>单价（元）</th>
		<th>金额（元）</th>
	</tr>
	<s:iterator value="#request.order.ordersLines" var="ordersLines">
	<tr>
		<td class="list_data_text">${ordersLines.product.prodName}</td>
		<td class="list_data_ltext">${ordersLines.lineCount}</td>
		<td class="list_data_text">${ordersLines.lineUnit}</td>
		<td class="list_data_text">${ordersLines.product.prodPrice}</td>
		<td class="list_data_text">${ordersLines.lineCount*ordersLines.product.prodPrice}</td>
	</tr>
	</s:iterator>
	</table>
</body>
</html>