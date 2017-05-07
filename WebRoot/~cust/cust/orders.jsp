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
	function goreload(){
		//通过id获取文本框中输入的值
		var pagesize=document.getElementById("pagesize").value;
		var page=document.getElementById("page").value;
		var allpage=document.getElementById("allpage").value;
		if(page<allpage+1){
		window.location.href="custAction!checkOrders?page="+page+"&pagesize="+pagesize;
		}else{
			alert("输入的页数超过最大页数");
		}
	}
	function keydown(){
		var pagesize=document.getElementById("pagesize").value;
		
		window.location.href="custAction!checkOrders?page="+1+"&pagesize="+pagesize;
	}
</script>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 历史订单 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>  
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
		<th>订单编号</th>
		<th>日期</th>
		<th>送货地址</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.ordersList" var="order1">
	<c:if test="${order1.ordeFlag==1}">
	<tr>
		<td class="list_data_text">${order1.ordeNo}</td>
		<td class="list_data_text">${order1.ordeDate}</td>
		<td class="list_data_text">${order1.ordeAddress}</td>
		<c:if test="${order1.ordeStatus==0}">
		<td class="list_data_text">未回款</td>
		</c:if>
		<c:if test="${order1.ordeStatus==1}">
		<td class="list_data_text">已回款</td>
		</c:if>
		<td class="list_data_op">
			<img onclick="window.location.href='custAction!checkOrdersLine?custNo=${cust.custNo}&ordeNo=${order1.ordeNo}'" title="查看明细" src="images/bt_detail.gif" class="op_button" /></td>
	</tr>
	</c:if>
	</s:iterator>
		<tr>
		<th colspan="100" class="pager">
<div class="pager">
	<input type="hidden" value="${requestScope.allpage}" id="allpage"/>
	共${requestScope.count}条记录 每页<input value="${pagesize}" size="2" id="pagesize" onkeyup="keydown()" name="pagesize"/>条
	第<input value="${page}" size="2" id="currentpage"/>页/共${requestScope.allpage}页
	<a href="custAction!checkOrders?page=1&pagesize=${pagesize}">第一页</a>
	<c:if test="${page>1}">
	<a href="custAction!checkOrders?page=${page-1}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${page<2}">
	<a href="custAction!checkOrders?page=${page}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${requestScope.allpage>page}">
	<a href="custAction!checkOrders?page=${page+1}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<c:if test="${requestScope.allpage<page+1}">
	<a href="custAction!checkOrders?page=${requestScope.allpage}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<a href="custAction!checkOrders?page=${requestScope.allpage}&pagesize=${pagesize}">最后一页</a>
	转到<input value="${page}" size="2" id="page" />页
	<button width="20" onclick="goreload()">GO</button>
</div>
		</th>
	</tr>
	</table>
</body>
</html>