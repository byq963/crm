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
	function updateDictionary(){
		var basiType=document.getElementById("basiType").value;
		var basiItem=document.getElementById("basiItem").value;
		var basiValue=document.getElementById("basiValue").value;
		var basiEditable=document.getElementById("basiEditable").value;
		if(basiType==""){
			alert("类型不能为空");
			return false;
		}
		if(basiItem==""){
			alert("标题不能为空");
			return false;
		}
		if(basiValue==""){
			alert("内容不能为空");
			return false;
		}
		if(basiEditable==""){
			alert("内容不能为空");
			return false;
		}
		form1.submit();
	}
</script>
</head>
<body>

<div class="page_title">数据字典管理 > 编辑数据字典条目</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="updateDictionary()">保存</button>  
</div>
<form action="dictionaryAction!updateDictionary" method="post" name="form1">

<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${dictionary.basiNo}<input type="hidden" value="${dictionary.basiNo}" name="dictionary.basiNo"/></td>
		<th>类别</th>
		<td><input name="dictionary.basiType" id="basiType" value="${dictionary.basiType}"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>条目</th>
		<td><input value="${dictionary.basiItem}" name="dictionary.basiItem" id="basiItem"/><span class="red_star">*</span></td>
		<th>值</th>
		<td><input value="${dictionary.basiValue}" name="dictionary.basiValue" id="basiValue"/><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>是否可编辑</th>
		
		<c:if test="${dictionary.basiEditable==1}">
		<td>
		<input type="radio" name="dictionary.basiEditable" id="basiEditable" value="1" checked="checked"/>是
		<input type="radio" name="dictionary.basiEditable" id="basiEditable" value="0"/>否</td>
		</c:if>
		<c:if test="${dictionary.basiEditable==0}">
		<td>
		<input type="radio" name="dictionary.basiEditable" id="basiEditable" value="1"/>是
		<input type="radio" name="dictionary.basiEditable" id="basiEditable" value="0" checked="checked"/>否</td>
		</c:if>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
</body>
</html>