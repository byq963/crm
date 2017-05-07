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

<div class="page_title">客户信息管理 > 客户信息 > 联系人 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="window.location.href='custAction!addInputLinkman?custNo=${cust.custNo}'">新建</button>  
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
		<th>姓名</th>
		<th>性别</th>
		<th>职位</th>
		<th>办公电话</th>
		<th>手机</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.cust.custLinkmans" var="linkman1">
	<c:if test="${linkman1.linkFlag==1}">
	<tr>
		<td class="list_data_text">${linkman1.linkName}</td>
		<c:if test="${linkman1.linkSex==0}">
		<td class="list_data_ltext">男</td>
		</c:if>
		<c:if test="${linkman1.linkSex==1}">
		<td class="list_data_ltext">女</td>
		</c:if>
		<td class="list_data_text">${linkman1.linkPosition}</td>
		<td class="list_data_text">${linkman1.linkTelephone}</td>
		<td class="list_data_text">${linkman1.linkMobile}</td>
		<td class="list_data_op">${linkman1.linkRemark}
			　</td>
		<td class="list_data_op">
			<img onclick="window.location.href='custAction!updateInputLinkman?custNo=${cust.custNo}&linkNo=${linkman1.linkNo}'" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="window.location.href='custAction!deleteLinkman?custNo=${cust.custNo}&linkNo=${linkman1.linkNo}'" title="删除" src="images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</c:if>
	</s:iterator>
	
	</table>
</body>
</html>