<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">
	$(function(){
		//设置分页要跳转到的url
		$("body").data("url","teacherAction_showPageResult.action");
		//声明分页的事件
		myUtils.basedata.initEvent();
		//声明删除的事件
			//针对button
		myUtils.basedata.deleteObj.deleteFunction({
			id:'deleteSome',
			checkboxname:'ids',//复选框id名字
			controlCheckBox:'controlCheckBox',
			url:'teacherJsonAction_deleteTeachers.action',
			successurl:'teacherAction_showPageResult.action' //删除成功后的跳转页面
		});
		myUtils.basedata.updateObj.updateFunction({
			url:"teacherAction_updateUI.action",
			id:"jsbh"
		});
		myUtils.basedata.deleteOneEvent.deleteOneFunction({
			url:"teacherJsonAction_deleteOne.action",
			checkid:"deleteOne",
			id:"jsbh",
			successurl:'teacherAction_showPageResult.action' //删除成功后的跳转页面
		});				
	});
</script>
</head>
<body>

<table id="userwrap">
	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="1000" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left"><input type="button" value="删除" id="deleteSome"/></td>
                </tr>
                <tr class="one" height="20">
                	<td><input type="checkbox" id="controlCheckBox"/></td>
                    <td width="300">教师号</td>
                    <td width="300">教师名称</td>
					<td width="150">性别</td>
					<td width="150">年龄</td>
					<td width="150">教师职称</td>
					<td width="200">联系电话</td>
					<td width="500">操作</td>
                </tr>
               <s:iterator value="#teachers.rows">
	                <tr align="center">
					   <td><input type="checkbox" name="ids" value="${jsbh}"/></td>
	                   <td><s:property value="jsbh"/></td>
	                   <td><s:property value="jsmc"/></td>
					   <td>
					   	<s:if test="sex==1">男</s:if>
						<s:if test="sex==2">女</s:if>
						<s:if test="sex==3">不详</s:if>
					   </td>
	                   <td><s:property value="age"/></td>
					   <td><s:property value="jszc"/></td>
	                   <td><s:property value="cellphone"/></td>
					   <td class="btn" align="center">
					   	<input type="submit" value="修改"/>
					    <input type="button" value="删除" id="deleteOne"/>
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
<div>
    <a href="teacherAction_addUI.action"><img src="${pageContext.request.contextPath}/images/createNew.png"/> </a>
</div>
</body>
</html>