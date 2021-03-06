<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色信息</title>
<script type="text/javascript">
	$(function(){
		//声明删除的事件
		myUtils.basedata.deleteObj.deleteFunction({
			id:'deleteSome',
			checkboxname:'ids',//复选框id名字
			controlCheckBox:'controlCheckBox',
			url:'roleJsonAction_deleteRoles.action',
			successurl:'roleAction_showRoles.action' //删除成功后的跳转页面
		});
		myUtils.basedata.updateObj.updateFunction({
			url:"roleAction_updateUI.action",
			id:"rid"
		});
		myUtils.basedata.deleteOneEvent.deleteOneFunction({
			url:"roleJsonAction_deleteOne",
			checkid:"deleteOne",
			id:"rid",
			successurl:'roleAction_showRoles.action' //删除成功后的跳转页面
		});	
			
	})
</script>
</head>
<body>

<table id="userwrap">
	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="900" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left"><input type="button" value="删除" id="deleteSome"/></td>
                </tr>
                <tr class="one" height="20">
                	<td><input type="checkbox" id="controlCheckBox"/></td>
                    <td width="200">角色名</td>
                    <td width="500">角色描述</td>
					<td width="300">操作</td>
                </tr>
               <s:iterator value="#roles">
	                <tr align="center">
					   <td><input type="checkbox" name="ids" value="${rid}"/></td>
	                   <td><s:property value="name"/></td>
	                   <td><s:property value="description"/></td>
					   <td class="btn" align="center">
					   	<input type="submit" value="修改"/>
					    <input type="button" value="删除" id="deleteOne"/>
					   </td>
	                </tr>
				</s:iterator>
             </table>
        </td>
    </tr>
</table>
<div>
    <a href="roleAction_addUI.action"><img src="${pageContext.request.contextPath}/images/createNew.png"/> </a>
</div>
</body>
</html>