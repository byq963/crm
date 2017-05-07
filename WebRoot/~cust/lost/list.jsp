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
		if(/\D/.test(page)){
			alert("只能输入数字");
			return false;
		}
		if(/\D/.test(pagesize)){
			alert("只能输入数字");
			return false;
		}
		if(page<allpage+1){
		window.location.href="custLostAction!showFirst?page="+page+"&pagesize="+pagesize;
		}else{
			alert("输入的页数超过最大页数");
		}
	}
	function keydown(){
		var pagesize=document.getElementById("pagesize").value;
		if(/\D/.test(pagesize)){
			alert("只能输入数字");
			return false;
		}
		window.location.href="custLostAction!showFirst?page="+1+"&pagesize="+pagesize;
	}
	function query(){
		form1.submit();
	}
	
</script>
</head>
<body>

<div class="page_title">客户流失管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="query()">查询</button>  
</div>
<form action="custLostAction!showQuery" method="post" name="form1">
<table class="query_form_table">
	<tr>
		<th>客户</th>
		<td><input  name="custName"/></td>
		<th>客户经理</th>
		<td><input name="lostManagerName"/></td>
		<th>状态</th>
		<td>
			<s:select list="#request.dictionaryList" listKey="basiValue" listValue="basiItem" headerKey="0" headerValue="全部" name="lostStatus"></s:select>
		</td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>客户经理</th>
		<th>上次下单时间</th>
		<th>确认流失时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.custLostList" var="custLost1">
	<tr>
		<td class="list_data_number">${custLost1.lostNo}</td>
		<td class="list_data_text">${custLost1.custCustomer.custName}</td>
		<td class="list_data_ltext">${custLost1.lostManagerName}</td>
		<td class="list_data_text">${custLost1.lostLastOrderDate}</td>
		<td class="list_data_text">${custLost1.lostLastDate}</td>
		<s:iterator value="#request.dictionaryList" var="dictionary1">
		<c:if test="${dictionary1.basiValue==custLost1.lostStatus}">
		<td class="list_data_text">${dictionary1.basiItem}</td>
		</c:if>
		</s:iterator>
		<td class="list_data_op">
			<c:if test="${custLost1.lostStatus==2}">
			<img onclick="window.location.href='custLostAction!confirmInput?lostNo=${custLost1.lostNo}'" title="确认流失" src="images/bt_confirm.gif" class="op_button" />
			</c:if>
			<c:if test="${custLost1.lostStatus==1}">
			<img onclick="window.location.href='custLostAction!deferInput?lostNo=${custLost1.lostNo}'" title="暂缓流失" src="images/bt_relay.gif" class="op_button" />
			</c:if>
			
		</td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	<input type="hidden" value="${requestScope.allpage}" id="allpage"/>
	共${requestScope.count}条记录 每页<input value="${pagesize}" size="2" id="pagesize" onkeyup="keydown()" name="pagesize"/>条
	第${page}页/共${requestScope.allpage}页
	<a href="custLostAction!showFirst?page=1&pagesize=${pagesize}">第一页</a>
	<c:if test="${page>1}">
	<a href="custLostAction!showFirst?page=${page-1}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${page<2}">
	<a href="custLostAction!showFirst?page=${page}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${requestScope.allpage>page}">
	<a href="custLostAction!showFirst?page=${page+1}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<c:if test="${requestScope.allpage<page+1}">
	<a href="custLostAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<a href="custLostAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">最后一页</a>
	转到<input value="${page}" size="2" id="page" />页
	<button width="20" onclick="goreload()">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>