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
	function addLinkman(){
		var linkName=document.getElementById("linkName").value;
		var linkNo=document.getElementById("linkNo").value;
		if(linkName==""){
			alert("联系人姓名不能为空!");
			return false;
		}
		if(linkNo==""){
			alert("联系人编号不能为空!");
			return false;
		}
		form1.submit();
	}
</script>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 新建联系人</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="addLinkman();">保存</button>  
</div>
<form action="custAction!addLinkman" method="post" name="form1">
<input type="hidden" name="custNo" value="${custNo}"/>
<table class="query_form_table">
	<tr>
		<th>姓名</th>
		<td><input name="custLinkman.linkName" id="linkName"/><span class="red_star">*</span></td>
		<th>性别</th>
		<td>
			<s:radio list="#{0:'男',1:'女'}" name="custLinkman.linkSex"></s:radio>
		</td>
	</tr>
	<tr>
		<th>职位</th>
		<td><input name="custLinkman.linkPosition"/><span class="red_star">*</span></td>
		<th>办公电话</th>
		<td><input name="custLinkman.linkTelephone"/><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>手机</th>
		<td><input name="custLinkman.linkMobile" size="20" /></td>
		<th>备注</th>
		<td><input name="custLinkman.linkRemark" size="20" /></td>
	</tr>
	<tr>
		<th>编号</th>
		<td><input name="custLinkman.linkNo" size="20" id="linkNo" value="${requestScope.myid}"/></td>
		<th></th>
		<td></td>
	</tr>
</table>
</form>
</body>
</html>