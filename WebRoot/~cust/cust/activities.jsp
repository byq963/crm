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

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="window.location.href='custAction!addInputrecord?custNo=${cust.custNo}'">新建</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td>${cust.custNo}</td>
		<th>客户名称</th>
		<td>${cust.custName}</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th width="232">时间</th>
		<th>地点</th>
		<th>概要</th>
		<th>详细信息</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.cust.communicateRecords" var="record1">
	<c:if test="${record1.commFlag==1}">
	<tr>
		<td class="list_data_text" width="230">${record1.commDate}</td>
		<td class="list_data_text">${record1.commAddress}</td>
		<td class="list_data_ltext">${record1.commTitle}</td>
		<td class="list_data_ltext">${record1.commRemark}</td>
		<td class="list_data_op">
			　</td>
		<td class="list_data_op">
			<img onclick="window.location.href='custAction!updateInputRecord?custNo=${cust.custNo}&commNo=${record1.commNo}'" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="window.location.href='custAction!deleteRecord?custNo=${cust.custNo}&commNo=${record1.commNo}'" title="删除" src="images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</c:if>
	</s:iterator>
	</table>
</body>
</html>