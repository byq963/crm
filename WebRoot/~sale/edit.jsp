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
	function save() {
		var chanCustName=document.getElementById("chanCustName").value;
		var chanRate=document.getElementById("chanRate").value;
		var chanTitle=document.getElementById("chanTitle").value;
		var chanMoblie=document.getElementById("chanMoblie").value;
		var chanDescription=document.getElementById("chanDescription").value;
		//验证电话号码格式
		var reg=/^1\d{10}$/;
		//验证成功机率
		var reg1=/[1-9]?\d{1}$/;
		if(chanCustName==""){
			alert("客户名称不能为空");
			return false;
		}
		if(chanRate==""){
			alert("成功机率不能为空");
			return false;
		}
		if(!reg1.test(chanRate)){
			alert("机率格式不正确");
			return false;
		}
		if(chanTitle==""){
			alert("概要不能为空");
			return false;
		}
		
		if(chanDescription==""){
			alert("机会描述不能为空");
			return false;
		}
		if(chanMoblie!=""&&!reg.test(chanMoblie)){
			alert("电话号码格式是11个数字");
			return false;
		}
		form4.submit();
	}
</script>
</head>
<body>
	<div class="page_title">销售机会管理&nbsp; &gt; 编辑销售机会</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="save()">保存</button>
	</div>
	<form action="saleChanceAction!update" method="post" name="form4">
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input readonly value="${request.saleChance.chanNo}"
					name="saleChance.chanNo" />
				</td>
				<th>机会来源</th>
				<td><input size="20" value="${request.saleChance.chanSource}"
					name="saleChance.chanSource" />
				</td>
			</tr>
			<tr>
				<th>客户名称</th>
				<td><input value="${request.saleChance.chanCustName}"
					name="saleChance.chanCustName" id="chanCustName" /><span
					class="red_star">*</span>
				</td>
				<th>成功机率（%）</th>
				<td><input value="${request.saleChance.chanRate}"
					name="saleChance.chanRate" id="chanRate" /><span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>概要</th>
				<td colspan="3"><input value="${request.saleChance.chanTitle}"
					name="saleChance.chanTitle" size="52" id="chanTitle" id="chanTitle"/><span
					class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>联系人</th>
				<td><input name="saleChance.chanLinkman"
					value="${request.saleChance.chanLinkman}" size="20" />
				</td>
				<th>联系人电话</th>
				<td><input name="saleChance.chanMoblie"
					value="${request.saleChance.chanMoblie}" size="20" id="chanMoblie" />
				</td>
			</tr>
			<tr>
				<th>机会描述</th>
				<td colspan="3"><textarea rows="6" cols="50"
						name="saleChance.chanDescription" id="chanDescription">${request.saleChance.chanDescription}</textarea><span
					class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>创建人</th>
				<td><input name="saleChance.chanCreateBy"
					value="${request.saleChance.chanCreateBy}" readonly size="20" /><span
					class="red_star">*</span>
				</td>
				<th>创建时间</th>
				<td><input id="t1" name="saleChance.chanCreateDate"
					value="${request.saleChance.chanCreateDate}" readonly size="20" /><span
					class="red_star">*</span>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table disabled class="query_form_table" id="table1">
		<tr>
			<th>指派给</th>
			<td><select name="D1">
					<option>请选择...</option>
					<option>小明</option>
					<option>旺财</option>
					<option>球球</option>
					<option>孙小美</option>
					<option>周洁轮</option>
			</select> <span class="red_star">*</span>
			</td>
			<th>指派时间</th>
			<td><input id="t2" name="T20" readonly size="20" /><span
				class="red_star">*</span>
			</td>
		</tr>
	</table>
	<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</body>
</html>