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
		window.location.href="custAction!showFirst?page="+page+"&pagesize="+pagesize;
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
		window.location.href="custAction!showFirst?page="+1+"&pagesize="+pagesize;
	}
	function query(){
		form1.submit();
	}
</script>
</head>
<body>

<div class="page_title">客户信息管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="query()">查询</button>  
</div>
<form action="custAction!showQuery" name="form1" method="post">
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><input name="custNo" /></td>
		<th>名称</th>
		<td><input name="custName" /></td>
		<th>地区</th>
		<td>
			<s:select list="#request.regList" listKey="basiValue" listValue="basiItem" name="custRegion" headerKey="0" headerValue="全部"></s:select>
		</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td><input name="custManagerName" /></td>
		<th>客户等级</th>
		<td>
			<s:select list="#request.levList" listKey="basiValue" listValue="basiItem" name="custLevel" headerKey="0" headerValue="全部"></s:select>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>客户编号</th>
		<th>名称</th>
		<th>地区</th>
		<th>客户经理</th>
		<th>客户等级</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.custList" var="cust1" status="status">
	<tr>
		<td class="list_data_number"><s:property value="#status.count"/></td>
		<td class="list_data_text">${cust1.custNo}</td>
		<td class="list_data_ltext">${cust1.custName}</td>
		<s:iterator value="#request.regList" var="reg1">
		<c:if test="${reg1.basiValue==cust1.custRegion}">
		<td class="list_data_text">${reg1.basiItem}</td>
		</c:if>
		</s:iterator>
		<td class="list_data_text">${cust1.custManagerName}</td>
		<s:iterator value="#request.levList" var="lev1">
		<c:if test="${lev1.basiValue==cust1.custLevel}">
		<td class="list_data_text">${lev1.basiItem}</td>
		</c:if>
		</s:iterator>
		<td class="list_data_op">
			<img onclick="window.location.href='custAction!updateInput?custNo=${cust1.custNo}'" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="window.location.href='custAction!checkLinkman?custNo=${cust1.custNo}'" title="联系人" src="images/bt_linkman.gif" class="op_button" />
			<img onclick="window.location.href='custAction!checkRecord?custNo=${cust1.custNo}'" title="交往记录" src="images/bt_acti.gif" class="op_button" />
			<img onclick="window.location.href='custAction!checkOrders?custNo=${cust1.custNo}'" title="历史订单" src="images/bt_orders.gif" class="op_button" />
			
			<img onclick="window.location.href='custAction!deleteCust?custNo=${cust1.custNo}'" title="删除" src="images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</s:iterator>
	
	<tr>
		<th colspan="100" class="pager">
<div class="pager">
	<input type="hidden" value="${requestScope.count}" id="count"/>
	<input type="hidden" value="${requestScope.allpage}" id="allpage"/>
	共${requestScope.count}条记录 每页<input value="${pagesize}" size="2" id="pagesize" onkeyup="keydown()" name="pagesize"/>条
	第${page}页/共${requestScope.allpage}页
	<a href="custAction!showFirst?page=1&pagesize=${pagesize}">第一页</a>
	<c:if test="${page>1}">
	<a href="custAction!showFirst?page=${page-1}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${page<2}">
	<a href="custAction!showFirst?page=${page}&pagesize=${pagesize}">上一页</a>
	</c:if>
	<c:if test="${requestScope.allpage>page}">
	<a href="custAction!showFirst?page=${page+1}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<c:if test="${requestScope.allpage<page+1}">
	<a href="custAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">下一页</a>
	</c:if>
	<a href="custAction!showFirst?page=${requestScope.allpage}&pagesize=${pagesize}">最后一页</a>
	转到<input value="${page}" size="2" id="page" />页
	<button width="20" onclick="goreload()">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>