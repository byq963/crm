<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<script type="text/javascript">
      function save()
      {
          var roleName=document.getElementById("sysRole1.roleName").value.length;
           if(roleName==0){
          	alert("角色名不能为空");
             return false;
          }
          form1.submit();
      }

      function back(){
         window.history.back();
      }
      function selectAll(){
        var rights=document.getElementsByName("rightCodes");
        for(var i=0;i<rights.length;i++){
            rights[i].checked=true;
        }  
      }
      function selectNone(){
        var rights=document.getElementsByName("rightCodes");
        for(var i=0;i<rights.length;i++){
            rights[i].checked=false;
        } 
      }
  </script>
 </head>
 <body>
   <div class="page_title">角色管理-新建角色</div>
   <div class="button_bar">
	<div class="button_bar">
	<button class="common_button" onclick="help('');">关于</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="save();">保存</button> 
    </div>
   </div>
   <form action="userAction!addRole"  name="form1" method="post">
   <table class="query_form_table">
	<tr>
		<th>角色</th>
		<td><input type="text" id="roleName" name="sysRole1.roleName"  size="25" maxlength="32" value="${requestScope.roleName }"/>
		<div id="error"><font color="red"><s:property value="#request.error"/></font></div>
		</td>
		<th>描述</th>
		<td><input type="text"  name="sysRole1.roleDesc"  size="25" maxlength="32" value="${requestScope.roleDesc }"/></td>
	 </tr>
	 <tr>
	    <th>权限</th>
	    <td colspan="3">
	      <s:iterator var="Right" value="#request.rightList">
	         <s:iterator var="i" begin="1" end="#Right.rightCode.length()" step="1">
	           &nbsp;
	         </s:iterator>
	         <s:property value="#Right.rightText"/>
	         <input id="roleRights" name="rightCodes" type="checkbox" value="<s:property value='#Right.rightCode'/>" />
	         <br/>
	      </s:iterator>
	    </td>   
	 </tr>
	 <tr>
	     <td colspan="4" style="text-align: center;">
	       <input type="button" value="全选" onclick="selectAll()" />
	       <input type="button" value="全不选" onclick="selectNone()"/>
	     </td>
	 </tr>
    </table><br/>
  </form>
 </body>
</html>
