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
		if(page<(allpage+1)){
		window.location.href="serviceManagerAction!showClassify?page="+page+"&pagesize="+pagesize;
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
		window.location.href="serviceManagerAction!showClassify?page="+1+"&pagesize="+pagesize;
	}
	function query(){
		form1.submit();
	}
	
</script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务归档</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="query();">查询</button>  
</div>
<form action="serviceManagerAction!showClassify" method="post" name="form1">
<table class="query_form_table">
	<tr>
		<th height="28">客户</th>
		<td><input name="servCustName" /></td>
		<th height="28">概要</th>
		<td><input  name="servTitle" /></td>
		<th height="28">服务类型</th>
		<td>
			<s:select list="#request.serviceTypeList" name="servType" listKey="basiValue" listValue="basiItem" headerKey="3" headerValue="全部"></s:select>
		</td>
	</tr>
	<tr>
		<th height="32">创建日期</th>
		<td colspan="3">
			<input name="servCreateDate1"  size="10" /> - <input name="servCreateDate2"  size="10" /></td>
		<th height="32">状态</th>
		<td>
		<s:select list="#request.serviceStatusList" name="servStatus" listKey="basiValue" listValue="basiItem" headerKey="0" headerValue="全部" value="servStatus"></s:select>
		</td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>概要</th>
		<th>服务类型</th>
		<th>创建人</th>
		<th>创建日期</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.serviceList" var="service1" status="status">
	<tr>
		<td class="list_data_number">${service1.servNo}</td>
		<td class="list_data_text">${service1.servCustName}</td>
		<td class="list_data_ltext">${service1.servTitle}</td>
		<s:iterator value="#request.serviceTypeList" var="serviceType1">
		<c:if test="${serviceType1.basiValue==service1.servType}">
		<td class="list_data_text">${serviceType1.basiItem}</td>
		</c:if>
		</s:iterator>
		<td class="list_data_text">${service1.servCreateBy}</td>
		<td class="list_data_text">${service1.servCreateDate}</td>
		<td class="list_data_op">
						
			<img onclick="window.location.href='serviceManagerAction!checkService?servNo=${service1.servNo}'" title="查看" src="images/bt_detail.gif" class="op_button" /></td>
	</tr>
	</s:iterator>
	<tr>
	
		<th colspan="8" class="pager">
<div class="pager">
	<input type="hidden" value="${requestScope.allpage}" id="allpage"/>
	共${requestScope.count}条记录 每页<input value="${pagesize}" size="2" id="pagesize" onkeyup="keydown()" name="pagesize"/>条
	第${page}页/共${requestScope.allpage}页
	<a href="serviceManagerAction!showClassify?page=1&pagesize=${pagesize}">第一页</a>
	<c:if test="${page>1}">
	<a href="serviceManagerAction!showClassify?page=${page-1}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${page<2}">
	<a href="serviceManagerAction!showClassify?page=${page}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${requestScope.allpage>page}">
	<a href="serviceManagerAction!showClassify?page=${page+1}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<c:if test="${requestScope.allpage<page+1}">
	<a href="serviceManagerAction!showClassify?page=${requestScope.allpage}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<a href="serviceManagerAction!showClassify?page=${requestScope.allpage}&pagesize=${pagesize}">最后一页</a>
	转到<input value="${page}" size="2" id="page" />页
	<button width="20" onclick="goreload()">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>