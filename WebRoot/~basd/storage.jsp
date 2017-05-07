<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		window.location.href="storageAction!showFirst?page="+page+"&pagesize="+pagesize;
		}else{
			alert("输入的页数超过最大页数");
			return false;
		}
	}
	function keydown(){
		var pagesize=document.getElementById("pagesize").value;
		if(/\D/.test(pagesize)){
			alert("只能输入数字");
			return false;
		}
		window.location.href="storageAction!showFirst?page="+1+"&pagesize="+pagesize;
	}
	function query(){
		form1.submit();
	}
</script>
</head>
<body>

<div class="page_title">产品查询</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="query()">查询</button>  
</div>
<form action="storageAction!showFirst" method="post" name="form1" >
<table class="query_form_table">
	<tr>
		<th>产品</th>
		<td><input  name="prodName"/></td>
		<th>仓库</th>
		<td><input  name="storStorehouse"/></td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>产品</th>
		<th>仓库</th>
		<th>货位</th>
		<th>件数</th>
		<th>备注</th>
	</tr>
	<s:iterator value="#request.storageList" var="storage1">
	<tr>
		<td class="list_data_number">${storage1.storNo}</td>
		<td class="list_data_ltext">${storage1.product.prodName}</td>
		<td class="list_data_ltext">${storage1.storStorehouse}</td>
		<td class="list_data_text">${storage1.storLocation}</td>
		<td class="list_data_number">${storage1.storCount}</td>
		<td class="list_data_ltext">${storage1.storRemark}</td>		
	</tr>
	</s:iterator>
	<tr>
		<th colspan="100" class="pager">
<div class="pager">
	<input type="hidden" value="${requestScope.allpage}" id="allpage"/>
	共${requestScope.count}条记录 每页<input value="${pagesize}" size="2" id="pagesize" onkeyup="keydown()" name="pagesize"/>条
	第${page}页/共${requestScope.allpage}页
	<a href="storageAction!showFirst?page=1&pagesize=${pagesize}">第一页</a>
	<c:if test="${page>1}">
	<a href="storageAction!showFirst?page=${page-1}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${page<2}">
	<a href="storageAction!showFirst?page=${page}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${requestScope.allpage>page}">
	<a href="storageAction!showFirst?page=${page+1}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<c:if test="${requestScope.allpage<page+1}">
	<a href="storageAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<a href="storageAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">最后一页</a>
	转到<input value="${page}" size="2" id="page" />页
	<button width="20" onclick="goreload()">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>