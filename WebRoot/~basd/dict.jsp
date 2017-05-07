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
	
		var newpage = parseInt(allpage)+1;
		if(/\D/.test(page)){
			alert("只能输入数字");
			return false;
		}
		if(/\D/.test(pagesize)){
			alert("只能输入数字");
			return false;
		}
		if(page<newpage){
			
			alert("进来了");
			window.location.href="dictionaryAction!showFirst?page="+page+"&pagesize="+pagesize;
			
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
		if(pagesize>count){
			alert("超过了最大条数!");
			return false;
		}
		window.location.href="dictionaryAction!showFirst?page="+1+"&pagesize="+pagesize;
	}
	function query(){
		form1.submit();
	}
</script>
</head>
<body>

<div class="page_title">数据字典管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="window.location.href='dictionaryAction!addDictionaryInput'">新建</button>
	<button class="common_button" onclick="query()">查询</button>  
</div>
<form action="dictionaryAction!showQuery" method="post" name="form1">
<table class="query_form_table">
	<tr>
		<th>类别</th>
		<td><input  name="basiType" /></td>
		<th>条目</th>
		<td><input  name="basiItem" /></td>
		<th>值</th>
		<td><input  name="basiValue" /></td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>类别</th>
		<th>条目</th>
		<th>值</th>
		<th>是否可编辑</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.dictionaryList" var="dictionary1">
	<c:if test="${dictionary1.basiEditable==0 }">
	<tr>
		<td class="list_data_number">${dictionary1.basiNo}</td>
		<td class="list_data_ltext">${dictionary1.basiType}</td>
		<td class="list_data_text">${dictionary1.basiItem}</td>
		<td class="list_data_text">${dictionary1.basiValue}</td>
		<td class="list_data_text">否</td>
		<td class="list_data_op">　</td>
	</tr>
	</c:if>
	<c:if test="${dictionary1.basiEditable==1 }">
		<tr>
			<td class="list_data_number">${dictionary1.basiNo}</td>
			<td class="list_data_ltext">${dictionary1.basiType}</td>
			<td class="list_data_text">${dictionary1.basiItem}</td>
			<td class="list_data_text">${dictionary1.basiValue}</td>
			<td class="list_data_text">是</td>
			<td class="list_data_op">
				<img onclick="window.location.href='dictionaryAction!updateInput?basiNo=${dictionary1.basiNo}'" title="编辑" src="images/bt_edit.gif" class="op_button" />
				<img onclick="window.location.href='dictionaryAction!delete?basiNo=${dictionary1.basiNo}'" title="删除" src="images/bt_del.gif" class="op_button" />
			</td>
		</tr>
	</c:if>
	</s:iterator>
	<tr>
		<th colspan="6" class="pager">
<div class="pager">
	<input type="hidden" value="${requestScope.allpage}" id="allpage"/>
	共${requestScope.count}条记录 每页<input value="${pagesize}" size="2" id="pagesize" onkeyup="keydown()"/>条
	第${page}页/共${requestScope.allpage}页
	<a href="dictionaryAction!showFirst?page=1&pagesize=${pagesize}">第一页</a>
	<c:if test="${page>1}">
	<a href="dictionaryAction!showFirst?page=${page-1}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${page<2}">
	<a href="dictionaryAction!showFirst?page=${page}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${requestScope.allpage>page}">
	<a href="dictionaryAction!showFirst?page=${page+1}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<c:if test="${requestScope.allpage<page+1}">
	<a href="dictionaryAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<a href="dictionaryAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">最后一页</a>
	转到<input value="${page}" size="2" id="page" />页
	<button width="20" onclick="goreload()">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>