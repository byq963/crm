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
	function saveDelay(){
		form1.submit();
	}
</script>
</head>
<body>

<div class="page_title">客户流失管理 &gt; 确认流失</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="window.location.href='custLostAction!confirmInput?lostNo=${custLost.lostNo}'">确认流失</button>
	<button class="common_button" onclick="saveDelay()">保存</button>
</div>
<form action="custLostAction!saveDelay" method="post" name="form1">
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${custLost.lostNo}</td>
		<th>客户</th>
		<td>${custLost.custCustomer.custName}</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>
			${custLost.lostManagerName}</td>
		<th>上次下单时间</th>
		<td>
			${custLost.lostLastOrderDate}</td>
	</tr>	
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">
			${custLost.lostDelay}</td>
	</tr>
	<tr>
		<th>追加暂缓措施</th>
		<td colspan="3">
			<textarea rows="6" cols="50" name="lostDelay">${custLost.lostDelay}</textarea><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<br />
</body>
</html>