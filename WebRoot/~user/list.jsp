<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	function query(){
	function goreload(){
		//通过id获取文本框中输入的值
		var pagesize=document.getElementById("pagesize").value;
		var page=document.getElementById("page").value;
		var allpage=document.getElementById("allpage").value;
		
		if(page<(allpage+1)){
		window.location.href="userAction!showUserFirst?page="+page+"&pagesize="+pagesize;
		}else{
			alert("输入的页数超过最大页数");
		}
	}
	function keydown(){
		var pagesize=document.getElementById("pagesize").value;
		
		window.location.href="userAction!showUserFirst?page="+1+"&pagesize="+pagesize;
	}
		form1.submit();
	}
</script>
</head>
<body>

	<div class="page_title">用户管理</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="window.location.href='userAction!addUserInput'">新建</button>
		<button class="common_button" onclick="query();">查询</button>
	</div>
	<form action="userAction!showUserFirst" method="post" name="form1">
	<table class="query_form_table" border="0" cellPadding="3"
		cellSpacing="0">
		<tr>
			<th>编号</th>
			<td><input type="text" name="userId" >
			</td>
			<th>用户名</th>

			<td><input type="text" name="userName" >
			</td>

		</tr>
	</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th height="28">编号</th>
			<th height="28">用户名</th>
			<th height="28">操作</th>
		</tr>
		<s:iterator value="#request.userList" var="user1">
		<tr>
			<td class="list_data_number" height="27">${user1.userId}</td>
			<td class="list_data_text" height="27">${user1.userName}</td>
			<td class="list_data_text" height="27">
			<img onclick="window.location.href='userAction!updateUserInput?userId=${user1.userId}'" title="编辑" src="images/bt_edit.gif" class="op_button" /> 
			<img onclick="window.location.href='userAction!deleteUser?userId=${user1.userId}'" title="删除" src="images/bt_del.gif" class="op_button" /></td>

		</tr>
		</s:iterator>
		<tr>
			<th colspan="7" class="pager">
				<div class="pager">
	<input type="hidden" value="${requestScope.allpage}" id="allpage"/>
	共${requestScope.count}条记录 每页<input value="${pagesize}" size="2" id="pagesize" onkeyup="keydown()" name="pagesize"/>条
	第${page}页/共${requestScope.allpage}页
	<a href="userAction!showUserFirst?page=1&pagesize=${pagesize}">第一页</a>
	<c:if test="${page>1}">
	<a href="userAction!showUserFirst?page=${page-1}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${page<2}">
	<a href="userAction!showUserFirst?page=${page}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${requestScope.allpage>page}">
	<a href="userAction!showUserFirst?page=${page+1}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<c:if test="${requestScope.allpage<page+1}">
	<a href="userAction!showUserFirst?page=${requestScope.allpage}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<a href="userAction!showUserFirst?page=${requestScope.allpage}&pagesize=${pagesize}">最后一页</a>
	转到<input value="${page}" size="2" id="page" />页
	<button width="20" onclick="goreload()">GO</button>
</div></th>
		</tr>

	</table>
</body>
</html>