<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
          var roleName=document.getElementById("roleName").value.length;
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
   <div class="page_title">角色管理-编辑角色</div>
   <div class="button_bar">
	<div class="button_bar">
	<button class="common_button" onclick="about();">关于</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="save();">保存</button> 
    </div>
   </div>
   <form action="userAction!updateSysRole" name="form1" method="post">
   <table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><s:property value="#request.sysRole.roleId"/><input type="hidden" name="roleId" value="<s:property value='#request.sysRole.roleId'/>"/></td>
		<th>角色</th>
		<td><input id="roleName" type="text" name="roleName"  size="25" maxlength="32" value="<s:property value='#request.sysRole.roleName'/>"/><font color="red">*</font></td>
	 </tr>
	 <tr>
	    <th>权限</th>
	    <td colspan="3">
	      <s:iterator var="Right" value="#request.rightList">
	         <s:iterator var="i" begin="1" end="#Right.rightCode.length()" step="1">
	           &nbsp;
	         </s:iterator>
	         <s:property value="#Right.rightText"/>
	         <input  name="rightCodes" type="checkbox" value="<s:property value='#Right.rightCode'/>" 
	         <s:iterator var="rights" value="#request.sysRole.sysRoleRights">
				<s:property value="#rights.sysRight.rightCode==#Right.rightCode?'checked':''"/>
			</s:iterator>/> 
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
