<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生</title>
<script type="text/javascript">
	$(function(){
		//设置分页要跳转到的url
		$("body").data("url","courseAction_showPageResult.action");
		//声明分页的事件
		myUtils.basedata.initEvent();
		//声明删除的事件
			//针对button
		myUtils.basedata.deleteObj.deleteFunction({
			id:'deleteSome',
			checkboxname:'ids',//复选框id名字
			controlCheckBox:'controlCheckBox',
			url:'studentJsonAction_deleteStudents.action',
			successurl:'studentAction_showPageResult.action' //删除成功后的跳转页面
		});
		myUtils.basedata.updateObj.updateFunction({
			url:"studentAction_updateUI.action",
			id:"xuehao"
		});
		myUtils.basedata.deleteOneEvent.deleteOneFunction({
			url:"studentJsonAction_deleteOne.action",
			checkid:"deleteOne",
			id:"xuehao",
			successurl:'studentAction_showPageResult.action' //删除成功后的跳转页面
		});				
	});
</script>
</head>
<body>

<table id="userwrap">
	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="1300" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left"><input type="button" value="删除" id="deleteSome"/></td>
                </tr>
                <tr class="one" height="20">
                	<td><input type="checkbox" id="controlCheckBox"/></td>
                    <td width="300">学号</td>
                    <td width="300">姓名</td>
					<td width="150">性别</td>
					<td width="150">出生日期</td>
					<td width="150">入学日期</td>
					<td width="150">在校状态</td>
					<td width="200">联系电话</td>
					<td width="200">政治面貌</td>
					<td width="700">生源所在地</td>
					<td width="150">已修学分</td>
					<td width="500">操作</td>
                </tr>
               <s:iterator value="#students.rows">
	                <tr align="center">
					   <td><input type="checkbox" name="ids" value="${xuehao}"/></td>
	                   <td><s:property value="xuehao"/></td>
	                   <td><s:property value="name"/></td>
					   <td>
					   	<s:if test="sex==1">男</s:if>
						<s:if test="sex==2">女</s:if>
						<s:if test="sex==3">不详</s:if>
					   </td>
	                   <td><s:property value="csrq"/></td>
					   <td><s:property value="rxrq"/></td>
					   <td>
					   	<s:if test="statue==1">在读</s:if>
						<s:if test="statue==2">毕业</s:if>
						<s:if test="statue==3">停学</s:if>
						<s:if test="statue==4">退学</s:if>
						</td>
	                   <td><s:property value="cellphone"/></td>
					   <td><s:property value="zzmm"/></td>
					   <td><s:property value="syszd"/></td>
					   <td><s:property value="yxxf"/></td>
					   <td class="btn" align="center">
					   	<input type="submit" value="修改"/>
					    <input type="button" value="删除" id="deleteOne"/>
					   </td>
	                </tr>
				</s:iterator>
             </table>
            <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页"/>&nbsp;<input type="button" flag="prePage" param="${students.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${students.currentPage+1}" flag="nextPage" last="${students.totalPages}" value="下一页"/>&nbsp;<input type="button" param="${students.totalPages}" flag="lastPage" value="尾页"/>&nbsp;
		<span>转到第<input name="students.currentPage" id="pageNo" type="text" value="${students.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" id="skip" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${students.totalRows}条记录，当前第 ${students.currentPage}/${students.totalPages}页</p>
        </td>
    </tr>
</table>
<div>
    <a href="studentAction_addUI.action"><img src="${pageContext.request.contextPath}/images/createNew.png"/> </a>
</div>
</body>
</html>