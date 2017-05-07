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
	function addUser(){
		var beforePassword=document.getElementById("beforePassword").value;
		var afterPassword=document.getElementById("afterPassword").value;
		var userName=document.getElementById("userName").value;
		var userLoginname=document.getElementById("userLoginname").value;
		if(beforePassword==""){
			alert("密码不能为空");
			return false;
		}
		if(userName==""){
			alert("用户名不能为空");
			return false;
		}
		if(userLoginname==""){
			alert("登陆名不能为空");
			return false;
		}
		if(beforePassword==afterPassword){
			form1.submit();
		}else{
			alert("前后密码不一致");
			return false;
		}
	}
</script>
</head>
<body>

<div class="page_title">用户管理管理 &gt; 添加用户</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="addUser()">保存</button>
</div>
<form action="userAction!addUser" method="post" name="form1">
<table class="query_form_table">
	<tr>
		<th>用户名</th>
		<td><input name="user.userName" id="userName"/></td>
		<th>角色</th>
		<td><s:select list="#request.roleList" listKey="roleId" listValue="roleName" name="roleId"></s:select>
       </td>
	</tr>
	<tr>
		<th>密码</th>
		<td>
			<input name="user.userPassword" id="beforePassword"/></td>
		<th>确认密码</th>
		<td>
			<input  id="afterPassword"/></td>
	</tr>	
	<tr>
		<th>登录名</th>
		<td><input name="user.userLoginname" id="userLoginname"/></td>
		<th></th>
		<td>
       </td>
	</tr>
</table>
</form>
<br />
</body>
</html>