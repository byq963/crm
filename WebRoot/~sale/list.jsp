<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	function goreload(){
		//通过id获取文本框中输入的值
		var pagesize=document.getElementById("pagesize").value;
		var page=document.getElementById("page").value;
		var allpage=document.getElementById("allpage").value;
		if(/\D/.test(page)){
			alert("只能输入数字");
			return false;
		}
		if(/\D/.test(pagesize)){
			alert("只能输入数字");
			return false;
		}
		if(page<allpage+1){
		window.location.href="saleChanceAction!showFirst?page="+page+"&pagesize="+pagesize;
		}else{
			alert("输入的页数超过最大页数");
		}
	}
	function keydown(){
		var pagesize=document.getElementById("pagesize").value;
		var count=document.getElementById("count").value;
		if(/\D/.test(pagesize)){
			alert("只能输入数字");
			return false;
		}
		if(pagesize>count){
			alert("超过了最大条数!");
			return false;
		}
		window.location.href="saleChanceAction!showFirst?page="+1+"&pagesize="+pagesize;
	}
	function query(){
		form1.submit();
	}
	function addInput(){
		window.location.href="~sale/add.jsp";
	}
	
</script>	
</head>
<body>

<div class="page_title">销售机会管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="addInput()">新建</button>  
	<button class="common_button" onclick="query()">查询</button> 
	</div>
<form action="saleChanceAction!showQuery" name="form1" method="post">
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input id="chanCustName" name="chanCustName" maxlength="20"/></td>
		<th>概要</th>
		<td><input id="chanTitle" name="chanTitle" maxlength="20"/></td>
		<th>联系人</th>
		<td>
			<input name="chanLinkman" id="chanLinkman" size="20" maxlength="20"/>
		</td>
	</tr>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.saleChanceList" var="saleChance1" status="status">
	<tr>
		<td class="list_data_number">${saleChance1.chanNo}</td>
		<td class="list_data_text">${saleChance1.chanCustName}</td>
		<td class="list_data_ltext">${saleChance1.chanTitle}</td>
		<td class="list_data_text">${saleChance1.chanLinkman}</td>
		<td class="list_data_text">${saleChance1.chanMoblie}</td>
		<td class="list_data_text">${saleChance1.chanCreateDate}</td>
		<td class="list_data_op">
			<c:if test="${sessionScope.sysUser.sysRole.roleName=='销售主管'}">
			<c:if test="${saleChance1.chanStatus==0}">
			<img onclick="window.location.href='saleChanceAction!appointInput?chanNo=${saleChance1.chanNo}'" title="指派" src="images/bt_linkman.gif" class="op_button" />
			</c:if>
			</c:if>
			<img onclick="window.location.href='saleChanceAction!updateInput?chanNo=${saleChance1.chanNo}'" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<c:if test="${sessionScope.sysUser.userName==saleChance1.chanCreateBy}">
			<img onclick="window.location.href='saleChanceAction!delete?chanNo=${saleChance1.chanNo}'" title="删除" src="images/bt_del.gif" class="op_button" />
			</c:if>
		</td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	<input type="hidden" value="${requestScope.count}" id="count"/>
	<input type="hidden" value="${requestScope.allpage}" id="allpage"/>
	共${requestScope.count}条记录 每页<input value="${pagesize}" size="2" id="pagesize" onkeyup="keydown()" name="pagesize"/>条
	第${page}页/共${requestScope.allpage}页
	<a href="saleChanceAction!showFirst?page=1&pagesize=${pagesize}">第一页</a>
	<c:if test="${page>1}">
	<a href="saleChanceAction!showFirst?page=${page-1}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${page<2}">
	<a href="saleChanceAction!showFirst?page=${page}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${requestScope.allpage>page}">
	<a href="saleChanceAction!showFirst?page=${page+1}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<c:if test="${requestScope.allpage<page+1}">
	<a href="saleChanceAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<a href="saleChanceAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">最后一页</a>
	转到<input value="${page}" size="2" id="page" />页
	<button width="20" onclick="goreload()">GO</button>
</div>
		</th>
	</tr>
</table>

</body>
</html>