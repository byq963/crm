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
	function updateCust(){
	var custName=document.getElementById("custName").value;
	var custManagerName=document.getElementById("custManagerName").value;
	if(custName==""){
		alert("客户名称不能为空");
		return false;
	}
	if(custManagerName==""){
		alert("客户经理不能为空");
		return false;
	}
	form1.submit();
	}
</script>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="window.location.href='custAction!checkLinkman?custNo=${cust.custNo}'">联系人</button>
	<button class="common_button" onclick="window.location.href='custAction!checkRecord?custNo=${cust.custNo}'">交往记录</button>
	<button class="common_button" onclick="window.location.href='custAction!checkOrders?custNo=${cust.custNo}'">历史订单</button>
	
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="updateCust()">保存</button>
</div>
<form action="custAction!updateCust" method="post" name="form1">
<input type="hidden" name="customer.custNo" value="${cust.custNo}"/>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td>${cust.custNo}</td>
		<th>名称</th>
		<td><input value="${cust.custName}" name="customer.custName" id="custName"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地区</th>
		<td>
		<s:iterator value="#request.regList" var="reg1" status="stauts">
		<c:if test="${reg1.basiValue==cust.custRegion}">
			<s:select list="#request.regList" listKey="basiValue" listValue="basiItem" name="customer.custRegion"  value="#request.regList.get(#stauts.count-1).basiValue"/>
		</c:if>
		</s:iterator>
			<span class="red_star">*</span></td>
		<th>客户经理</th>
		<td>
			<input value="${cust.custManagerName}" name="customer.custManagerName" id="custManagerName"/><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>客户等级</th>
		<td>
		<s:iterator value="#request.levList" var="lev1" status="stauts">
		<c:if test="${lev1.basiValue==cust.custLevel}">
			<s:select list="#request.levList" listKey="basiValue" listValue="basiItem" name="customer.custLevel"  value="#request.levList.get(#stauts.count-1).basiValue"/>
		</c:if>
		</s:iterator>
			<span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
	<tr>
		<th>客户满意度</th>
		<td>
		<s:iterator value="#request.satiList" var="sati1" status="stauts">
		<c:if test="${sati1.basiValue==cust.custSatisfy}">
			<s:select list="#request.satiList" listKey="basiValue" listValue="basiItem" name="customer.custSatisfy"  value="#request.satiList.get(#stauts.count-1).basiValue"/>
		</c:if>
		</s:iterator>
			<span class="red_star">*</span>
		</td>
		<th>客户信用度</th>
		<td>
		<s:iterator value="#request.conList" var="con1" status="stauts">
		<c:if test="${con1.basiValue==cust.custCredit}">
			<s:select list="#request.conList" listKey="basiValue" listValue="basiItem" name="customer.custCredit"  value="#request.conList.get(#stauts.count-1).basiValue"/>
		</c:if>
		</s:iterator><span class="red_star">*</span>
		</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>地址</th>
		<td><input value="${cust.custAddress}"  name="customer.custAddress"/><span class="red_star">*</span>
		</td>
		<th>邮政编码</th>
		<td><input value="${cust.custZip}" name="customer.custZip" size="20" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>电话</th>
		<td>
			<input value="${cust.custTelephone}" name="customer.custTelephone" size="20"  /><span class="red_star">*</span></td>
		<th>传真</th>
		<td>
			<input value="${cust.custFax}" name="customer.custFax" size="20"  /><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>网址</th>
		<td>
			<input value="${cust.custWebsite}" name="customer.custWebsite" size="20"  /><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>营业执照注册号</th>
		<td><input value="${cust.custLicencNo}" name="customer.custLicencNo" size="20" /></td>
		<th>法人</th>
		<td><input value="${cust.custCorporation}" name="customer.custCorporation" size="20" /><span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>注册资金（万元）</th>
		<td>
			<input value="${cust.custRegisteredCapital}" name="customer.custRegisteredCapital" size="20" /> </td>
		<th>年营业额</th>
		<td>
			<input value="${cust.custTurnover}" name="customer.custTurnover" size="20" />
		</td>
	</tr>	
	<tr>
		<th>开户银行</th>
		<td>
			<input value="${cust.custBank}" name="customer.custBank" size="20" /><span class="red_star">*</span>
		</td>
		<th>银行帐号</th>
		<td><input value="${cust.custBankAccount}" name="customer.custBankAccount" size="20" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地税登记号</th>
		<td>
			<input value="${cust.custLocalTaxNo}" name="customer.custLocalTaxNo" size="20" /></td>
		<th>国税登记号</th>
		<td><input value="${cust.custNationalTaxNo}" name="customer.custNationalTaxNo" size="20" /></td>
	</tr>
</table>
</form>
<p>　</p>
</body>
</html>