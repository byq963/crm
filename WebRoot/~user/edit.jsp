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
	function updateUser(){
		var beforePassword=document.getElementById("beforePassword").value;
		var afterPassword=document.getElementById("afterPassword").value;
		var userName=document.getElementById("userName").value;
		if(beforePassword==""){
			alert("密码不能为空");
			return false;
		}
		if(userName==""){
			alert("用户名不能为空");
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

<div class="page_title">用户管理&nbsp; &gt; 编辑用户</div>
<div class="button_bar">
	<button class="common_button" onclick="help('欢迎使用');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="updateUser()">保存</button>  
</div>
<form action="userAction!updateUser" method="post" name="form1">
<input  type="hidden" name="user.userId" value="${user.userId}"/>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${user.userId}</td>
		<th>用户名</th>
		<td><input name="userName" value="${user.userName}" id="userName"/>
			　</td>
	</tr>
	<tr>
		<th>现任角色</th>
		<td>${user.sysRole.roleName}</td>
		<th>角色</th>
		<td>
			<s:select list="#request.roleList" listKey="roleId" listValue="roleName" value="user.sysRole.roleId" name="roleId"></s:select>
		</td>
	</tr>	
	
	<tr>
		<th>密码</th>
		<td><input name="userPassword" value="${user.userPassword}" id="beforePassword"/></td>
		<th>确认密码</th>
		<td><input id="afterPassword"/></td>
	</tr>
	
</table>
</form>

</body>
</html>