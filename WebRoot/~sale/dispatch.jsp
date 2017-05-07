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
	function appoint(){
		form3.submit();
	}
</script>
</head>
<body>

<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="appoint()">保存</button>  
</div>
<form action="saleChanceAction!appoint" method="post" name="form3">
<input type="hidden" name="chanNo" value="${requestScope.saleChance.chanNo}"/>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${requestScope.saleChance.chanNo}</td>
		<th>机会来源</th>
		<td>
			　</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>${requestScope.saleChance.chanCustName}</td>
		<th>成功机率（%）</th>
		<td>&nbsp;${requestScope.saleChance.chanRate}</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3">${requestScope.saleChance.chanTitle}</td>
	</tr>
	<tr>
		<th>联系人</th>
		<td>${requestScope.saleChance.chanLinkman}</td>
		<th>联系人电话</th>
		<td>${requestScope.saleChance.chanMoblie}</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">${requestScope.saleChance.chanDescription}</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${requestScope.saleChance.chanCreateBy}</td>
		<th>创建时间</th>
		<td>${requestScope.saleChance.chanCreateDate}</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<td>
		<s:select list="#request.userList" listKey="userId" listValue="userName" id="myselect" name="chanDueTo"></s:select>
			<span class="red_star">*</span></td>
		<th>指派时间</th>
		<td>
			<input id="t2" name="chanDueDate" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<script>
	setCurTime('t2');
</script>
</body>
</html>