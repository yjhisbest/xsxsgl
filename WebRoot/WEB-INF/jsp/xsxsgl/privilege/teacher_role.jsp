<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/style_customer.css"/>
<title>无标题文档</title>
<script type="text/javascript">
	$(function(){
		//设置分页要跳转到的url
		$("body").data("url","roleAction_skipSetRole.action");
		//声明分页的事件
		myUtils.basedata.initEvent();
		//设置权限，跳出div框选择添加权限
		myUtils.privilege.divRoleFrame(); 
	});
</script>
</head>
<body>

<table id="userwrap">
	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="900" style=" overflow:auto; height:30px;">
                <tr class="one" height="20">
                    <td width="200">教师号</td>
                    <td width="200">教师名称</td>
					<td width="200">角色名</td>
					<td width="200">操作</td>
                </tr>
               <s:iterator value="#teachers.rows">
	                <tr align="center">
	                   <td><s:property value="jsbh"/></td>
	                   <td><s:property value="jsmc"/></td>
	                   <td rolename='rolename'><s:property value="rolename"/></td>
					   <td class="btn" align="center">
					   	<input type="button" value="设置角色" class="setRole" jsbh="${jsbh }"/>
					   </td>
	                </tr>
				</s:iterator>
             </table>
            <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页"/>&nbsp;<input type="button" flag="prePage" param="${teachers.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${teachers.currentPage+1}" flag="nextPage" last="${teachers.totalPages}" value="下一页"/>&nbsp;<input type="button" param="${teachers.totalPages}" flag="lastPage" value="尾页"/>&nbsp;
		<span>转到第<input name="teachers.currentPage" id="pageNo" type="text" value="${teachers.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" id="skip" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${teachers.totalRows}条记录，当前第 ${teachers.currentPage}/${teachers.totalPages}页</p>
        </td>
    </tr>
</table>
<div id="seek">
    <div class="seek_con_top">
	     <h5>角色信息</h5>
	     <span class="seek_close"></span>
	</div>
	<div class="seek_con">
	     <div style="overflow:scroll; overflow-x:hidden; height:275px;border:1px solid #898989;width:800px">
	          <table cellpadding="0" cellspacing="0" id="maintain-top" align="center"  width="800" style=" font-size:12px; height:50px;text-align: center;">
	            <tr>
	              <td width="150" item="radio">选择</td>
	              <td width="300" item="name">角色名称</td>
				  <td width="500" item="description">角色描述</td>
				</tr>
	           </table>
	       </div>
	       <div class="btns">
                <button class="btn">确定</button>
           </div>
	  </div>
</div>
</body>
</html>